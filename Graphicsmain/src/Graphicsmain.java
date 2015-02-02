/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniposi
 */
import javax.swing.*;

public class Graphicsmain {
    public static void main(String[] args){
        JFrame f = new JFrame("Title");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graphicsrun gr = new Graphicsrun();
        f.add(gr);
        f.setSize(800,700);
        f.setVisible(true);
    }
}
