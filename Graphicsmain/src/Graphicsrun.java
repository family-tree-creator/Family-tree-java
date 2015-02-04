/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package graphicsrun;

//does this work????
//WORK?????
//work
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author daniposi
 */
public class Graphicsrun extends JPanel {

    private class Node{
        String fName;
        String lName;
        int age;
        char gender;
        int birth; 
        int death;
        Node mother;
        Node father;
        List<Node> spouse;
        List<Node> child;
        
        Node(String first, String last){
            fName = first;
            lName = last;
            age = 0;
            gender = ' ';
            birth = 0;
            death = 0; 
            mother = null;
            father = null;
            spouse = new ArrayList();
            child = new ArrayList();
        }
    }
    
    public void addChild(Node p, Node c){
       p.child.add(c);
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        Node A = new Node("Will","Smith");
        Node B = new Node("Jada","Pinkett");
        Node C = new Node("Willow","Smith");  
               
        addChild(A,C);
        System.out.println((A.child.get(0)).fName);

        g.setColor(Color.YELLOW);
        
        g.fillRect(100,25,175,80);
        g.fillRect(350,25,175,80);
        g.fillRect(225,250,175,80);
 
        g.setColor(Color.BLACK);
        g.drawLine(275,65,350,65);
        g.drawLine(312,65,312,250);
       
        g.setColor(Color.RED);
        g.drawString(A.fName + " " + A.lName ,160,70);
        g.drawString(B.fName + " " + B.lName,410,70);
        g.drawString(C.fName + " " + C.lName, 285, 295);
    }
    
}
