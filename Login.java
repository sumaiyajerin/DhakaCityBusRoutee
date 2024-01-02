package dhakacitybusroutee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private Container c;
    private JLabel UserNameLV,PasswordLV;
    private JTextField UserName;
    private JPasswordField password;
    private JButton logb,cls;
    private JPanel p;
    private Font f;
    private Cursor cursor;
    Login()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,40,600,690);
        c=getContentPane();
        c.setBackground(Color.green);
        c.setLayout(null);
        cursor=new Cursor(Cursor.HAND_CURSOR);
        f=new Font("Arial",Font.BOLD,16);

        p=new JPanel();
        p.setBounds(100,130,380,390);
        p.setLayout(null);
        c.add(p);

        UserNameLV=new JLabel("UserName");
        UserNameLV.setBounds(40,40,100,50);
        UserNameLV.setFont(f);
        p.add(UserNameLV);

        UserName=new JTextField();
        UserName.setBounds(40,80,300,50);
        UserName.setFont(f);
        p.add(UserName);

        PasswordLV=new JLabel("Password");
        PasswordLV.setBounds(40,130,100,50);
        PasswordLV.setFont(f);
        p.add(PasswordLV);

        password=new JPasswordField();
        password.setBounds(40,170,300,50);
        password.setFont(f);
        password.setEchoChar('*');
        p.add(password);

        logb=new JButton("LOGIN");
        logb.setBounds(40,240,300,50);
        logb.setCursor(cursor);
        logb.setFont(f);
        logb.setBackground(Color.magenta);
        p.add(logb);

        cls=new JButton("Cancel");
        cls.setBounds(40,300,300,50);
        cls.setCursor(cursor);
        cls.setFont(f);
        cls.setBackground(Color.yellow);
        p.add(cls);

        logb.addActionListener(this);
        cls.addActionListener(this);



    }

    
    public void actionPerformed(ActionEvent e) {
        String username=UserName.getText();
        String pass=password.getText();
        if(e.getSource()==logb)
        {
            if(username.equals("jerin") && pass.equals("123"))
            {
                JOptionPane.showMessageDialog(null,"Login Succesfully");
                dispose();
                AdminPannel frame=new AdminPannel();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
            else
                JOptionPane.showMessageDialog(null,"Oops! UserName Or Password Wrong");
        }
        if(e.getSource()==cls)
        {
            dispose();
            DhakaCityBusRoutee fr=new DhakaCityBusRoutee();
            fr.setVisible(true);
            fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }
    public static void main(String[] args) {
        Login frame=new Login();
        frame.setVisible(true);

    }

}
