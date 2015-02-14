/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package graphicsrun;
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
    
    //draw root box in center
    createBox(g,width/2 - 87 ,height/2 - 40); 
    createText(g,N.printName(N.curr),width/2 - 40,height/2); //need to center text
    
    if(N.curr.father!=null || N.curr.mother != null){
        createLine(g,width/2, height/2-200, width/2, height/2-40);
    }
    
    //draws boxes for parents
    if(N.curr.father != null){
        createBox(g,width/2 - 210,height/2 - 240);
        createText(g,N.printName(N.curr.father),width/2 - 163, height/2-240);
        createLine(g,width/2 - 35, height/2-200, width/2, height/2-200);        
     }
    if(N.curr.mother != null){
        createBox(g,width/2 + 35,height/2 - 240); 
        createLine(g,width/2, height/2-200, width/2 + 35, height/2-200);
        createText(g,N.printName(N.curr.mother),width/2 + 35, height/2 - 240);
   }
         
    //determines root's number of children, then adjusts spacing for boxes
    //and draws connecting lines
    int spacing = 0;
    int endline = 0;
        
    if(N.curr.child.size() == 1){
        spacing = width/2 - 87;
    }else if(N.curr.child.size() == 2){
        spacing = width/2 - 205;
        endline = spacing + 240 + 87; 
    }else if(N.curr.child.size() == 3){
        spacing = width/2 - 333;
        endline = spacing + (240*2) + 87;
    }else if(N.curr.child.size() == 4){
        spacing = width/2 - 444;
        endline = spacing + (240*3) + 87;
    }else if(N.curr.child.size() == 5){
        spacing = width/2 - 570;
        endline = spacing + (240*4) + 87;
    }
    
    //vertical line connecting children
    if(N.curr.child.size()!=0){
        createLine(g,width/2,height/2+40,width/2,height/2+100);
        //horizontal line connecting children
         if(N.curr.child.size()>1){
            createLine(g,spacing + 87,height/2+100,endline,height/2+100);
        }
    }

    //Creates boxes for every child
    for(int i = 0; i < N.curr.child.size(); i++){
        int k = spacing + i * 240;
        createBox(g,k, height/2 + 160 );
        createText(g,N.printName(N.curr.child.get(i)),k + 40 , height/2 + 200);
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
    
    public void paintComponent(final Graphics g){
        this.setBackground(Color.WHITE);
        super.paintComponent(g);
       
        final NodeTree N = new NodeTree(); 
        
        N.addNode("Will","Smith",'m',"Bob","Smith","Wilma","Smith");
        N.addGender(N.curr,'m');
        N.addChild(N.curr,"Willow","Smith");
        N.addChild(N.curr, "Jade", "Smith");
        N.addChild(N.curr, "Blank", "Smith");
       // N.addChild(N.curr, "hello", "Smith");
       // N.addChild(N.curr, "Tree", "Smith");
        N.addSpouse(N.curr,"Jada","Pinkett");
       
        N.addGender(N.curr.child.get(0),'f');
        N.addGender(N.curr.child.get(0),'m');
        
   
        
        System.out.println("The current node is " + N.printName(N.curr));
        N.tChild("Willow","Smith");

        addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                System.out.println("click");
                N.tChild("Willow","Smith");
                g.setColor(Color.WHITE);
                g.fillRect(0,0,getWidth(),getHeight());
                repaint(); 
            } 
        });
        
        drawTree(g,N);        
        }

        
        


    //mouse methods that don't do anything, but are needed to override abstract methods
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
