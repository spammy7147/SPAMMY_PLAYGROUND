package quiz.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


public class ServerThreadQuiz extends Thread{

	
	Socket s = null;
	
	public ServerThreadQuiz(Socket s) {
		
		this.s = s;
		start();
		
	}
	
	public void run() {
		
			
		try {
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while(true) {
				
					String mal = dis.readUTF();
					
					String add = s.getInetAddress().toString();
					System.out.println(add+ " : " + mal);
					
					for(Socket socket : ServerQuiz.socket) {
						
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(add + " : " + mal);
					
				}
			}
			
		} catch (IOException e) {
			ServerQuiz.socket.remove(s);
		}
		
		
	}
	
}
