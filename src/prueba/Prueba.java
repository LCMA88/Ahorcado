/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author LAURA
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("Ahorcado");
        Dibujo p = new Dibujo(40);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        new Thread(p).start();
        System.out.println("Ingrese la opcion que desee elegir ");
        System.out.println("Presione la tecla UP para aumentar la velocidad");
        System.out.println("Presione la tecla DOWN para disminuir la velocidad");
        System.out.println("Presione S para detener");
        System.out.println("Presione R para salir");
        Scanner sc= new Scanner(System.in); 
        String opcion; 
        opcion= sc.nextLine(); 
        switch(opcion){
            case "S":p.disminuirvelocidad(); break;
        }
        




    }
    
}
