package quiz.client;



import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ClientQuiz1 {

	public static void main(String[] args) throws Exception {
		
		
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket("125.132.133.80",12345);
		new ClientThreadQuiz(s);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		while(true) {
		
			System.out.print("말 : ");
			dos.writeUTF(sc.nextLine());
			
		}
		

	}

}
