/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import java.awt.Canvas;

/**
 *
 * @author Gassouma
 */
public class MyThread extends Thread {

    MyDataBase connexion;
    MyList list;

    public MyThread(MyList list) {
        this.list = list;
        connexion = new MyDataBase();
    }

    public void run() {
        while (true) {
            list.repaint();
            connexion.remplireMyList(list.model, list.g);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread error: " + e);
            }
        }
    }
}
