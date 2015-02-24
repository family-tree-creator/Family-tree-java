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
        
        /* all temporary - can be deleted */
        NodeTree N = new NodeTree();  
        int[]birth = new int[3];
        birth[0]=9;
        birth[1]=25;
        birth[2]=1968;
        int[]death = new int[3];
        N.addNode("Will","Smith",'m',birth,death,"Willard","Smith","Caroline","Bright"); //temp
        /* end of temp to delete  */
        
        Graphicsrun gr = new Graphicsrun(N);
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
        TupleList t2 = new TupleList();
        t2.add("A", "Az");
        t2.add("L", "Lz");
        N.addNode("A", "Az",'m', birth, death, "B", "Bz", "C", "Cz", t);
        //N.addNode("A", "Az", 'm', "B", "Bz", "C", "Cz");
        N.addNode("B", "Bz", 'm', birth, death, "D", "Dz", "E", "Ez", t2);
        //N.addNode("B", "Bz", 'm', "D", "Dz", "E", "Ez");
        N.addNode("C", "Cz", 'f', "F", "Fz", "G", "Gz");
        N.addNode("H", "Hz", 'f', "A", "Az", "K", "Kz");
        
        System.out.println(N.printCurrNode());// + " " + Integer.toString(N.currNumC()));
        N.tMother();
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tFather();
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tChild("C", "Cz");
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tChild("A", "Az");
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tChild(0);
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tMother();
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tChild(0);
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tFather();
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tFather();
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tChild("A", "Az");
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tChild(0);
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tFather();
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tFather();
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
        N.tChild(1);
        System.out.println(N.printCurrName());// + " " + Integer.toString(N.currNumC()));
    }
}
