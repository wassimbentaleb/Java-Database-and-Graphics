/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Gassouma
 */
public class MyForm extends JFrame {

    JLabel examen = new JLabel("Examen");
    JButton b1 = new JButton("Liste");
    JButton b2 = new JButton("Ajouter");
    JLabel nomL = new JLabel("Nom");
    JLabel genreL = new JLabel("Genre");
    JRadioButton rH = new JRadioButton("Homme", true);
    JRadioButton rF = new JRadioButton("Femme");
    JTextField nomT = new JTextField();
    ButtonGroup bg = new ButtonGroup();

    public MyForm() {

        setTitle("Examen");
        setSize(500, 170);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rH.setActionCommand("Homme");
        bg.add(rH);
        rF.setActionCommand("Femme");
        bg.add(rF);

        JPanel Pgenre = new JPanel(new GridLayout(1, 2));
        Pgenre.add(rH);
        Pgenre.add(rF);

        JPanel Pinfo = new JPanel(new GridLayout(2, 2));
        Pinfo.add(nomL);
        Pinfo.add(nomT);
        Pinfo.add(genreL);
        Pinfo.add(Pgenre);

        JPanel Pbtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        Pbtn.add(b1);
        Pbtn.add(b2);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add("North", examen);
        c.add("Center", Pinfo);
        c.add("South", Pbtn);

        examen.setHorizontalAlignment(SwingConstants.CENTER);

        Pinfo.setBorder(BorderFactory.createTitledBorder("Information"));
        setVisible(true);

        MyEvents event = new MyEvents(this);
        b1.addActionListener(event);
        b2.addActionListener(event);
    }
}
