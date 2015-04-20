package javadesign.windows;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javadesign.abstractmodel.Window;
import javadesign.specificmodel.UserData;
import javadesign.util.Util;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Login extends Window {
	private static final long serialVersionUID = 1L;
	private JTextField textField_uname;
	private JPasswordField pwdField_pwd;
	private UserData userData;
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 主窗口默认退出操作为关闭
		status.getWindows().put("LoginWindow", this);
		setTitle("登陆");
		setResizable(false);
		getContentPane().setLayout(null);

		// 读取用户数据，加载主登录窗口，如果登录成功继续加载主操作窗口
		userData = new UserData();
		userData.loadData();
		// 提示标签
		JLabel label_username = new JLabel("用户名：");
		label_username.setFont(new Font("SimSun", Font.PLAIN, 12));
		label_username.setHorizontalAlignment(SwingConstants.RIGHT);
		label_username.setBounds(100, 74, 64, 15);
		getContentPane().add(label_username);

		JLabel label_password = new JLabel("密码：");
		label_password.setFont(new Font("SimSun", Font.PLAIN, 12));
		label_password.setHorizontalAlignment(SwingConstants.RIGHT);
		label_password.setBounds(116, 115, 48, 15);
		getContentPane().add(label_password);

		// 用户名编辑框
		textField_uname = new JTextField();
		textField_uname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 10) {
					// 细节处理，按回车键跳到密码编辑框
					pwdField_pwd.requestFocus();
				}
			}
		});
		textField_uname.setBounds(170, 71, 124, 21);
		getContentPane().add(textField_uname);
		textField_uname.setColumns(10);

		// 密码编辑框
		pwdField_pwd = new JPasswordField();
		pwdField_pwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					// 细节处理，按回车键确定登陆，等同点击登陆按钮
					UserLogin();
				}
			}
		});
		pwdField_pwd.setColumns(10);
		pwdField_pwd.setBounds(170, 112, 124, 21);
		getContentPane().add(pwdField_pwd);

		// 登陆按钮
		JButton btn_login = new JButton("登陆");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserLogin();
			}
		});
		btn_login.setBounds(131, 163, 83, 33);
		getContentPane().add(btn_login);

		// 重置按钮
		JButton btn_reset = new JButton("重置");
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_uname.setText(""); // 清空用户原有输入
				pwdField_pwd.setText("");
				textField_uname.requestFocus(); // 用户名编辑框获取焦点，
												// 方便用户重新输入
			}
		});
		btn_reset.setBounds(224, 163, 83, 33);
		getContentPane().add(btn_reset);

		// 设置tab键焦点先后顺序
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				textField_uname, pwdField_pwd, btn_login, btn_reset }));

		// 设置特殊的大小，覆盖父类的默认大小
		setSize(427, 293);
		setup();
	}

	public void UserLogin() {
		// 登陆处理
		String username = textField_uname.getText().trim();
		char[] passwordChar = pwdField_pwd.getPassword();
		String password = new StringBuilder().append(passwordChar).toString();

		if (username.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(this, "●﹏●用户名或密码为空，请重新输入。", "错误",
					JOptionPane.WARNING_MESSAGE);
			textField_uname.requestFocus();
		} else {
			if(userData.canAccess(username,password)) {
				status.setLogin(true);
				status.setLoginUsername(textField_uname.getText());
				((MenuWindow) status.getWindow("MenuWindow")).LoginSucceed();
				setVisible(false);
			}else{
				Util.alertError("请确认您的密码正确并重试，如果依然不能登陆请联系系统管理员");
				textField_uname.requestFocus();
			}
		}
	}
}
