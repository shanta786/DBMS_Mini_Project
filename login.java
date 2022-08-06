package HospitalManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;

public class login {
    public static void main(String[] args) {

            loginform form=new loginform();
            form.setTitle("Login Form");
            form.setVisible(true);
            form.setBounds(100,100,740,700);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setResizable(false);

    }
}
class loginform extends JFrame implements ActionListener
{
    Container container=getContentPane();
    JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    loginform()
    {
        setLoyoutManager();
        setLocationSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLoyoutManager()
    {
        container.setLayout(null);
    }
    public void setLocationSize()
    {
        title.setBounds(75,100,650,35);
        title.setFont(new Font("Arial",Font.BOLD,25));
        title.setForeground(Color.RED);
        userLabel.setBounds(200,250,100,30);
        passwordLabel.setBounds(200,320,100,30);
        userTextField.setBounds(300,250,150,30);
        passwordField.setBounds(300,320,150,30);
        loginButton.setBounds(200,400,100,30);
        resetButton.setBounds(350,400,100,30);
        showPassword.setBounds(300,350,150,30);
    }
    public void addComponentsToContainer()
    {
        container.add(title);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(resetButton);
        container.add(showPassword);
    }
    public void addActionEvent()
    {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==loginButton)
        {
            String userText;
            String pwdText;
            userText=userTextField.getText();
            pwdText=passwordField.getText();
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql:///project","root","");
                Statement stmt=con.createStatement();
                String sql="select * from user where uid='"+userText+"'";
                ResultSet rs=stmt.executeQuery(sql);
                int i=0;
                while(rs.next())
                {
                    String username=rs.getString("uid");
                    String password=rs.getString("pass");
                    if((userText.equals(username))&&(pwdText.equals(password)))
                    {
                        i=1;
                    }}
                if(i==1)
                {
                    Form1 form = new Form1();
                    form.setTitle("HOSPITAL MANAGEMENT SYSTEM");
                    form.setVisible(true);
                    form.setBounds(100,100,740,700);
                    form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    form.setResizable(false);
                    this.setVisible(false);
                }
                else if(i==0)
                {
                    JOptionPane.showMessageDialog(null,"Invalid Login","alert",JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch(Exception e1){}

        }
        if(e.getSource()==resetButton)
        {
            userTextField.setText("");
            passwordField.setText("");
        }
        if(e.getSource()==showPassword)
        {
            if(showPassword.isSelected())
            {
                passwordField.setEchoChar((char)0);
            }
            else
            {
                passwordField.setEchoChar('*');
            }
        }
    }
}