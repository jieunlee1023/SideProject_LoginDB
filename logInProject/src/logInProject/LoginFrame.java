package logInProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {

	private LoginFrame mContext = this;
	ResultSet rs;

	JLabel logo = new JLabel(new ImageIcon("images/logo.png"));
	JButton logIn = new JButton("ID 로그인");
	JLabel logInImage = new JLabel(new ImageIcon("images/login.png"));
	JButton disposableNum = new JButton("일회용 번호");
	JLabel disposableNumImg = new JLabel(new ImageIcon("images/disposableNumImg.png"));
	JButton qr = new JButton("QR코드");
	JLabel qrImg = new JLabel(new ImageIcon("images/qr.png"));

	TextField id = new TextField("아이디");
	JPasswordField password = new JPasswordField("*****");

	JCheckBox checkBox = new JCheckBox();
	JLabel staySignedIn = new JLabel("로그인 상태 유지");

	RoundedButton logInbutton = new RoundedButton("로그인");

	JButton findPassword = new JButton("비밀번호 찾기");
	JButton findId = new JButton("아이디 찾기");
	JButton join = new JButton("회원가입");

	public LoginFrame() {
		initData();
		setInitLayout();
		addActionListener();
	}

	private void initData() {
		setVisible(true);
		setTitle("로그인");
		setSize(500, 500);
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setInitLayout() {

		setLayout(null);
		logo.setSize(280, 70);
		logo.setLocation(110, 30);
		add(logo);

		logIn.setSize(100, 35);
		logIn.setLocation(80, 130);
		logIn.setBorderPainted(false); // 버튼 테두리
		logIn.setContentAreaFilled(false); // 버튼 영역
		logIn.setFocusPainted(false); // 버튼 포커스
		add(logIn);

		logInImage.setSize(30, 30);
		logInImage.setLocation(70, 132);
		add(logInImage);

		disposableNumImg.setSize(30, 30);
		disposableNumImg.setLocation(190, 132);
		add(disposableNumImg);

		disposableNum.setSize(100, 35);
		disposableNum.setLocation(210, 130);
		disposableNum.setBorderPainted(false); // 버튼 테두리
		disposableNum.setContentAreaFilled(false); // 버튼 영역
		disposableNum.setFocusPainted(false); // 버튼 포커스
		add(disposableNum);

		qrImg.setSize(30, 30);
		qrImg.setLocation(320, 132);
		add(qrImg);

		qr.setSize(100, 35);
		qr.setLocation(330, 130);
		qr.setBorderPainted(false); // 버튼 테두리
		qr.setContentAreaFilled(false); // 버튼 영역
		qr.setFocusPainted(false); // 버튼 포커스
		add(qr);

		id.setSize(400, 30);
		id.setLocation(50, 200);
		add(id);

		password.setSize(400, 30);
		password.setLocation(50, 240);
		add(password);

		checkBox.setSize(20, 20);
		checkBox.setLocation(45, 290);
		checkBox.setContentAreaFilled(false);
		add(checkBox);

		staySignedIn.setSize(100, 20);
		staySignedIn.setLocation(70, 290);
		add(staySignedIn);

		logInbutton.setSize(400, 50);
		logInbutton.setLocation(50, 340);
		logInbutton.setFont(new Font(getName(), Font.BOLD, 20));
		add(logInbutton);

		findPassword.setSize(120, 35);
		findPassword.setLocation(80, 400);
		findPassword.setBorderPainted(false); // 버튼 테두리
		findPassword.setContentAreaFilled(false); // 버튼 영역
		findPassword.setFocusPainted(false); // 버튼 포커스
		findPassword.setForeground(new Color(135, 135, 135)); // 글자색지정
		add(findPassword);

		findId.setSize(120, 35);
		findId.setLocation(180, 400);
		findId.setBorderPainted(false); // 버튼 테두리
		findId.setContentAreaFilled(false); // 버튼 영역
		findId.setFocusPainted(false); // 버튼 포커스
		findId.setForeground(new Color(135, 135, 135)); // 글자색지정
		add(findId);

		join.setSize(120, 35);
		join.setLocation(280, 400);
		join.setBorderPainted(false); // 버튼 테두리
		join.setContentAreaFilled(false); // 버튼 영역
		join.setFocusPainted(false); // 버튼 포커스
		join.setForeground(new Color(135, 135, 135)); // 글자색지정
		add(join);

	}

	private void addActionListener() {
		logInbutton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetButton = (JButton) e.getSource();
		if (targetButton.getText().equals(logInbutton.getText())) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/userinfo?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
				Connection conn = DriverManager
						// .getConnection(url, "root", "dlfdl123");
						.getConnection(url, "root", "asd1234");
				String userid = id.getText();
				String userpw = password.getText();
				Statement stmt = conn.createStatement();

				String sql = "SELECT * FROM userinfo where userId = '" + userid + "' and userPw = '" + userpw + "'";
				rs = stmt.executeQuery(sql);

				if (rs.next()) {
					dispose();
					this.setVisible(false);
					HomePage hp = new HomePage(mContext);
					hp.userInfo();
				} else {
					JOptionPane.showMessageDialog(this, "일치하는 정보가 없습니다.");
				}

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public class RoundedButton extends JButton {

		public RoundedButton() {
			super();
			decorate();
		}

		public RoundedButton(String text) {
			super(text);
			decorate();
		}

		public RoundedButton(Action action) {
			super(action);
			decorate();
		}

		public RoundedButton(Icon icon) {
			super(icon);
			decorate();
		}

		public RoundedButton(String text, Icon icon) {
			super(text, icon);
			decorate();
		}

		protected void decorate() {
			setBorderPainted(false);
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Color c = new Color(3, 199, 90); // 배경색 결정
			Color o = new Color(255, 255, 255); // 글자색 결정
			int width = getWidth();
			int height = getHeight();
			Graphics2D graphics = (Graphics2D) g;
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (getModel().isArmed()) {
				graphics.setColor(c.darker());
			} else if (getModel().isRollover()) {
				graphics.setColor(c.brighter());
			} else {
				graphics.setColor(c);
			}
			graphics.fillRoundRect(0, 0, width, height, 10, 10);
			FontMetrics fontMetrics = graphics.getFontMetrics();
			Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
			int textX = (width - stringBounds.width) / 2;
			int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
			graphics.setColor(o);
			graphics.setFont(getFont());
			graphics.drawString(getText(), textX, textY);
			graphics.dispose();
			super.paintComponent(g);
		}
	}
	// 둥근 버튼 만드는 클래스

	public static void main(String[] args) {
		new LoginFrame();

	}

}
