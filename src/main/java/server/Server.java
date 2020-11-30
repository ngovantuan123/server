package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server
{
	public static final int port = 1234;
	public static final int MAX_CLIENT = 32; // TODO inceate to 32
	private static ServerSocket server = null;
	public static Vector<Worker> workers = new Vector<>();


	public static void main(String[] args) throws IOException {
		ExecutorService executor = Executors.newFixedThreadPool(MAX_CLIENT + 1);
		try {
			server = new ServerSocket(port);


			System.out.println("Server binding at port " + port + "\nServer ready.");
			while(true) {
				Socket socket = server.accept();
				int id = workers.size();
				Worker client = new Worker(id, socket);
				workers.add(client);
				executor.execute(client);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			executor.shutdown();
			if(server != null)
				server.close();
		}
	}
}
