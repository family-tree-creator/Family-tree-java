/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniposi
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class Graphicsmain {
    public static void main(String[] args){
        JFrame f = new JFrame("Family Tree");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graphicsrun gr = new Graphicsrun();
        f.add(gr);
        f.setSize(1200,900);
        f.setVisible(true);
    }
  
    public void Import(String s){
        FileReader in = null;
        try{
            in = new FileReader(s);
            BufferedReader br = new BufferedReader(in);
            String check;
            while((check = br.readLine()) != null){
                System.out.println(check);
            }
            in.close();
        }catch(IOException failRead) { //add catch for unable to open file
            System.err.println(failRead.getMessage());
        }
    }
    
    public void testTree(){
        NodeTree N = new NodeTree();
        N.addNode("A", "Az");
        
    }
}
