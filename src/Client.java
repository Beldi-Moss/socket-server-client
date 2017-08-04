import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	
	public static void main(String []args ) throws IOException{
		Socket client=null;
		String serverhost="localhost";
		int port =1234;
		
		try {
			client=new Socket(serverhost,3234);
		} catch (IOException e) {
			System.out.print("error client can't connect to server");
			e.printStackTrace();
		}
		PrintStream out=new PrintStream(client.getOutputStream());
		InputStreamReader input=new InputStreamReader(client.getInputStream());
		BufferedReader r=new BufferedReader(input);

	    System.out.println("sending request");
		
		String msg="kk \n\n\n";
		out.print(msg);

		System.out.println("response from server");
		String message=r.readLine();
		System.out.println("server says to client in client file "+message);
		


		
		
		
	}

}
