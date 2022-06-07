/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gassouma
 */
public class MyDataBase {

    Connection con;
    Statement stm;

    public MyDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver loading error :" + e);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/examen", "root", "");
            System.out.println("Database connected");
        } catch (SQLException e) {
            System.out.println("Error opening SQL connection :" + e);
        }
    }

    int ajouter(Personne p) {
        try {
            stm = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Error creating SQL statement :" + e);
            return 0;
        }

        try {
            stm.executeUpdate("insert into utilisateur (nom, genre) values ('" + p.getNom() + "','" + p.getGenre() + "')");
        } catch (SQLException e) {
            System.out.println("Error exectuting query:" + e);
            return 0;
        }

        return 1;
    }

    void remplireMyList(DefaultTableModel model, Graphics g) {

        int sommeHomme = 0;
        int sommeFemme = 0;

        model.setRowCount(0);

        try {
            stm = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Error de creation de statement");
        }

        try {
            ResultSet res = stm.executeQuery("select * from utilisateur");
            while (res.next()) {
                model.addRow(
                        new Object[]{
                            res.getString(1), res.getString(2), res.getString(3)
                        }
                );

                if (res.getString(3).equals("Homme")) {
                    sommeHomme++;
                } else {
                    sommeFemme++;
                }
            }
        } catch (SQLException e) {
            System.out.println("erreur de remplissage de tablaeu");
        }

        // start drawing rectangles 
        
        // 200px => 20 personnes 
        // 10px => 1 personne
        
        int restHomme = 20 - sommeHomme;
        int restFemme = 20 - sommeFemme;

        // rectangle homme
        g.setColor(Color.BLUE);
        g.fillRect(100, 80 + (restHomme * 10), 50, 200 - (restHomme * 10));

        // rectangle femme
        g.setColor(Color.RED);
        g.fillRect(200, 80 + (restFemme * 10), 50, 200 - (restFemme * 10));

        // label homme
        g.setColor(Color.BLACK);
        g.drawString("Homme: " + Integer.toString(sommeHomme), 95, 295);

        // label femme
        g.setColor(Color.BLACK);
        g.drawString("Femme: " + Integer.toString(sommeFemme), 195, 295);

        // axe y
        g.drawLine(20, 280, 20, 20);
        g.drawLine(20, 20, 15, 25);
        g.drawLine(20, 20, 25, 25);

        // axe x
        g.drawLine(20, 280, 750, 280);
        g.drawLine(750, 280, 745, 285);
        g.drawLine(750, 280, 745, 275);
    }
}
