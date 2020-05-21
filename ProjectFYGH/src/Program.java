import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Program extends JFrame{
	
	JLabel label1 = new JLabel("<html>Сумма налога, руб.</html>", JLabel.CENTER);
	JLabel label2 = new JLabel("<html>Сумма на руки, руб.</html>", JLabel.CENTER);
	JLabel nalogy = new JLabel("", JLabel.CENTER);
	JLabel ostatok = new JLabel("", JLabel.CENTER);
	JLabel info = new JLabel("<html>13% для резидента</html>");
	JLabel empty = new JLabel("");
	JTextField mainsum = new JTextField("Сумма оклада, руб");
	JTextField dfield = new JTextField("");
	JRadioButton rad13, rad15, rad30, liv, unliv, option;
	JPanel panel, panel1, panel1_1, panel1_2, panel1_3, panel2, panel2_1, panel2_2, panel3, panel3_1, panel3_2, panel3_3;
	JButton enter = new JButton("Расчитать");
	int int_rad=13;
	double d_add=0;
	boolean optionp = true;
	boolean data = false;
	String check;
	
	public Program() {
		setTitle("Калькулятор НДФЛ"); 
		Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		int vert = sSize.height;
		int hor  = sSize.width;
		int locationX = (sSize.width - hor/2) / 2;
		int locationY = (sSize.height - vert/2) / 3;
		setBounds(locationX, locationY, hor/4, vert/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		panel = new JPanel();	
		panel.setLayout(new GridLayout(3,1));
		panel.setVisible(true);
		
		panel1 = new JPanel();	
		panel1.setLayout(new GridLayout(3,1));
		panel1.setVisible(true);
		
		panel1_1 = new JPanel();	
		panel1_1.setLayout(new BorderLayout());
		mainsum.setHorizontalAlignment(JTextField.CENTER);
		Font font1 = new Font("Calibri", Font.PLAIN, 12);
		Font font2 = new Font("Calibri", Font.PLAIN, 24);
		mainsum.setFont(font2);
		mainsum.setForeground(Color.GRAY);
		panel1_1.add(mainsum, BorderLayout.CENTER);
		panel1_1.setVisible(true);
		
		panel1_2 = new JPanel();	
		panel1_2.setLayout(new GridLayout(1,2));
		liv = new JRadioButton("Жилое");
		panel1_2.add(liv);
		unliv = new JRadioButton("Нежилое");
		panel1_2.add(unliv);
		panel1_2.setVisible(true);
		
		panel1_3 = new JPanel();	
		panel1_3.setLayout(new GridLayout(1,2));
		option = new JRadioButton("<html>Платеж просрочен</html>");
		panel1_3.add(option);
		dfield.setText("");
		dfield.setFocusable(false);
		dfield.setHorizontalAlignment(JTextField.CENTER);
		dfield.setFont(font1);
		dfield.setForeground(Color.GRAY);
		dfield.setBackground(new Color(238, 238, 238));
		panel1_3.add(dfield);
		panel1_3.setVisible(true);
		
		panel1.add(panel1_1);
		panel1.add(panel1_2);
		panel1.add(panel1_3);
		
		panel2 = new JPanel();	
		panel2.setLayout(new GridLayout(1,2));
		panel2.setVisible(true);
		
		panel2_1 = new JPanel();
		panel2_1.setLayout(new GridLayout(3,1));
		rad13 = new JRadioButton("13%");
		panel2_1.add(rad13);
		rad15 = new JRadioButton("15%");
		panel2_1.add(rad15);
		rad30 = new JRadioButton("30%");
		panel2_1.add(rad30);
		panel2_1.setVisible(true);
		
		panel2_2 = new JPanel();
		panel2_2.setLayout(new BorderLayout());
		panel2_2.add(info, BorderLayout.CENTER);
		panel2_2.setVisible(true);
		
		panel2.add(panel2_1);
		panel2.add(panel2_2);
		
		panel3 = new JPanel();	
		panel3.setLayout(new GridLayout(3,1));
		panel3.setVisible(true);
		
		panel3_1 = new JPanel();	
		panel3_1.setLayout(new GridLayout(1,2));
		panel3_1.add(label1);
		panel3_1.add(nalogy);
		panel3_1.setVisible(true);
		
		panel3_2 = new JPanel();	
		panel3_2.setLayout(new GridLayout(1,2));
		panel3_2.add(label2);
		panel3_2.add(ostatok);
		panel3_2.setVisible(true);
		
		panel3_2 = new JPanel();	
		panel3_2.setLayout(new GridLayout(1,2));
		panel3_2.add(label2);
		panel3_2.add(ostatok);
		panel3_2.setVisible(true);
		
		panel3_3 = new JPanel();
		panel3_3.setLayout(new BorderLayout());
		panel3_3.add(enter, BorderLayout.CENTER);
		panel3_3.setVisible(true);
		
		panel3.add(panel3_1);
		panel3.add(panel3_2);
		panel3.add(panel3_3);
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		
		rad13.setEnabled(false);
		rad13.setSelected(true);
		rad13.addActionListener(new ActionListener()