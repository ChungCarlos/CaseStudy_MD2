package views.login;

import controller.CandidateManage;
import views.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    views.Menu menu = new Menu();

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");


    Login() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 50, 100, 30);
        passwordLabel.setBounds(50, 120, 100, 30);
        userTextField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 120, 150, 30);
        showPassword.setBounds(150, 150, 150, 30);
        loginButton.setBounds(50, 200, 100, 30);
        resetButton.setBounds(200, 200, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equals("Admin") && pwdText.equals("Admin")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                this.setVisible(false); // Đóng cửa sỏ form login nhưng vẫn chạy
                menu.menu();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}
class Main {
    public static void main(String[] a) {
        Login frame = new Login();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setSize(370,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // khoá kích thướng cửa sổ ko cho người dùng thay đổi
        // Đóng form hiện tại khi đăng nhập thành công

    }

}
