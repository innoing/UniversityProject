package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import api.GetLottoNum;





public class Gui extends JFrame {
	
	GetLottoNum getLottoNum = GetLottoNum.getInstance();
	JSONParser parser;
	JSONObject winNumJson;
	ArrayList<Integer> theWinNum;
	
	Container pane;
	
	
	public Gui () throws Exception {
		pane = getContentPane();
		
		int ep = 992;
		System.out.println("=== Lotto API Raw Data ===");
		System.out.println(getLottoNum.getWinNum(ep));
		
		int MAX_NUM = 6;
		
		parser = new JSONParser();
		winNumJson = (JSONObject) parser.parse(getLottoNum.getWinNum(ep));

		theWinNum = new ArrayList<Integer>(MAX_NUM);
		
		for (int i = 0; i < MAX_NUM; i++) {
			theWinNum.add(Integer.parseInt(winNumJson.get(getLottoNum.baseWin + (i + 1)).toString()));
		}
		
		
		System.out.println("\n=== Lotto API Parsed Data ===");
		System.out.println(theWinNum);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		
		Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 45);
	    Font font1 = new Font("¸¼Àº °íµñ", Font.PLAIN, 14);
	   
	    JTextField tf1 = new JTextField("´çÃ· ¹øÈ£ " , 50);
	    JTextField tf2 = new JTextField( theWinNum + winNumJson.get(getLottoNum.bonus).toString(), 50);
	    JTextField tf3 = new JTextField(" " , 50);
	    
	    panel2.add(tf1);
	    panel3.add(tf2);
	    
	    panel2.setBackground(new Color(0,255,0));
	    panel2.setBounds(10, 10, 10, 10);
	    
	    panel3.setBackground(new Color(0,255,0));
	    panel3.setBounds(10, 10, 10, 10);
	    
	    pane.add(panel2,BorderLayout.NORTH);
	    pane.add(panel3,BorderLayout.SOUTH);
	    
	    JComboBox combo = new JComboBox<String>();
	    combo.addItem( "991" );
	    combo.addItem( "992" );
	    
	    pane.add(combo,BorderLayout.CENTER);
	    
	    
	    
           
	    setTitle("2021 Java 2 Exam1 - Lotto Simulator ");
	    setSize(500, 125); 
		setVisible(true);	    
		
		
	}
	
	
}
