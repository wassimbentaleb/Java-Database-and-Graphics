/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gassouma
 */
public class MyEvents implements ActionListener {
    
    MyDataBase connexion;
    MyForm fenetre;
    
    public MyEvents(MyForm f) {
        fenetre = f;
        connexion = new MyDataBase();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fenetre.b2) {     
            String nom = fenetre.nomT.getText();
            String genre = fenetre.bg.getSelection().getActionCommand();
                    
            Personne p = new Personne(nom,genre);
            connexion.ajouter(p);
        } else if (e.getSource() == fenetre.b1) {
            new MyList();
        }
    }
}
