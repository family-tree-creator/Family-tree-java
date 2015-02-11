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
    
    public class Tree{
        NodeTree T; 
        
        Tree(NodeTree N){
            T = N;
        }
    }
    
    public void drawTree(Graphics g, NodeTree N){
    //width and height of panel    
    int width = getWidth() - 1; 
    int height = getHeight() - 2; 
    //temporary lines for centering
    g.drawLine(width / 2, 0, width / 2, height);
    g.drawLine(0, height / 2, width, height / 2);
    
    
    //draw root box in center
    createBox(g,width/2 - 87 ,height/2 - 40);    
    
    //determines root's number of children, then adjusts variable to fit on panel
    int spacing = 0;
    if(N.root.child.size() == 1){
        spacing = width/2 - 87;
    }else if(N.root.child.size() == 2){
        spacing = width/2 - 210;
    }else if(N.root.child.size() == 3){
        spacing = width/2 - 333;
    }else if(N.root.child.size() == 4){
        spacing = width/2 - 444;
    }else if(N.root.child.size() == 5){
        spacing = width/2 - 555;
    }
    
    //Creates boxes for every child
    for(int i = 0; i < N.root.child.size(); i++){
        createBox(g,spacing + i * 240, height/2 + 160 );
    }
    }
    
    public void createBox(Graphics g, int x, int y){
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,175,80);
    }

    public void paintComponent(Graphics g){
        this.setBackground(Color.WHITE);
        super.paintComponent(g);
        
        addMouseListener(this);
       
        NodeTree N = new NodeTree(); 
        N.addNode("Will","Smith");
        N.addGender(N.root,'m');
        N.addChild(N.root,"Willow","Smith");
        N.addChild(N.root, "Jade", "Smith");
       //N.addChild(N.root, "Blank", "Smith");
       //N.addChild(N.root, "hello", "Smith");
       //N.addChild(N.root, "Tree", "Smith");
        N.addSpouse(N.root,"Jada","Pinkett");
       
        N.addGender(N.root.child.get(0),'f');
        N.addGender(N.root.child.get(0),'m');
        
        N.addChild(N.root,"Willow","Smith");
        System.out.println(N.printName(N.root));
        
      //  System.out.println(N.printName(N.findPerson(N.root,N.root.child.get(0),"Willow","Smith")));


        
        drawTree(g,N);
        
        
        
        //createBox(g,350,25);
        //createBox(g,225,250);
  
       //g.setColor(Color.BLACK);
       // g.drawLine(275,65,350,65);
       // g.drawLine(312,65,312,250);
       
       // g.setColor(Color.RED);
       // g.drawString(N.printName(N.root),160,70);
       // g.drawString(N.printName(N.root.spouse.get(0)),410,70);
       // g.drawString(N.printName(N.root.child.get(0)),285,295);
    }

    //mouse methods
    public void mouseClicked (MouseEvent me) {
        int xpos = me.getX();
        int ypos = me.getY();
        Point location = me.getLocationOnScreen();
        int clicks = me.getClickCount();
        System.out.println(location);
        System.out.println(clicks);
        if(xpos > 200 && ypos < 200){
            System.out.println("Testing");
        }
    } 
    public void mouseEntered (MouseEvent me) {} 
    public void mousePressed (MouseEvent me) {} 
    public void mouseReleased (MouseEvent me) {}  
    public void mouseExited (MouseEvent me) {}  

}
