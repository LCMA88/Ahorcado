/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.awt.*; 
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author LAURA
 */

public class Dibujo extends JPanel implements Runnable {
    private double angulo= Math.PI/4; 
    private int length; 
    
    private int demora; 
     
    private ActionListener Dibujo;
    
    public Dibujo(int length) {   
  
        this.length = length;
        setDoubleBuffered(true); 
    }
    
    @Override
    public void paint(Graphics g) {    
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        //g.fillRect(0, 0, 200, 200);
        g.setColor(Color.BLACK);
        int refX = getWidth() / 2, refY = getHeight() / 8;
        int cabezaX = refX + (int) (Math.sin(angulo) * length);
        int cabezaY = refY + (int) (Math.cos(angulo) * length);
        g.drawLine(refX, refY,20,refY);
        g.drawLine(20, refY, 20,200);
        g.drawLine(20, 200, 50, 200);
        g.drawLine(refX, refY, cabezaX, cabezaY);
        g.fillOval(cabezaX - 7, cabezaY - 7, 14, 14);
        g.drawLine(cabezaX,cabezaY, cabezaX+ (int) (20*Math.sin(angulo)),cabezaY+ (int)(20*Math.cos(angulo)));
        g.drawLine(cabezaX,cabezaY, cabezaX+ (int) (20*Math.sin(angulo)),cabezaY+ (int)(20*Math.cos(angulo)));
        g.drawLine(cabezaX+ (int) (20*Math.sin(angulo)),cabezaY+ (int)(20*Math.cos(angulo)),cabezaX+ (int) (20*Math.sin(angulo))+(int)(20*Math.sin(45)),cabezaY+ (int)(20*Math.cos(angulo))+(int)(20*Math.cos(45)));
        g.drawLine(cabezaX+ (int) (20*Math.sin(angulo)),cabezaY+ (int)(20*Math.cos(angulo)),cabezaX+ (int) (20*Math.sin(angulo))+(int)(20*Math.sin(-1*45)),cabezaY+ (int)(20*Math.cos(angulo))+(int)(20*Math.cos(-1*45))); 
        g.drawLine(cabezaX,cabezaY, cabezaX+(int)(20*Math.sin(45)), cabezaY+(int)(20*Math.cos(45)));
        g.drawLine(cabezaX,cabezaY, cabezaX+(int)(20*Math.sin(-1*45)), cabezaY+(int)(20*Math.cos(-1*45)));    
    
    }  

    @Override
    public void run() {
      double anguloD2, anguloD1 = 0, dt = 0.1;
        while (true) {
            demora=10; 
            anguloD2 = -9.81 / length * Math.sin(angulo);
            anguloD1 += anguloD2 * dt;
            angulo += anguloD1 * dt;
            repaint();
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
        }      
    }

       @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 300);
    }
    
    public void subirvelocidad(){
      demora=1; 
    }
    
    public void disminuirvelocidad(){
       demora=5; 
    }
 
     
       

         public void keyPressed (KeyEvent e){
         switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN: ;break;
            case KeyEvent.VK_UP: ;break;
    
          }
    }

   
    
            }      

    
    

