import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class BlackandWhiteClientSide_GUI extends JFrame {
	   private static final long serialVersionUID = 1L;
	   int RandomNumber2; 
	   String username2;
	   String ip; 
	   Socket client_socket;
	   ServerSocket server_socket;
	   SendThread s_thread = new SendThread();
	   ReceiveThread r_thread = new ReceiveThread();
	   int point = 0;
	   JLabel result2 = new JLabel("POINT: 0"); 
	   public BlackandWhiteClientSide_GUI(int RandomNumber, String username, String ip2) {
	      RandomNumber2 = RandomNumber;
	      username2 = username;
	      ip = ip2;
	   }
	   void GUI() {
	        JButton[] cardbutton = new JButton[9];
	        JButton exit = new JButton("EXIT");
	        Container c = getContentPane();
	        setTitle("더 지니어스 : 룰 브레이커 흑 과 백 (Java Edition) Player 2"); 
	        c.setPreferredSize(new Dimension(680, 540));
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Font font = new Font("맑은 고딕", Font.PLAIN, 17);
	        Font cardfont = new Font("맑은 고딕", Font.BOLD, 35);
	        exit.setFont(font);
	        JLabel result = new JLabel("순서: " + RandomNumber2 + "");
	        JLabel label1 = new JLabel("더 지니어스 : 룰 브레이커  흑 과 백(경고: 원본과 다를 수 있음)");
	        JLabel label2 = new JLabel("Player 2 UserName: " + username2);
	        JPanel label1panel = new JPanel();
	        JPanel buttonpanel = new JPanel();
	        JPanel resultpanel = new JPanel();
	        label1.setFont(font);
	        label2.setFont(font);
	        result.setFont(font);
	        result2.setFont(font); 
	        label1panel.add(label1);
	        label1panel.add(label2);
	        System.out.println(ip);
	        for(int i=0; i<cardbutton.length; i++) {
	        	cardbutton[i] = new JButton(i + ""); 
	        	cardbutton[i].setPreferredSize(new Dimension(120, 150));
	        	buttonpanel.add(cardbutton[i]);
	        	cardbutton[i].setFont(cardfont);
	        	
	        	if(i % 2 == 0) {
	        		cardbutton[i].setBackground(Color.BLACK);
	        		cardbutton[i].setForeground(Color.WHITE);
	        	}
	        	else {
	        		cardbutton[i].setBackground(Color.WHITE);
	        		cardbutton[i].setForeground(Color.BLACK);
	        	}
	        }
	        resultpanel.add(result);
	        resultpanel.add(result2);
	        resultpanel.add(exit);
	        label1panel.setLayout(new GridLayout(2,0));
	        resultpanel.setLayout(new GridLayout(3,0));
	        cardbutton[0].addActionListener(event ->
        	{
        		sendInformation(cardbutton[0]); 
        		cardbutton[0].setEnabled(false);
        		cardbutton[0].setText("");
        	});
	        cardbutton[1].addActionListener(event ->
        	{
        		sendInformation(cardbutton[1]); 
        		cardbutton[1].setEnabled(false);
        		cardbutton[1].setText("");
        	});
	        cardbutton[2].addActionListener(event ->
        	{
        		sendInformation(cardbutton[2]); 
        		cardbutton[2].setEnabled(false);
        		cardbutton[2].setText("");
        	});
	        cardbutton[3].addActionListener(event ->
        	{
        		sendInformation(cardbutton[3]); 
        		cardbutton[3].setEnabled(false);
        		cardbutton[3].setText("");
        	});
	        cardbutton[4].addActionListener(event ->
        	{
        		sendInformation(cardbutton[4]); 
        		cardbutton[4].setEnabled(false);
        		cardbutton[4].setText("");
        	});
	        cardbutton[5].addActionListener(event ->
        	{
        		sendInformation(cardbutton[5]);
        		cardbutton[5].setEnabled(false);
        		cardbutton[5].setText("");
        	});
	        cardbutton[6].addActionListener(event ->
        	{
        		sendInformation(cardbutton[6]); 
        		cardbutton[6].setEnabled(false);
        		cardbutton[6].setText("");
        	});
	        cardbutton[7].addActionListener(event ->
        	{
        		sendInformation(cardbutton[7]);
        		cardbutton[7].setEnabled(false);
        		cardbutton[7].setText("");
        	});
	        cardbutton[8].addActionListener(event ->
        	{
        		sendInformation(cardbutton[8]); 
        		cardbutton[8].setEnabled(false);
        		cardbutton[8].setText("");
        	});
	        exit.addActionListener(event -> {
	        	System.exit(0);
	        });
	        c.setLayout(new BorderLayout());
	        c.add(label1panel, BorderLayout.NORTH);
	        c.add(buttonpanel, BorderLayout.CENTER);
	        c.add(resultpanel, BorderLayout.SOUTH);
	        pack();
	        initSocket(ip);
	        setVisible(true); 
	   }
    public void initSocket(String ip) {
		try {
			client_socket = new Socket(ip, 10001); 
			r_thread.setSocket(client_socket);
			r_thread.start();
			s_thread.setSocket(client_socket);
			s_thread.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			errormessage(e.getMessage());
		}  
    }
    public void sendInformation(JButton jb) {
    	s_thread.setString(jb.getText());
		String receivestr = r_thread.receiveString();
		try {
			if(receivestr != null && !receivestr.isEmpty()) {
				if(Integer.parseInt(receivestr) < Integer.parseInt(jb.getText())) {
					point++;
					result2.setText("POINT: " + point);
				}
				else if(Integer.parseInt(receivestr) == Integer.parseInt(jb.getText())) {
					JOptionPane.showMessageDialog(null, "비겼습니다.", "더 지니어스: 룰 브레이커 흑 과 백", JOptionPane.INFORMATION_MESSAGE);
				}
			}	
		}catch(NumberFormatException e) { //처음 눌럿을 때
			jb.setEnabled(false);
			jb.setText("");
		}
    }
    public void errormessage(String message) {
 	   JOptionPane.showMessageDialog(null, "ERROR MESSEGE: " + message, "Program Error", JOptionPane.ERROR_MESSAGE);
    }
}

