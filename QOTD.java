/**
 * Quote of the day server
 * @author Garrett Singletary
 * @author github user HashanP
 * @version CSS 337 
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.net.BindException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class QOTD {

	private static String[] quotes = new String[5];
	private static Random rand = new Random();
	
	public static void main(String[] args) {
		
			try {
				String line;
				int index = 0;
				Scanner scan = new Scanner(new File("qotd.txt"));
				while(scan.hasNextLine()){
					line = scan.nextLine();
					quotes[index] = line;
					index++;
				}
				System.out.println("Size = " + quotes.length);
				System.out.println(quotes[0]);
				ServerSocket server = new ServerSocket(17);
				System.out.println("Server listening on port 17");
				while(true) {
						try { 
							Socket connection = server.accept();
							System.out.println("Connection from " + connection.getInetAddress());;
							Writer writer = new OutputStreamWriter(connection.getOutputStream(), "ASCII");
							writer.write(quotes[0]);
							writer.flush();
							connection.close();
						} catch(IOException e) {
							System.out.println(e);;
						}
				}	
			}
			catch(FileNotFoundException e){
				System.out.println("qotd.txt not found.");
			}
			catch(BindException e) {
				System.out.println("Couldn't bind to port 17.");
			}
			catch(IOException e) {
				System.out.println("Error reading qotd.txt");
			}
	}
}
