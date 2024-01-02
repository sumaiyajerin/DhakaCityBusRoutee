package dhakacitybusroutee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;
public class AdminPannel extends JFrame implements ActionListener {
    private Container c;
    private JPanel p1,p2;
    private JLabel wlcL,Froml,Tol,Rentl,Kml,BusL;
    private JButton addb,updb,delb,cls,HomeB;
    private JTextField From,To,Bus,Rent,Km;
    private JTable table;
    private DefaultTableModel tablemodel;
    private JScrollPane sc;
    private Cursor cursor;
    String[] col={"From","To","Bus_Name","KM","Rent"};
    String[] row=new String[5];
    private Font f,f1;
    AdminPannel()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,40,600,690);
        c=getContentPane();
        c.setBackground(Color.green);
        c.setLayout(null);
        cursor=new Cursor(Cursor.HAND_CURSOR);

        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);

        p1=new JPanel();
        p1.setBounds(10,10,560,320);
        p1.setBackground(Color.white);
        p1.setLayout(null);
        c.add(p1);

        p2=new JPanel();
        p2.setBounds(10,340,560,290);
        p2.setBackground(Color.white);
        p2.setLayout(null);
        c.add(p2);


        wlcL=new JLabel("Admin pannel");
        wlcL.setBounds(200,0,300,30);
        wlcL.setFont(f);
        wlcL.setForeground(Color.BLACK);
        p1.add(wlcL);

        Froml=new JLabel("From :");
        Froml.setFont(f1);
        Froml.setBounds(20,60,100,40);
        p1.add(Froml);

        From=new JTextField();
        From.setBounds(140,60,200,40);
        From.setFont(f1);
        p1.add(From);

        Tol=new JLabel("To :");
        Tol.setFont(f1);
        Tol.setBounds(20,110,100,40);
        p1.add(Tol);

        To=new JTextField();
        To.setBounds(140,110,200,40);
        To.setFont(f1);
        p1.add(To);

        BusL=new JLabel("BusName :");
        BusL.setFont(f1);
        BusL.setBounds(20,160,120,40);
        p1.add(BusL);

        Bus=new JTextField();
        Bus.setFont(f1);
        Bus.setBounds(140,160,200,40);
        p1.add(Bus);

        Kml=new JLabel("Kilometre :");
        Kml.setFont(f1);
        Kml.setBounds(20,210,120,40);
        p1.add(Kml);

        Km=new JTextField();
        Km.setBounds(140,210,200,40);
        Km.setFont(f1);
        p1.add(Km);

        Rentl=new JLabel("RENT :");
        Rentl.setFont(f1);
        Rentl.setBounds(20,260,100,40);
        p1.add(Rentl);

        Rent=new JTextField();
        Rent.setFont(f1);
        Rent.setBounds(140,260,200,40);
        Rent.setCursor(cursor);
        p1.add(Rent);

        HomeB=new JButton("Home");
        HomeB.setBounds(400,25,150,40);
        HomeB.setBackground(Color.yellow);
        HomeB.setFont(f1);
        p1.add(HomeB);

        addb =new JButton("ADD PLACE");
        addb.setBounds(400,70,150,55);
        addb.setFont(f1);
        addb.setBackground(Color.green);
        addb.setCursor(cursor);
        p1.add(addb);

        updb =new JButton("UPDATE");
        updb.setBounds(400,130,150,55);
        updb.setFont(f1);
        updb.setBackground(Color.green);
        updb.setCursor(cursor);
        p1.add(updb);

        delb=new JButton("DELETE");
        delb.setBounds(400,190,150,55);
        delb.setFont(f1);
        delb.setBackground(Color.green);
        delb.setCursor(cursor);
        p1.add(delb);

        cls=new JButton("CLEAR");
        cls.setBounds(400,250,150,55);
        cls.setFont(f1);
        cls.setBackground(Color.green);
        cls.setCursor(cursor);
        p1.add(cls);

        table=new JTable();

        tablemodel=new DefaultTableModel();
        tablemodel.setColumnIdentifiers(col);
        table.setModel(tablemodel);

        sc=new JScrollPane(table);
        sc.setBounds(0,0,560,290);
        p2.add(sc);

        HomeB.addActionListener(this);
        addb.addActionListener(this);
        updb.addActionListener(this);
        delb.addActionListener(this);
        cls.addActionListener(this);

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
                data(p, p1, b, r, k);
            }
        } catch (Exception e) {
            System.out.println(e);
        }



        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int nub_row=table.getSelectedRow();
                String fr,to,bus,km,rent;
                fr=tablemodel.getValueAt(nub_row,0).toString();
                to=tablemodel.getValueAt(nub_row,1).toString();
                bus=tablemodel.getValueAt(nub_row,2).toString();
                km=tablemodel.getValueAt(nub_row,3).toString();
                rent=tablemodel.getValueAt(nub_row,4).toString();
                From.setText(fr);
                To.setText(to);
                Bus.setText(bus);
                Km.setText(km);
                Rent.setText(rent);

            }
        });

    }
    void data(String fr ,String to,String b,String km,String rent)
    {
        row[0]=fr;
        row[1]=to;
        row[2]=b;
        row[3]=km;
        row[4]=rent;
        tablemodel.addRow(row);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==HomeB)
        {
            dispose();
            DhakaCityBusRoutee fr=new DhakaCityBusRoutee();
            fr.setVisible(true);
            fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        if(e.getSource()==addb)
        {
            if(From.getText().equals("")&&To.getText().equals("")&&Bus.getText().equals("")&&Km.getText().equals("")&&Rent.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill All Textfield");
            }
            else
            {

            row[0]=From.getText();
            row[1]=To.getText();
            row[2]=Bus.getText();
            row[3]=Km.getText();
            row[4]=Rent.getText();
            tablemodel.addRow(row);
            }

            try {
                FileWriter fw=new FileWriter("C:\\Users\\rakib\\OneDrive\\Documents\\text\\DhakaCity\\DataBase.txt",true);
                fw.write(From.getText()+" "+To.getText()+" "+Bus.getText()+" "+Km.getText()+" "+Rent.getText());
                fw.write(System.getProperty("line.separator"));
                fw.close();

            }catch (Exception b) {
                System.out.println(b);
            }

        }
        if(e.getSource()==updb)
        {
            int v=table.getSelectedRow();
            if(v>=0) {
                tablemodel.setValueAt(From.getText(), v, 0);
                tablemodel.setValueAt(To.getText(), v, 1);
                tablemodel.setValueAt(Bus.getText(), v, 2);
                tablemodel.setValueAt(Km.getText(), v, 3);
                tablemodel.setValueAt(Rent.getText(), v, 4);
                JOptionPane.showMessageDialog(null,"Update Successfully");
            }
            else JOptionPane.showMessageDialog(null,"Not Selected Row");
        }
        if(e.getSource()==delb)
        {
            int v=table.getSelectedRow();
            if(v>=0)
            {
                tablemodel.removeRow(v);
            }
            else JOptionPane.showMessageDialog(null,"Not Selected Row");
        }
        if(e.getSource()==cls)
        {
            From.setText("");
            To.setText("");
            Bus.setText("");
            Km.setText("");
            Rent.setText("");
        }

    }
    public static void main(String[] args) {

        AdminPannel frame=new AdminPannel();
        frame.setVisible(true);

    }

}
