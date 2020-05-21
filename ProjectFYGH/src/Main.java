import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.util.*;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel tname;
	static public JTextField login;
	static public JPasswordField pass;
	public JButton enter;
	public JPanel panel;
	static int col;
	private Scanner sc;
	
	public static void main(String[] args) throws FileNotFoundException {
		new Main();
	}
	
	public Main() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
		int vert = sSize.height;
		int hor  = sSize.width;
		int locationX = (sSize.width - hor/2) / 2;
		int locationY = (sSize.height - vert/2) / 3;
		setBounds(locationX, locationY, hor/4, vert/2);
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4,1));
		panel.setVisible(true);
		
		Font mainfont = new Font("Century Gothic", Font.PLAIN, 32);
		Font secondfont = new Font("Century Gothic", Font.PLAIN, 24);
		
		tname = new JLabel("FYGK team");
		tname.setFont(mainfont);
		tname.setHorizontalAlignment(JLabel.CENTER);
		
		login = new JTextField("Логин");
		login.setHorizontalAlignment(JTextField.CENTER);
		login.setFont(secondfont);
		
		sc = new Scanner(new File("src/pass.txt"));
		String slogin, spass;
		slogin = sc.nextLine();
		spass = sc.nextLine();
		
		String hintlogin = "Логин";
		login.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (login.getText().equals(hintlogin)) {
	            	login.setText("");
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (login.getText().isEmpty()) {
	            	login.setText(hintlogin);
	            }
	        }
	    });
		
		String hintpass = "Пароль";
		pass = new JPasswordField(hintpass);
		pass.setHorizontalAlignment(JTextField.CENTER);
		pass.setFont(secondfont);
		pass.setEchoChar((char)0);
		
		pass.addFocusListener(new FocusAdapter() {
	        @Override
	        public void focusGained(FocusEvent e) {
	            if (pass.getText().equals(hintpass)) {
	            	pass.setText("");
	            	pass.setEchoChar('•');
	            }
	        }
	        @Override
	        public void focusLost(FocusEvent e) {
	            if (pass.getText().isEmpty()) {
	            	pass.setText(hintpass);
	            	pass.setEchoChar((char)0);
	            }
	        }
	    });
		
		enter = new JButton("Войти");
		enter.setFont(secondfont);
		enter.setBackground(new Color(163, 184, 204));
		panel.setBackground(new Color(210, 225, 235));
		login.setBackground(new Color(240, 240, 240));
		pass.setBackground(new Color(240, 240, 240));
			
		panel.add(tname);
		panel.add(login);
		panel.add(pass);
		panel.add(enter);

		ProgressBarRotating progressBarRotating=new ProgressBarRotating();
		enter.addActionListener(new ActionListener() {                                                         
			public void actionPerformed(ActionEvent e) {  
				if (login.getText().equals(slogin) && pass.getText().equals(spass)) {		
						dispose();	
						new Program();	
				} else {
					login.setBackground(Color.PINK);
					pass.setBackground(Color.PINK);
					pass.setText("Пароль");
					pass.setEchoChar((char)0);	
					if (!progressBarRotating.isAlive())
				    progressBarRotating.start();
					else {
						if (col > 5) {
							col = 0;
						}
					}
				}
			} 	    	                             
		}); 
		
		setVisible(true);
		enter.transferFocus(); 
		enter.grabFocus();	
	}
}

class ProgressBarRotating extends Thread {
	boolean showProgress = true;
	public void run() {
	Boolean isVisible = true;
		while (showProgress) {
			isVisible=!isVisible;
			if (Main.col <=5) { Main.col++;
				if(isVisible) {
					Main.login.setBackground(Color.PINK);
					Main.pass.setBackground(Color.PINK);
				}
				else
				{
					Main.login.setBackground(new Color(240, 240, 240));
					Main.pass.setBackground(new Color(240, 240, 240));
				}
			} else {
				Main.login.setBackground(new Color(240, 240, 240));
				Main.pass.setBackground(new Color(240, 240, 240));
			}
            try { Thread.sleep(70); }
            catch (Exception e) {};
		}
	}
}
