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
        //testTree();
    }
  
    public static void Import(String s){
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
    
    public static void testTree(){
        NodeTree N = new NodeTree();
        int[] birth = {1,2,3};
        int[] death = {4,5,6};
        TupleList t = new TupleList();
        t.add("H", "Hz");
        t.add("I", "Iz");
        t.add("J", "Jz");
        N.addNode("A", "Az", 3, 'm', birth, death, "B", "Bz", "C", "Cz");
        //N.addNode("A", "Az", 'm', "B", "Bz", "C", "Cz");
        N.addNode("B", "Bz", 'm', "D", "Dz", "E", "Ez");
        N.addNode("C", "Cz", 'f', "F", "Fz", "G", "Gz");
        
        System.out.println(N.printCurrNode());
        N.tMother();
        System.out.println(N.printCurrName());
        N.tFather();
        System.out.println(N.printCurrName());
        N.tChild("C", "Cz");
        System.out.println(N.printCurrName());
        N.tChild("A", "Az");
        System.out.println(N.printCurrName());
    }
}
