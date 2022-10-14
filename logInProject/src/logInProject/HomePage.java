package logInProject;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class HomePage extends JFrame {

	JLabel naver;
	JPanel window;
	JPanel statusWindow;
	JLabel myProfile;

	JLabel id;
	JTextField idField;
	JLabel name;
	JTextField nameField;
	JLabel email;
	JTextField emailField;
	JLabel address;
	JTextField addressField;
	JLabel phoneNumber;
	JTextField phoneNumberField;

	public HomePage() {
		initDate();
		setInitLayout();
		addActionListener();

	}

	private void initDate() {
		setTitle("Home");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		naver = new JLabel(new ImageIcon("images/naver.png"));
		window = new JPanel();
		statusWindow = new JPanel();

		myProfile = new JLabel(new ImageIcon("images/profile.png"));

		id = new JLabel("아이디 : ");
		idField = new JTextField();
		name = new JLabel("이름 : ");
		nameField = new JTextField();
		email = new JLabel("이메일 : ");
		emailField = new JTextField();
		address = new JLabel("주소 : ");
		addressField = new JTextField();
		phoneNumber = new JLabel("연락처 : ");
		phoneNumberField = new JTextField();

	}

	private void setInitLayout() {
		setVisible(true);
		window.setBackground(Color.white);
		window.setLayout(null);
		add(window);
		naver.setBounds(120, 30, 230, 80);
		window.add(naver);

		statusWindow.setBounds(25, 125, 440, 300);
		statusWindow.setLayout(null);
//		statusWindow.setBackground(new Color(0, 210, 60));
		statusWindow.setBorder(new TitledBorder(new LineBorder(Color.lightGray, 2)));
		window.add(statusWindow);

		myProfile.setBounds(20, 30, 110, 110);
		statusWindow.add(myProfile);

		id.setBounds(150, 40, 100, 30);
		statusWindow.add(id);

		name.setBounds(150, 85, 100, 30);
		statusWindow.add(name);

		email.setBounds(150, 130, 100, 30);
		statusWindow.add(email);

		address.setBounds(150, 175, 100, 30);
		statusWindow.add(address);

		phoneNumber.setBounds(150, 220, 100, 30);
		statusWindow.add(phoneNumber);

		setTextFiled(idField, 220, 40, 190, 30);
		setTextFiled(nameField, 220, 85, 190, 30);
		setTextFiled(emailField, 220, 130, 190, 30);
		setTextFiled(addressField, 220, 175, 190, 30);
		setTextFiled(phoneNumberField, 220, 220, 190, 30);

		idField.setBackground(new Color(255, 255, 255));
		nameField.setBackground(new Color(255, 255, 255));
		emailField.setBackground(new Color(255, 255, 255));
		addressField.setBackground(new Color(255, 255, 255));
		phoneNumberField.setBackground(new Color(255, 255, 255));

	}

	private void addActionListener() {

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
