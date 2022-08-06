package HospitalManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form3 extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
    JLabel title1 = new JLabel("Welcome to Patients Details");

    JButton addButton = new JButton("Add Record");
    JButton editButton = new JButton("Edit Record");
    JButton searchButton = new JButton("Search Record");
    JButton deleteButton = new JButton("Delete Record");
    JButton backButton = new JButton("Back");

    Form3() {
        setLayoutManager();
        setLocationSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager() {
        container.setLayout(null);
    }
    public void setLocationSize() {
        title.setBounds(75, 100, 650, 35);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.RED);

        title1.setBounds(125, 150, 650, 35);
        title1.setFont(new Font("Arial", Font.BOLD, 25));
        title1.setForeground(Color.RED);

        addButton.setBounds(200, 200, 300, 30);
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        editButton.setBounds(200, 300, 300, 30);
        editButton.setFont(new Font("Arial", Font.PLAIN, 20));
        searchButton.setBounds(200, 400, 300, 30);
        searchButton.setFont(new Font("Arial", Font.PLAIN, 20));
        deleteButton.setBounds(200, 500, 300, 30);
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setBounds(200, 600, 300, 30);
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
    }
    public void addComponentsToContainer() {
        container.add(title);
        container.add(title1);
        container.add(addButton);
        container.add(editButton);
        container.add(searchButton);
        container.add(deleteButton);
        container.add(backButton);

    }
    public void addActionEvent()
    {
        backButton.addActionListener(this);
        addButton.addActionListener(this);
        editButton.addActionListener(this);
        searchButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            Form1 form = new Form1();
            form.setTitle("HOSPITAL MANAGEMENT SYSTEM");
            form.setVisible(true);
            form.setBounds(100, 100, 740, 700);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setResizable(false);
            this.setVisible(false);
        }
        if (e.getSource() == addButton) {
            patForm form = new patForm();
            form.setTitle("HOSPITAL MANAGEMENT SYSTEM");
            form.setVisible(true);
            form.setBounds(100, 100, 740, 700);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setResizable(false);
            this.setVisible(false);
        }
        if (e.getSource() == editButton) {
            patForm1 form = new patForm1();
            form.setTitle("HOSPITAL MANAGEMENT SYSTEM");
            form.setVisible(true);
            form.setBounds(100, 100, 740, 700);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setResizable(false);
            this.setVisible(false);
        }
        if (e.getSource() == searchButton) {
            patForm2 form = new patForm2();
            form.setTitle("HOSPITAL MANAGEMENT SYSTEM");
            form.setVisible(true);
            form.setBounds(100, 100, 740, 700);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setResizable(false);
            this.setVisible(false);
        }
        if (e.getSource() == deleteButton) {
            patForm3 form = new patForm3();
            form.setTitle("HOSPITAL MANAGEMENT SYSTEM");
            form.setVisible(true);
            form.setBounds(100, 100, 740, 700);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            form.setResizable(false);
            this.setVisible(false);
        }
    }
}
