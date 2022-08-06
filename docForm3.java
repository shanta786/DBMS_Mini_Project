package HospitalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class docForm3 extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");

    JLabel did = new JLabel("Enter the Doctor ID:");
    JLabel id = new JLabel("ID");
    JLabel name = new JLabel("Name");
    JLabel spl = new JLabel("Specialization");
    JLabel timing = new JLabel("Timing");
    JLabel qlf = new JLabel("Qualification");
    JLabel rmno = new JLabel("Room No.");

    JTextField tdid = new JTextField();
    JTextField tid = new JTextField();
    JTextField tname = new JTextField();
    JTextField tspl = new JTextField();
    JTextField ttiming = new JTextField();
    JTextField tqlf = new JTextField();
    JTextField trmno = new JTextField();

    JButton rgButton = new JButton("Delete");
    JButton backButton = new JButton("Back");
    JButton searchButton = new JButton("Search");

    docForm3(){
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

        spl.setBounds(200, 230, 150, 30);
        spl.setFont(new Font("Arial", Font.BOLD, 20));

        timing.setBounds(200, 270, 150, 30);
        timing.setFont(new Font("Arial", Font.BOLD, 20));

        qlf.setBounds(200, 310, 150, 30);
        qlf.setFont(new Font("Arial", Font.BOLD, 20));

        rmno.setBounds(200, 350, 150, 30);
        rmno.setFont(new Font("Arial", Font.BOLD, 20));

        tdid.setBounds(360, 100, 200, 30);
        tid.setFont(new Font("Arial", Font.BOLD, 15));

        tid.setBounds(360, 150, 200, 30);
        tid.setFont(new Font("Arial", Font.BOLD, 15));

        tname.setBounds(360, 190, 200, 30);
        tname.setFont(new Font("Arial", Font.BOLD, 15));

        tspl.setBounds(360, 230, 200, 30);
        tspl.setFont(new Font("Arial", Font.BOLD, 15));

        ttiming.setBounds(360, 270, 200, 30);
        ttiming.setFont(new Font("Arial", Font.BOLD, 15));

        tqlf.setBounds(360, 310, 200, 30);
        tqlf.setFont(new Font("Arial", Font.BOLD, 15));

        trmno.setBounds(360, 350, 200, 30);
        trmno.setFont(new Font("Arial", Font.BOLD, 15));

        rgButton.setBounds(250, 500, 100, 30);
        rgButton.setFont(new Font("Arial", Font.BOLD, 15));

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
        container.add(spl);
        container.add(timing);
        container.add(qlf);
        container.add(rmno);

        container.add(tdid);
        container.add(tid);
        container.add(tname);
        container.add(tspl);
        container.add(ttiming);
        container.add(tqlf);
        container.add(trmno);

        container.add(rgButton);
        container.add(backButton);
        container.add(searchButton);
    }
    public void addActionEvent()
    {
        rgButton.addActionListener(this);
        backButton.addActionListener(this);
        searchButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rgButton) {
            String aa;
            aa = tdid.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///project", "root", "");
                Statement stmt = con.createStatement();
                String sql = "delete from doctor where id='"+aa+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Records deleted successfully");

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
                String sql = "select * from doctor where id='" + a1 + "'";
                ResultSet rs = stmt.executeQuery(sql);
                int i = 0;
                while (rs.next()) {
                    tid.setText(rs.getString("id"));
                    tname.setText(rs.getString("name"));
                    tspl.setText(rs.getString("specialization"));
                    ttiming.setText(rs.getString("timing"));
                    tqlf.setText(rs.getString("qulification"));
                    trmno.setText(rs.getString("room_no"));
                }
            }
            catch (Exception e12){}
        }
        if(e.getSource() == backButton)
        {
            Form2 form = new Form2();
            form.setTitle("HOSPITAL MANAGEMENT SYSTEM");
            form.setVisible(true);
            form.setBounds(100,100,740,700);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setResizable(false);
            this.setVisible(false);
        }
    }
}
