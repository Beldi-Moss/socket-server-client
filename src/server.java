import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class server {

	static ServerSocket server = null;
	static int port=3234;

	public static void main(String[]args) throws IOException{
		
		try{
		server=new ServerSocket(port);

		}catch(Exception e) {
			System.out.println("server creation failed ");
	

		}
		while(true){
			Socket client=null;
	  try {
		  System.out.println("Server wait for client to connect");

		  client=server.accept();
	  } catch (IOException e) {
		System.out.println("client can't connect");
 return;	}
	
		clientdata(client);
	}}
	
	private static void clientdata(Socket client) throws IOException {

		PrintWriter  out=new PrintWriter(client.getOutputStream());
		out.print("s");
		BufferedReader in=new BufferedReader( new InputStreamReader(client.getInputStream()));
		
		String msg=in.readLine();

		System.out.println("message from client = \n\t"+msg );
		try {
		out.println("fuck off bitch \n");
		out.close();
		}catch (Exception e){
			System.out.println("server can't send to client");
		}		
	}
}
