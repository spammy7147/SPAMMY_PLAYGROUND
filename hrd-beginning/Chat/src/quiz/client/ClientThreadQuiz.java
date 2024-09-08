package quiz.client;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientThreadQuiz extends Thread {
	
	Socket s;
	public ClientThreadQuiz(Socket s) {
		this.s = s; 
		start();
	}

	
	
	public void run() {
		
		try {
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while(true) {
				
				System.out.println("\n"+dis.readUTF());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
