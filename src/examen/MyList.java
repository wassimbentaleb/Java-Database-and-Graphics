/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gassouma
 */
public class MyList extends JFrame {

    String entete[] = {"id", "Nom", "Genre",};
    DefaultTableModel model = new DefaultTableModel(entete, 0);
    JTable tab = new JTable(model);
    JScrollPane sp = new JScrollPane(tab);
    Canvas cv = new Canvas();
    Graphics g;
    MyThread myThread;

    public MyList() {
        setTitle("Examen");
        setSize(800, 700);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cv.setBackground(Color.white);
        cv.setPreferredSize(new Dimension(800, 300));

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add("Center", sp);
        c.add("South", cv);

        sp.setBorder(BorderFactory.createTitledBorder("Liste des utilisateurs"));
        setVisible(true);

        g = cv.getGraphics();

        myThread = new MyThread(this);
        myThread.start();
    }
}
