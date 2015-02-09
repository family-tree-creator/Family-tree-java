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
    
    public void createBox(Graphics g, int x, int y){
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,175,80);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        addMouseListener(this);
       
        NodeTree N = new NodeTree(); 
        N.addRoot("Will","Smith");
        N.addGender(N.root,'m');
        N.addChild(N.root,"Willow","Smith");
        N.addGender(N.root.child.get(0),'f');
        System.out.println(N.root.child.get(0).father.fName);
        
      //Node A = new Node("Will","Smith",100,25);
      //  Node B = new Node("Jada","Pinkett",350,25);
      //  Node C = new Node("Willow","Smith",225,250);  
        
      //  addChild(A,C);
      //  System.out.println((A.child.get(0)).fName);
        
        createBox(g,100,25);
        createBox(g,350,25);
        createBox(g,225,250);
  
        g.setColor(Color.BLACK);
        g.drawLine(275,65,350,65);
        g.drawLine(312,65,312,250);
       
        g.setColor(Color.RED);
        g.drawString(N.printName(N.root),160,70);
        g.drawString(N.printName(N.root.child.get(0)),285,295);
      //  g.drawString(A.fName + " " + A.lName ,160,70);
      //  g.drawString(B.fName + " " + B.lName,410,70);
      //  g.drawString(C.fName + " " + C.lName, 285, 295);
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
