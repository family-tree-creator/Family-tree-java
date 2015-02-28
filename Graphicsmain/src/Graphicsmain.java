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
        //NodeTree N = new NodeTree();
        //N.addNode("Will","Smith",'m',"Willard","Smith","Caroline","Bright");
        Graphicsrun gr = new Graphicsrun(Import("test1.txt"));
        f.add(gr);
        f.setSize(1200,900);
        f.setVisible(true);
        //Import("test1.txt");
        //testTree();
    }
  
    public static NodeTree Import(String s){
        FileReader in = null;
        NodeTree N = new NodeTree();
        try{
            in = new FileReader(s);
            BufferedReader br = new BufferedReader(in);
            String check;
            while((check = br.readLine()) != null){
                //System.out.println(check);
                MakeNode(N, check);
                
            }
            in.close();
        }catch(IOException failRead) { //add catch for unable to open file
            System.err.println(failRead.getMessage());
        }
        return N;
    }
    
    public static void MakeNode(NodeTree T, String input){
        String[] info = input.split(";");
        //check for right size and has first and last name
        if(info.length < 10){
            System.err.println(info.length);
            System.err.println("Not enough info to make a node");
            return;
        }
        char gender = ' ';
        int[] birth = null;
        int[] death = null;
        TupleList child = null;
        String[] bdate;
        String[] ddate;
        String[] children;
        String[] c;
        if(info[2].equalsIgnoreCase("Male")) gender = 'm';
        else if(info[2].equalsIgnoreCase("Female")) gender = 'f';
        else gender = ' ';
        //else throw error
        if(!info[3].equals("")){
            birth = new int[3];
            bdate = info[3].split("-");
            for(int i = 0; i < 3; i++){
                birth[i] = Integer.valueOf(bdate[i]);
            }
        }
        if(!info[4].equals("")){
            death = new int[3];
            ddate = info[4].split("-");
            for(int i = 0; i < 3; i++){
                death[i] = Integer.valueOf(ddate[i]);
            }
        }
        if(!info[9].equals("")){
            child = new TupleList();
            children = info[9].split(",");
            for(int i = 0; i < children.length; i++){
                c = children[i].split(" ");
                child.add(c[0], c[1]);
            }
        }
        //System.out.println("ff:"+info[5]+" fl:"+info[6]+" mf:"+info[7]+" ml:"+info[8]);
        
        T.addNode(info[0], info[1], gender, birth, death, info[5], info[6], 
                  info[7], info[8], child);
        //System.out.println(T.printCurrNode());
        
        
        
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
