package quiz.server;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerQuiz {
	
	static List<Socket> socket = new ArrayList<Socket>();
	
	public static void main(String[] args) throws Exception {
		
		
		ServerSocket s = new ServerSocket(12345);
		

		while(true) {
			socket.add(s.accept());
			new ServerThreadQuiz(socket.get(socket.size()-1));
			
			System.out.println("접속중 : " + socket.size() + "명");

				
			
		}
		

	}

}
