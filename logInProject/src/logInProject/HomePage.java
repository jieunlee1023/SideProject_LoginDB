package logInProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class HomePage extends JFrame implements ActionListener{

	private LoginFrame mContext;

	private JLabel naver;
	private JPanel window;
	private JPanel statusWindow;
	private JLabel myProfile;
	private ImageIcon bang;
	private ImageIcon je;
	private JLabel id;
	private JTextField idField;
	private JLabel name;
	private JTextField nameField;
	private JLabel email;
	private JTextField emailField;
	private JLabel address;
	private JTextField addressField;
	private JLabel phoneNumber;
	private JTextField phoneNumberField;
	private JButton logout;

	// 이거 왜 필요??
	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public HomePage(LoginFrame mContext) {
		this.mContext = mContext;
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
		bang = new ImageIcon("images/bang.png");
		je = new ImageIcon("images/je.png");
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
		logout = new JButton(new ImageIcon ("images/logout.png"));

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
		
		logout.setBounds(20,240,70,40);
		logout.setBorderPainted(false);
		logout.setContentAreaFilled(false); 
		logout.setFocusPainted(false); 
		statusWindow.add(logout);
		

		setLabel(myProfile, 20, 30, 110, 110);
		setLabel(id, 150, 40, 100, 30);
		setLabel(name, 150, 85, 100, 30);
		setLabel(email, 150, 130, 100, 30);
		setLabel(address, 150, 175, 100, 30);
		setLabel(phoneNumber, 150, 220, 100, 30);


		setTextFiled(idField, 220, 40, 190, 30);
		setTextFiled(nameField, 220, 85, 190, 30);
		setTextFiled(emailField, 220, 130, 190, 30);
		setTextFiled(addressField, 220, 175, 190, 30);
		setTextFiled(phoneNumberField, 220, 220, 190, 30);



	}

	private void addActionListener() {
		logout.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logout) {
			dispose();
			JOptionPane.showMessageDialog(this, "로그아웃 완료 ");
			new LoginFrame();
		}
	}

	
	private void setLabel(JLabel label, int x, int y, int w, int h) {
		label.setBounds(x, y, w, h);
		statusWindow.add(label);
	}
	
	private void setTextFiled(JTextField txt, int x, int y, int w, int h) {
		txt.setBounds(x, y, w, h);
		txt.setBorder(null);
		statusWindow.add(txt);
	}

	
	public void userInfo() {
		String userId;
		try {
			userId = mContext.rs.getString("userId");
			idField.setText(userId);
			String userName = mContext.rs.getString("userName");
			nameField.setText(userName);
			String userAddr = mContext.rs.getString("userAddr");
			addressField.setText(userAddr);
			emailField.setText(userId + "@naver.com");
			String userPhoneNum = mContext.rs.getString("userPhoneNum");
			phoneNumberField.setText(userPhoneNum);
			if(userId.equals("1000bang")) {
				myProfile.setIcon(bang);
			} else if(userId.equals("ji_euni")) {
				myProfile.setIcon(je);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
