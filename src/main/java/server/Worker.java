package server;


import DAO.impl.MonHocDAO;
import Service.MonHocService;
import Service.main;
import Service.tkb;
import com.mysql.cj.xdevapi.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Worker implements Runnable {

	private final int id;
	private final Socket socket;
	private final BufferedReader in;
	private final BufferedWriter out;

	public Worker(int index, Socket sk) throws IOException {
		id = index;
		socket = sk;
		in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));

	}


	public String receive() throws IOException {
		String input = in.readLine();
		if (input == null)
			return "";
		return input;
	}

	public void send(String mes) throws IOException {
		out.write(mes);
		out.newLine();
		out.flush();
	}


	private void close() throws IOException {
		System.out.println("Closed socket for client ["+id+"] " + socket.toString());
		in.close();
		out.close();
		socket.close();
	}



	public void run() {

		System.out.println("Client ["+id+"]: "+socket.getInetAddress().getHostName() +" accepted.");
		try
		{

			while (true)
			{
				String input = receive();
				if (input.isEmpty())
					continue;

				System.out.println("[Client] "+input);
				StringTokenizer stk = new StringTokenizer(input);
				String cmd = stk.nextToken();

				if (cmd.equals("bye"))
					break;

				if(input.equals("hello")){
                                    MonHocService mhs = new MonHocService();
                                    send(new JSONArray(mhs.monHocDTOs()).toString());
				}else {
					String[] request=input.split(";");
					List<String> temp=new ArrayList<>();
					for(int mh =0;mh<request.length;mh++){
						temp.add(request[mh]);
					}
					List<List<tkb>>  result= main.mainProcess(temp);
					if(!result.isEmpty()){

						send( new JSONArray(result).toString());;
					}
				}
				// TODO

			}
			close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}


}
