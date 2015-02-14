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
    //g.drawLine(width / 2, 0, width / 2, height);
    //g.drawLine(0, height / 2, width, height / 2);
    
    //draw root box in center
    createBox(g,width/2 - 87 ,height/2 - 40); 
    createText(g,N.printName(N.root),width/2 - 40,height/2); //need to center text
    
    if(N.root.father!=null || N.root.mother != null){
        createLine(g,width/2, height/2-200, width/2, height/2-40);
    }
    
    //draws boxes for parents
    if(N.root.father != null){
        createBox(g,width/2 - 210,height/2 - 240);
        createLine(g,width/2 - 35, height/2-200, width/2, height/2-200);
        createText(g,N.printName(N.root.father),width/2 - 210, height/2-240);
     }
    if(N.root.mother != null){
        createBox(g,width/2 + 35,height/2 - 240); 
        createLine(g,width/2, height/2-200, width/2 + 35, height/2-200);
        createText(g,N.printName(N.root.mother),width/2 + 35, height/2 - 240);
   }
         
    //determines root's number of children, then adjusts spacing for boxes
    //and draws connecting lines
    int spacing = 0;
    int endline = 0;
        
    if(N.root.child.size() == 1){
        spacing = width/2 - 87;
    }else if(N.root.child.size() == 2){
        spacing = width/2 - 205;
        endline = spacing + 240 + 87; 
    }else if(N.root.child.size() == 3){
        spacing = width/2 - 333;
        endline = spacing + (240*2) + 87;
    }else if(N.root.child.size() == 4){
        spacing = width/2 - 444;
        endline = spacing + (240*3) + 87;
    }else if(N.root.child.size() == 5){
        spacing = width/2 - 570;
        endline = spacing + (240*4) + 87;
    }
    
    //vertical line connecting children
    createLine(g,width/2,height/2+40,width/2,height/2+100);
    //horizontal line connecting children
    if(N.root.child.size()>1){
        createLine(g,spacing + 87,height/2+100,endline,height/2+100);
    }

    //Creates boxes for every child
    for(int i = 0; i < N.root.child.size(); i++){
        int k = spacing + i * 240;
        createBox(g,k, height/2 + 160 );
        createText(g,N.printName(N.root.child.get(i)),k + 40 , height/2 + 200);
        createLine(g,k + 87, height/2 + 160, k + 87, height/2 + 100);
    }
    }
    
    public void createBox(Graphics g, int x, int y){
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,175,80);
    }
    
    public void createLine(Graphics g, int x, int y, int x2, int y2){
        g.setColor(Color.BLACK);
        g.drawLine(x,y,x2,y2);
    }

    public void createText(Graphics g, String s, int x, int y){
        g.setColor(Color.RED);
        g.drawString(s,x,y);
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
        N.addChild(N.root, "Blank", "Smith");
       // N.addChild(N.root, "hello", "Smith");
       // N.addChild(N.root, "Tree", "Smith");
        N.addSpouse(N.root,"Jada","Pinkett");
       
        N.addGender(N.root.child.get(0),'f');
        N.addGender(N.root.child.get(0),'m');
        
        N.addChild(N.root,"Willow","Smith");
     
      // System.out.println(N.printName(N.root));
      // System.out.println(N.printName(N.findPerson(N.root,N.root.child.get(0),"Willow","Smith")));

        drawTree(g,N);
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
