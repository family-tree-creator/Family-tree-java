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
public class Graphicsrun extends JPanel implements MouseListener{

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
        Rectangle box;
        
        Node(String first, String last, int x, int y){
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
            box = new Rectangle(x,y,175,80);
        }
    }
    
    public void addChild(Node p, Node c){
       p.child.add(c);
    }
    
    public void createBox(Graphics g, Node p, int x, int y){
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,175,80);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        addMouseListener(this);
        
        g.setColor(Color.YELLOW);
        Node A = new Node("Will","Smith",100,25);
        Node B = new Node("Jada","Pinkett",350,25);
        Node C = new Node("Willow","Smith",225,250);  
        
        //g.fillRect(A.box.getX(),A.box.getY(),A.box.getWidth(),A.box.getHeight());
        
        addChild(A,C);
        System.out.println((A.child.get(0)).fName);
        
        //createBox(g,A,100,25);
        //createBox(g,B,350,25);
        //createBox(g,C,225,250);
  
        g.setColor(Color.BLACK);
        g.drawLine(275,65,350,65);
        g.drawLine(312,65,312,250);
       
        g.setColor(Color.RED);
        g.drawString(A.fName + " " + A.lName ,160,70);
        g.drawString(B.fName + " " + B.lName,410,70);
        g.drawString(C.fName + " " + C.lName, 285, 295);
    }

    //mouse methods
    public void mouseClicked (MouseEvent me) {
        int xpos = me.getX();
        int ypos = me.getY();
        if(xpos > 200 && ypos < 200){
            System.out.println("Testing");
        }
    } 
    public void mouseEntered (MouseEvent me) {} 
    public void mousePressed (MouseEvent me) {} 
    public void mouseReleased (MouseEvent me) {}  
    public void mouseExited (MouseEvent me) {}  

}
