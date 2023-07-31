import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlackandWhiteServerSide_LoginForm extends JFrame{

private static final long serialVersionUID = 1L;
public static void main(String[] args){
      // TODO Auto-generated method stub
        BlackandWhiteServerSide_LoginForm baw = new BlackandWhiteServerSide_LoginForm();
        baw.GUI();
   }
    void GUI() {
    	JTextField jtf = new JTextField("Player 1");
        JButton randomcalu = new JButton("SELECTION ORDER");
        JButton exit = new JButton("EXIT");
        Container c = getContentPane();
        setTitle("´õ Áö´Ï¾î½º : ·ê ºê·¹ÀÌÄ¿ Èæ °ú ¹é (Java Edition) Player 1");
        c.setPreferredSize(new Dimension(520, 220));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("¸¼Àº °íµñ", Font.PLAIN, 17);
        randomcalu.setFont(font);
        exit.setFont(font);
        JLabel result = new JLabel();
        JLabel label1 = new JLabel("Player 1 ServerSide, Random Order Selection(0: First, 1: Last)");
        JLabel label2 = new JLabel("PLAYER 1 USERNAME: ");
        label2.setFont(font);
        JPanel label1panel = new JPanel();
        JPanel buttonpanel = new JPanel();
        JPanel resultpanel = new JPanel();
        label1.setFont(font);
        result.setFont(font);
        jtf.setFont(font); 
        label1panel.add(label1);
        label1panel.add(label2);
        label1panel.add(jtf);
        label1panel.setLayout(new GridLayout(3,2));
        buttonpanel.add(randomcalu);
        buttonpanel.add(exit);
        resultpanel.add(result);
        randomcalu.addActionListener(event -> {
        	Random random = new Random();
        	int RandomNumber = random.nextInt(2);
        	result.setText("¼ø¼­: " + RandomNumber);
        	BlackandWhiteServerSide_GUI baw = new BlackandWhiteServerSide_GUI(RandomNumber, jtf.getText());
        	baw.GUI();
        });
        exit.addActionListener(event -> {
        	System.exit(0); 
        });
        c.setLayout(new BorderLayout());
        c.add(label1panel, BorderLayout.NORTH);
        c.add(buttonpanel, BorderLayout.CENTER);
        c.add(resultpanel, BorderLayout.SOUTH);
        pack();
        setVisible(true); 
    }
}

