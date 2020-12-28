package server;


import DAO.impl.MonHocDAO;
import Service.MonHocService;
import Service.main;
import Service.tkb;
import Utils.Crypto;
import com.mysql.cj.xdevapi.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;


public class Worker implements Runnable {

    private final int id;
    private final Socket socket;
    private final BufferedReader in;
    private final BufferedWriter out;
    public static Crypto crypto;

    public Worker(int index, Socket sk) throws IOException {
        id = index;
        socket = sk;
        in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
        crypto= new Crypto();
    }


    public String receive() throws IOException {

        String input = in.readLine();
        if (input == null) {
            return "";
        }
        return crypto.decrypt(input);
    }

    public void send(String mes) throws IOException {
        try {
            out.write(crypto.encrypt(mes));
            out.newLine();
            out.flush();
        } catch (IOException e) {}
    }


    private void close() throws IOException {
        System.out.println("Closed socket for client [" + id + "] " + socket.toString());
        in.close();
        out.close();
        socket.close();
    }


    public void run() {

        System.out.println("Client [" + id + "]: " + socket.getInetAddress().getHostName() + " accepted.");
        try {

            while (true) {
                String input = receive();
                if (input.isEmpty())
                    continue;

                System.out.println("[Client] " + input);
                StringTokenizer stk = new StringTokenizer(input);
                String cmd = stk.nextToken();

                if (cmd.equals("bye"))
                    break;

                if (input.startsWith("Khoa#")) {
                	String maKhoa = input.split("#")[1];
                    MonHocService mhs = new MonHocService();
                    //send(new JSONArray(mhs.monHocDTOs()).toString());
                    send(new JSONArray(mhs.getMonHocByKhoa(maKhoa)).toString());
                }
                else if(input.startsWith("xepthoikhoabieu#")){

                    String[] maMH = input.split("#");
                    main.truonghopList.clear();
                    main.tmp_inner.clear();
                    main.tmp_outer.clear();
                    main.output.clear();
                    MonHocService mhs = new MonHocService();
                    String[] mamhs = maMH[1].split(";");
                    List<String> r = new ArrayList<>();
                    for (int i = 0; i < mamhs.length; i++) {
                        r.add(mamhs[i]);
                    }
                    Map<String,List<tkb>> t = new LinkedHashMap<>();
                    t = main.mainProcess(r);
                    while(r.size()>1){
                        main.truonghopList.clear();
                        main.tmp_inner.clear();
                        main.tmp_outer.clear();
                        main.output.clear();
                        if(t.get("binhthuong").isEmpty()){
                            r.remove(r.get(r.size()-1));
                            t = main.mainProcess(r);
                        }else{
                            break;
                        }
                    }


                    send(new JSONObject(t).toString());
                }
                else if(input.startsWith("Chitiet#")){
                    String maMH = input.split("#")[1];
                    MonHocService mhs = new MonHocService();

                    send(new JSONArray(mhs.getNhomsByMaMH(maMH)).toString());

                }
                // TODO

            }
            close();
        } catch (IOException e) {
            if(e instanceof SocketException){
                System.out.println("Client [" + id + "]: " + socket.getInetAddress().getHostName() + " closed.");
                Server.workers.remove(this);
            }
            System.out.println(e);
        }
    }


}
