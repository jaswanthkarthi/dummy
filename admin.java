package CRS;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class admin
{
    JFrame f = new JFrame("CAR RENTAL SYSTEM");
    JTextField tf1,tf2;
    JButton b1,b2,b3,b4,b5;
    JLabel l1,l2;
    JTable t;
    public admin()
    {
        b1 = new JButton("View Cars");
        b1.setBounds(120,270,180,30);
        f.add(b1);
        b2 = new JButton("Add Car");
        b2.setBounds(120,350,80,30);
        f.add(b2);
        b3 = new JButton("Delete Car");
        b3.setBounds(120,430,180,30);
        f.add(b3);
        b4 = new JButton("Update Status");
        b4.setBounds(120,510,120,30);
        f.add(b4);
        b5 = new JButton("Back");
        b5.setBounds(200,700,80,30);
        f.add(b5);
        b1.addActionListener(new ActionListener()
        {
            String l;
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int row = 0;
                    File file = new File("C:\\Users\\Nikhil\\Desktop\\cardetails1.csv");
                    BufferedReader b = new BufferedReader(new FileReader(file));
                    l = b.readLine();
                    //String [] c = l.split(",");
                    String[] c = {"carid","carname","carmodel","regno","mileage","damage","status"};
                    while ((l = b.readLine())!=null)
                    {
                        row++;
                    }
                    b.close();
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String d = br.readLine();
                    String[][] s = new String[row][7];
                    int r = -1;
                    while((d=br.readLine())!=null)
                    {
                        r++;
                        String[]data = d.split(",");
                        for(int i = 0;i<=6;i++)
                        {
                            s[r][i] = data[i];
                            System.out.println(s[r][i]);
                        }
                    }
                    //String[][] table = {{"1", "2", "3", "3", "3", "3", "3"}, {"1", "3", "2", "2", "2", "2", "2"}};
                    t = new JTable(s, c);
                    t.setBounds(30,40,200,300);
                    t.setPreferredScrollableViewportSize(new Dimension(450, 63));
                    t.setFillsViewportHeight(true);
                    t.setVisible(true);
                    t.setLayout(null);
                    //f.add(t);
                    JScrollPane jps = new JScrollPane(t);
                    f.add(jps);
                    br.close();
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new addCar();
                f.dispose();
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new deleteCar();
                f.dispose();
            }
        });
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new update();
                f.dispose();
            }
        });
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new main();
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(900,900);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
