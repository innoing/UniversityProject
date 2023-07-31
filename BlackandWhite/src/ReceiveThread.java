import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ReceiveThread extends Thread {

	Socket socket2; 
	String receiveString2 = "";
	@Override
	public void run() {
		super.run(); 
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
			//System.out.println("TEST"); 
			while(true) {
			  receiveString2 = br.readLine();
			  if((receiveString2 = br.readLine()) == null)
			  {
			      break;
			  }
			}
			//System.out.println("receiveString2: " + receiveString2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(null, "ERROR MESSEGE: " + e.getMessage(), "Program Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void setSocket(Socket socket) {
		socket2 = socket;
		
	}
	public String receiveString() {
		
		return receiveString2; 
	}
}
