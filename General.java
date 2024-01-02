package dhakacitybusroutee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class General extends JFrame implements ActionListener {
    private Container c;
    private JPanel p,p1,p2;
    private JLabel imgl,wlc,FromL,ToL;
    private JTextField From,To;
    private JTextArea TR;
    private JButton Search,cls;
    private Cursor cursor;
    private ImageIcon img;
    private Font f,f1;
    int C=0;

    General()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,40,600,690);
        c=getContentPane();
        c.setBackground(Color.green);
        c.setLayout(null);
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,16);
        cursor =new Cursor(Cursor.HAND_CURSOR);


        p=new JPanel();
        p.setBounds(5,5,575,175);
        p.setBackground(Color.BLACK);
        c.add(p);

        p1=new JPanel();
        p1.setBounds(5,185,575,200);
        p1.setBackground(Color.white);
        p1.setLayout(null);
        c.add(p1);

        p2=new JPanel();
        p2.setBounds(5,390,575,255);
        p2.setBackground(Color.white);
        p2.setLayout(null);
        c.add(p2);



        wlc=new JLabel("Welcome to Dhaka City Bus Route Finder");
        wlc.setBounds(90,-5,400,40);
        wlc.setFont(f);
        wlc.setForeground(Color.black);
        p1.add(wlc);

        FromL=new JLabel("From :");
        FromL.setBounds(120,30,200,40);
        FromL.setFont(f1);
        p1.add(FromL);

        From=new JTextField();
        From.setBounds(180,30,190,40);
        From.setFont(f1);
        p1.add(From);

        ToL=new JLabel("To :");
        ToL.setBounds(120,80,200,40);
        ToL.setFont(f1);
        p1.add(ToL);

        To=new JTextField();
        To.setBounds(180,80,190,40);
        To.setFont(f1);
        p1.add(To);

        cls=new JButton("Home");
        cls.setBounds(490,5,80,40);
        cls.setFont(f1);
        cls.setBackground(Color.yellow);
        cls.setCursor(cursor);
        p1.add(cls);

        Search =new JButton("Search");
        Search.setBounds(200,130,150,40);
        Search.setFont(f1);
        Search.setBackground(Color.green);
        Search.setCursor(cursor);
        p1.add(Search);

        TR=new JTextArea();
        TR.setLineWrap(true);
        TR.setWrapStyleWord(true);
        TR.setBounds(5,5,565,245);
        TR.setBackground(Color.green);
        TR.setFont(f1);
        p2.add(TR);

        try {
            File file = new File("C:\\Users\\Nabil\\OneDrive\\Documents\\DhakaCity\\DhakaCity\\DataBase.txt");
            Scanner sc1 = new Scanner(file);
            String p, p1, b;
            String r, k;
            while (sc1.hasNext()) {
                p = sc1.next();
                p1 = sc1.next();
                b = sc1.next();
                r = sc1.next();
                k = sc1.next();
                addDetails(p, p1, b, r, k);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Search.addActionListener(this);
        cls.addActionListener(this);

    }
    RInformation[] information=new RInformation[1000];

    public void addDetails(String p, String p1, String b, String r, String k) {
        information[C] = new RInformation(p, p1, b, r, k);
        C++;
    }

    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cls)
        {
            dispose();
            DhakaCityBusRoutee fr=new DhakaCityBusRoutee();
            fr.setVisible(true);
            fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        if(e.getSource()==Search)
        {
            if(From.getText().isEmpty()&&To.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Your Textfield is Emty");
            }
            else {
                int f = 0, a = 0;
                String p = From.getText();
                String p1 = To.getText();
                for (int i = 0; i < C; i++) {
                    if (information[i].place.equals(p) && information[i].place1.equals(p1)) {

                        f = 1;
                        a = i;
                    }

                }
                if (f == 1) {
                    TR.setText("");
                    TR.append("\n\t...Searching Information...\n\n");
                    String Busn = information[a].Bus;
                    String KM = information[a].km;
                    String RentT = information[a].rent;
                    String FROM = information[a].place;
                    String TO = information[a].place1;

                    TR.append("\tDestination: " + FROM + " To " + TO + "\n" + "\t     Bus Name: " + Busn + "\n" + "         " +
                            "           Kilometer: " + KM + "km" +
                            "               Rent: " + RentT + "Tk");
                } else {
                    TR.setText("");
                    TR.append("\n\t             ...Searching Information...\n\tOOPS! Not Found.Please Try Again");
                }
            }
        }

    }
    public static void main(String[] args) {
        General frame=new General();
        frame.setVisible(true);
    }

}
class RInformation {
    String place;
    String place1;
    String Bus;
    String km;
    String rent;

    RInformation(String place, String place1, String Bus, String km, String rent) {
        this.place = place;
        this.place1 = place1;
        this.Bus = Bus;
        this.km = km;
        this.rent = rent;
    }
}
 