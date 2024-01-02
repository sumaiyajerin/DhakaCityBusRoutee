package dhakacitybusroutee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DhakaCityBusRoutee extends JFrame implements ActionListener {
    private JLabel imgl,wlcL;
    private Container c;
    private ImageIcon img;
    private JPanel p1,p2;
    private JButton b1,b2;
    private Font f,f1;
    private Cursor cursor;
    DhakaCityBusRoutee()
    {
        Firstwindow();
    }
    void Firstwindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,40,600,690);
        c=getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);
        f=new Font("Arial",Font.BOLD,18);
        f1=new Font("Arial",Font.BOLD+Font.LAYOUT_LEFT_TO_RIGHT,26);
        cursor=new Cursor(Cursor.HAND_CURSOR);
        p1=new JPanel();
        p1.setBounds(10,10,560,350);
        c.add(p1);

        p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(10,380,560,260);
        p2.setBackground(Color.CYAN);
        c.add(p2);

        

        wlcL=new JLabel("Welcome to Dhaka City Bus Route Finder");
        wlcL.setBounds(20,20,530,60);
        wlcL.setForeground(Color.black);
        wlcL.setFont(f1);
        p2.add(wlcL);

        b1=new JButton("ADMIN PANNEL");
        b1.setBounds(40,115,200,60);
        b1.setFont(f);
        b1.setCursor(cursor);
        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.BLACK);
        p2.add(b1);

        b2=new JButton("GENERAL PUBLIC");
        b2.setFont(f);
        b2.setBounds(300,115,200,60);
        b2.setCursor(cursor);
        b2.setBackground(Color.YELLOW);
        b2.setForeground(Color.BLACK);
        p2.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            dispose();
            Login frame=new Login();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        if(e.getSource()==b2)
        {
            dispose();
            General frame=new General();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }

    public static void main(String[] args) {
        DhakaCityBusRoutee frame=new DhakaCityBusRoutee();
        frame.setVisible(true);

    }

}
