import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SendThread extends Thread {

	Socket socket2;
	String sendString;
	@Override
	public void run() {
		super.run();
		try {
		   
		  //System.out.println("sendString: " + sendString);
		   PrintWriter pw = new PrintWriter(socket2.getOutputStream());
		   while(true) {
			   pw.println(sendString);
			   pw.flush();
		   }
		   
		}catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "ERROR MESSEGE: " + e.getMessage(), "Program Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void setSocket(Socket socket) {
		socket2 = socket;
	}
	public void setString(String sendstr) {
		sendString = sendstr; 
	}
}
