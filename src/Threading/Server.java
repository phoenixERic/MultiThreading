package Threading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public void run()
	{
		int port =8010;
		try {
			ServerSocket socket = new ServerSocket(port);
			socket.setSoTimeout(10000);
			while(true)
			{
				try {
					System.out.println("Server is listening on port" + port);
					Socket acceptedConnection= socket.accept();
					System.out.println("Connection acception from client" + acceptedConnection.getRemoteSocketAddress());
					PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
					BufferedReader fromClient=new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
					toClient.println("Helllo from the server ");
					toClient.close();
					fromClient.close();
					acceptedConnection.close();
					System.out.print("Closing socket");
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	public static void main(String[] args) {
		
		Server server =new Server();
		try {
			server.run();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
}
