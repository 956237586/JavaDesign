package javadesign.windows;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javadesign.abstractmodel.Window;

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

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������Ĭ���˳�����Ϊ�ر�
		status.getWindows().put("LoginWindow", this);
		setTitle("��½");
		setResizable(false);
		getContentPane().setLayout(null);

		// ��ȡ�û����ݣ���������¼���ڣ������¼�ɹ�������������������

		// ��ʾ��ǩ
		JLabel label_username = new JLabel("�û�����");
		label_username.setFont(new Font("SimSun", Font.PLAIN, 12));
		label_username.setHorizontalAlignment(SwingConstants.RIGHT);
		label_username.setBounds(100, 74, 64, 15);
		getContentPane().add(label_username);

		JLabel label_password = new JLabel("���룺");
		label_password.setFont(new Font("SimSun", Font.PLAIN, 12));
		label_password.setHorizontalAlignment(SwingConstants.RIGHT);
		label_password.setBounds(116, 115, 48, 15);
		getContentPane().add(label_password);

		// �û����༭��
		textField_uname = new JTextField();
		textField_uname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 10) {
					// ϸ�ڴ������س�����������༭��
					pwdField_pwd.requestFocus();
				}
			}
		});
		textField_uname.setBounds(170, 71, 124, 21);
		getContentPane().add(textField_uname);
		textField_uname.setColumns(10);

		// ����༭��
		pwdField_pwd = new JPasswordField();
		pwdField_pwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					// ϸ�ڴ������س���ȷ����½����ͬ�����½��ť
					UserLogin();
				}
			}
		});
		pwdField_pwd.setColumns(10);
		pwdField_pwd.setBounds(170, 112, 124, 21);
		getContentPane().add(pwdField_pwd);

		// ��½��ť
		JButton btn_login = new JButton("��½");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserLogin();
			}
		});
		btn_login.setBounds(131, 163, 83, 33);
		getContentPane().add(btn_login);

		// ���ð�ť
		JButton btn_reset = new JButton("����");
		btn_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_uname.setText(""); // ����û�ԭ������
				pwdField_pwd.setText("");
				textField_uname.requestFocus(); // �û����༭���ȡ���㣬
												// �����û���������
			}
		});
		btn_reset.setBounds(224, 163, 83, 33);
		getContentPane().add(btn_reset);

		// ����tab�������Ⱥ�˳��
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				textField_uname, pwdField_pwd, btn_login, btn_reset }));

		// ��������Ĵ�С�����Ǹ����Ĭ�ϴ�С
		setSize(427, 293);
		setup();
	}

	public void UserLogin() {
		// ��½����
		String username = textField_uname.getText().trim();
		char[] passwordChar = pwdField_pwd.getPassword();
		String password = new StringBuilder().append(passwordChar).toString();

		if (username.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(this, "��n���û���������Ϊ�գ����������롣", "����",
					JOptionPane.WARNING_MESSAGE);
			textField_uname.requestFocus();
		} else {
			status.setLogin(true);
			status.setLoginUsername(textField_uname.getText());
			((MenuWindow) status.getWindow("MenuWindow")).LoginSucceed();
			setVisible(false);
		}
	}
}
