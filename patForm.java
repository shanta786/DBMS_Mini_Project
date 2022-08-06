package HospitalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class patForm extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");

    JLabel id = new JLabel("ID");
    JLabel name = new JLabel("Name");
    JLabel dis = new JLabel("Disease");
    JLabel gen = new JLabel("Gender");
    JLabel admsts = new JLabel("Admit Status");
    JLabel age = new JLabel("Age");

    String gn[] = {"Male","Female"};
    String as[] = {"Yes","No"};

    JTextField tid = new JTextField();
    JTextField tname = new JTextField();
    JTextField tdis = new JTextField();
    JComboBox tgen = new JComboBox(gn);
    JComboBox tadmsts = new JComboBox(as);
    JTextField tage = new JTextField();

    JButton addButton = new JButton("Add");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back");

    patForm(){
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
        title.setBounds(75, 100, 650, 35);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.RED);

        id.setBounds(200, 150, 150, 35);
        id.setFont(new Font("Arial", Font.BOLD, 20));

        name.setBounds(200, 190, 150, 35);
        name.setFont(new Font("Arial", Font.BOLD, 20));

        dis.setBounds(200, 230, 150, 35);
        dis.setFont(new Font("Arial", Font.BOLD, 20));

        gen.setBounds(200, 270, 150, 35);
        gen.setFont(new Font("Arial", Font.BOLD, 20));

        admsts.setBounds(200, 310, 150, 35);
        admsts.setFont(new Font("Arial", Font.BOLD, 20));

        age.setBounds(200, 350, 150, 35);
        age.setFont(new Font("Arial", Font.BOLD, 20));

        tid.setBounds(360, 150, 200, 35);
        tid.setFont(new Font("Arial", Font.BOLD, 15));

        tname.setBounds(360, 190, 200, 35);
        tname.setFont(new Font("Arial", Font.BOLD, 15));

        tdis.setBounds(360, 230, 200, 35);
        tdis.setFont(new Font("Arial", Font.BOLD, 15));

        tgen.setBounds(360, 270, 200, 35);
        tgen.setFont(new Font("Arial", Font.BOLD, 15));

        tadmsts.setBounds(360, 310, 200, 35);
        tadmsts.setFont(new Font("Arial", Font.BOLD, 15));

        tage.setBounds(360, 350, 200, 35);
        tage.setFont(new Font("Arial", Font.BOLD, 15));

        addButton.setBounds(250, 500, 100, 35);
        addButton.setFont(new Font("Arial", Font.BOLD, 15));

        resetButton.setBounds(370, 500, 100, 35);
        resetButton.setFont(new Font("Arial", Font.BOLD, 15));

        backButton.setBounds(490, 500, 100, 35);
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
    }
    public void addComponentsToContainer() {
        container.add(title);
        container.add(id);
        container.add(name);
        container.add(dis);
        container.add(gen);
        container.add(admsts);
        container.add(age);

        container.add(tid);
        container.add(tname);
        container.add(tdis);
        container.add(tgen);
        container.add(tadmsts);
        container.add(tage);

        container.add(addButton);
        container.add(resetButton);
        container.add(backButton);
    }
    public void addActionEvent()
    {
        addButton.addActionListener(this);
        resetButton.addActionListener(this);
        backButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String a;
            String b;
            String c;
            String d;
            String e1;
            String f;
            a = tid.getText();
            b = tname.getText();
            c = tdis.getText();
            d = tgen.getSelectedItem().toString();
            e1 = tadmsts.getSelectedItem().toString();
            f = tage.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///project", "root", "");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("insert into patient values('" + a + "','" + b + "','" + c + "','" + d + "','" + e1 + "','" + f + "')");
                JOptionPane.showMessageDialog(this, "Records inserted successfully");

            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
        if (e.getSource() == resetButton) {
            tid.setText("");
            tname.setText("");
            tdis.setText("");
            tage.setText("");
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
