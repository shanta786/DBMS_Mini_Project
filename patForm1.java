package HospitalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class patForm1 extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");

    JLabel did = new JLabel("Enter the Patient ID:");
    JLabel id = new JLabel("ID");
    JLabel name = new JLabel("Name");
    JLabel dis = new JLabel("Disease");
    JLabel gen = new JLabel("Gender");
    JLabel admsts = new JLabel("Admit Status");
    JLabel age = new JLabel("Age");

    JTextField tdid = new JTextField();
    JTextField tid = new JTextField();
    JTextField tname = new JTextField();
    JTextField tdis = new JTextField();
    JTextField tgen = new JTextField();
    JTextField tadmsts = new JTextField();
    JTextField tage = new JTextField();

    JButton editButton = new JButton("Edit");
    JButton backButton = new JButton("Back");
    JButton searchButton = new JButton("Search");

    patForm1(){
        setLoyoutManager();
        setLocationSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLoyoutManager()
    {
        container.setLayout(null);
    }
    public void setLocationSize() {
        title.setBounds(75, 50, 650, 30);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.RED);

        did.setBounds(100, 100, 250, 30);
        did.setFont(new Font("Arial", Font.BOLD, 20));

        id.setBounds(200, 150, 150, 30);
        id.setFont(new Font("Arial", Font.BOLD, 20));

        name.setBounds(200, 190, 150, 30);
        name.setFont(new Font("Arial", Font.BOLD, 20));

        dis.setBounds(200, 230, 150, 30);
        dis.setFont(new Font("Arial", Font.BOLD, 20));

        gen.setBounds(200, 270, 150, 30);
        gen.setFont(new Font("Arial", Font.BOLD, 20));

        admsts.setBounds(200, 310, 150, 30);
        admsts.setFont(new Font("Arial", Font.BOLD, 20));

        age.setBounds(200, 350, 150, 30);
        age.setFont(new Font("Arial", Font.BOLD, 20));

        tdid.setBounds(360, 100, 200, 30);
        tid.setFont(new Font("Arial", Font.BOLD, 15));

        tid.setBounds(360, 150, 200, 30);
        tid.setFont(new Font("Arial", Font.BOLD, 15));

        tname.setBounds(360, 190, 200, 30);
        tname.setFont(new Font("Arial", Font.BOLD, 15));

        tdis.setBounds(360, 230, 200, 30);
        tdis.setFont(new Font("Arial", Font.BOLD, 15));

        tgen.setBounds(360, 270, 200, 30);
        tgen.setFont(new Font("Arial", Font.BOLD, 15));

        tadmsts.setBounds(360, 310, 200, 30);
        tadmsts.setFont(new Font("Arial", Font.BOLD, 15));

        tage.setBounds(360, 350, 200, 30);
        tage.setFont(new Font("Arial", Font.BOLD, 15));

        editButton.setBounds(250, 500, 100, 30);
        editButton.setFont(new Font("Arial", Font.BOLD, 15));

        backButton.setBounds(490, 500, 100, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 15));

        searchButton.setBounds(570, 100, 100, 30);
        searchButton.setFont(new Font("Arial", Font.BOLD, 15));
    }
    public void addComponentsToContainer() {
        container.add(title);
        container.add(did);
        container.add(id);
        container.add(name);
        container.add(dis);
        container.add(gen);
        container.add(admsts);
        container.add(age);

        container.add(tdid);
        container.add(tid);
        container.add(tname);
        container.add(tdis);
        container.add(tgen);
        container.add(tadmsts);
        container.add(tage);

        container.add(editButton);
        container.add(backButton);
        container.add(searchButton);
    }
    public void addActionEvent()
    {
        editButton.addActionListener(this);
        backButton.addActionListener(this);
        searchButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editButton) {
            String a;
            String b;
            String c;
            String d;
            String e1;
            String f;
            String aa;
            aa = tdid.getText();
            a = tid.getText();
            b = tname.getText();
            c = tdis.getText();
            d = tgen.getText();
            e1 = tadmsts.getText();
            f = tage.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///project", "root", "");
                Statement stmt = con.createStatement();
                String sql = "update patient set id='"+a+"',name='"+b+"',disease='"+c+"',gender='"+d+"',admit_status='"+e1+"',age='"+f+"' where id='"+aa+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Record updated successfully");

            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
        if(e.getSource()==searchButton) {
            String a1 = tdid.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///project", "root", "");
                Statement stmt = con.createStatement();
                String sql = "select * from patient where id='" + a1 + "'";
                ResultSet rs = stmt.executeQuery(sql);
                int i = 0;
                while (rs.next()) {
                    tid.setText(rs.getString("id"));
                    tname.setText(rs.getString("name"));
                    tdis.setText(rs.getString("disease"));
                    tgen.setText(rs.getString("gender"));
                    tadmsts.setText(rs.getString("admit_status"));
                    tage.setText(rs.getString("age"));
                }
            }
            catch (Exception e12){}
        }
        if(e.getSource() == backButton)
        {
            Form3 form = new Form3();
            form.setTitle("HOSPITAL MANAGEMENT SYSTEM");
            form.setVisible(true);
            form.setBounds(100,100,740,700);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setResizable(false);
            this.setVisible(false);
        }
    }
}
