package logInProject;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomePage extends JFrame{

JLabel naver;
JPanel window;
JPanel statusWindow;
JLabel myProfile;
JTextField txt1;
JTextField txt2;
JTextField txt3;
JTextField txt4;

JButton button1;
JButton button2;
JButton button3;
JButton button4;



	public HomePage()  {
	initDate();
	setInitLayout();
	addActionListener();
	
		
	}

	private void initDate() {
		setTitle("Home");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		naver = new JLabel(new ImageIcon ("images/naver.png"));
		window = new JPanel();
		statusWindow = new JPanel();
		myProfile = new JLabel(new ImageIcon("images/profile.png"));
		txt1 = new JTextField("아이디 ");
		txt2 = new JTextField("이름 ");
		txt3 = new JTextField("이메일 ");
		txt4 = new JTextField("주소 ");
		button1 = new JButton("버튼1");
		button2 = new JButton("버튼2");
		button3 = new JButton("버튼3");
		button4 = new JButton("버튼4");
		
	}

	private void setInitLayout() {
		setVisible(true);
		window.setBackground(Color.white);
		window.setLayout(null);
		add(window);
		naver.setBounds(120,30,230,80);
		window.add(naver);
		
		statusWindow.setBounds(40, 130, 440,300);
		statusWindow.setLayout(null);
		statusWindow.setBackground(Color.LIGHT_GRAY);
		window.add(statusWindow);
		
		
		myProfile.setBounds(20,20, 110, 110);
		statusWindow.add(myProfile);
		
		setTextFiled(txt1, 150, 40, 100, 40);
		setTextFiled(txt2, 150, 85, 100, 40);
		setTextFiled(txt3, 150, 130, 100, 40);
		setTextFiled(txt4, 150, 175, 100, 40);
		
		button1.setBounds(30, 230, 70, 50);
		statusWindow.add(button1);
		button2.setBounds(130, 230, 70, 50);
		statusWindow.add(button2);
		button3.setBounds(230, 230, 70, 50);
		statusWindow.add(button3);
		button4.setBounds(330, 230, 70, 50);
		statusWindow.add(button4);
		
		
	}
	
	private void addActionListener(){
		
		
	}
	
	private void setTextFiled(JTextField txt, int x, int y, int w, int h) {
		txt.setBounds(x, y, w, h);
		txt.setBorder(null);
		txt.setBackground(Color.LIGHT_GRAY);
		statusWindow.add(txt);
	}
	
	public static void main(String[] args) {
		new HomePage();
	}
	
	

	
	
}

