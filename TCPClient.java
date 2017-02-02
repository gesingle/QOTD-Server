/**
 * TCP client for accessing QOTD server
 * @author Garrett Singletary
 * @author Dave (https://systembash.com/a-simple-java-tcp-server-and-tcp-client/)
 * @version CSS 337
 */

import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		
		String quote;
		
		Socket clientSocket = new Socket("localhost", 17);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		quote = inFromServer.readLine();
		System.out.println("From Server: " + quote);
		clientSocket.close();
	}
}
