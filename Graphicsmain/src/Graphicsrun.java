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
    //fields for Graphicsrun
    NodeTree N;
    
    //Graphicsrun constructor
    public Graphicsrun(NodeTree T){
        N = T; 
    }

    //tree
    //NodeTree N = new NodeTree();
    
    //booleans for boxes clicked
    boolean B = true; 
    boolean fClick = false;
    boolean mClick = false;
    boolean cClick = false;
    boolean[] kClick = new boolean[5]; 

    //coordinates for boxes
    int fx;
    int fy;
    int mx;
    int my;
    int cx;
    int cy;
    int[] kx = new int[5];
    int ky;
    
    public void drawTree(Graphics g){
    //width and height of panel    
    int width = getWidth(); 
    int height = getHeight();
    
    //reset coordinates
    fx = 0;
    fy = 0;
    mx = 0;
    my = 0;
    cx = width/2 - 87;
    cy = height/2 - 40;
    for(int i = 0; i<kx.length;i++){
        kx[i]=0;
    }
    ky = 0;
    
    //draw root box in center
    createBox(g,cx,cy); 
    createText(g,N.printCurrName(),width/2 - 40,height/2); 
    
    if(N.curr.father!=null || N.curr.mother != null){
        createLine(g,width/2, height/2-200, width/2, height/2-40);
    }
    
    //draws boxes for parents
    if(N.curr.father != null){
        fx = width/2 - 210;
        fy = height/2 - 240;
        createBox(g,fx,fy);
        createText(g,N.printName(N.curr.father),width/2 - 163, height/2-200);
        createLine(g,width/2 - 35, height/2-200, width/2, height/2-200);
     }
    if(N.curr.mother != null){
        mx = width/2 + 35;
        my = height/2 - 240;
        createBox(g,mx,my); 
        createText(g,N.printName(N.curr.mother),width/2 + 82, height/2 - 200);
        createLine(g,width/2, height/2-200, width/2 + 35, height/2-200);
   }
         
    //determines root's number of children, then adjusts spacing for boxes
    //and draws connecting lines
    int spacing = 0;
    int endline = 0;
        
    //vertical line connecting children
    if(N.curr.child.size()> 0){
    createLine(g,width/2,height/2+40,width/2,height/2+100);
    ky = height/2 + 160;    
    }
 
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
    
    //horizontal line connecting children
    if(N.curr.child.size()>1){
        createLine(g,spacing + 87,height/2+100,endline,height/2+100);
    }
    
    //Creates boxes for every child
    for(int i = 0; i < N.curr.child.size(); i++){
        kx[i] = spacing + i * 240;
        createBox(g,kx[i],ky);
        createText(g,N.printName(N.curr.child.get(i)),kx[i] + 40 , height/2 + 200);
        createLine(g,kx[i] + 87, ky, kx[i] + 87,ky-60);
    }
    }
    
    
    //draws current individual 
    public void drawIndTree(Graphics g){
        //width and height of panel    
        int width = getWidth(); 
        int height = getHeight();   
    
        cx = width/2 - 87;
        cy = height/2 - 40;
        
        //draw root box in center
        createBox(g,cx,cy); 
        createText(g,N.printCurrName(),width/2 - 40,height/2); 
        
        //prints info related to Node
        createText(g,"Birth: " + N.printCurrBirth(),cx,cy + 100); 
        createText(g,"Death: " + N.printCurrDeath(),cx,cy + 120);
        createText(g,"Age: " + N.printCurrAge(),cx,cy + 140);
        createText(g,"Gender: " + N.curr.gender,cx, cy + 160);
    }
    
    
    //drawing tools
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
        
        if(B){
        addMouseListener(this); 
        }
        
        //cases for changing tree
        for(int i = 0; i<kClick.length;i++){
            if(kClick[i]){
            N.tChild(i);
            kClick[i]=false;
            }
        }
         
        if(fClick){
            N.tFather();
            fClick = false;
        }else if(mClick){
            N.tMother();
            mClick = false;
        }
       
       
       //redraws updated tree
        g.setColor(Color.WHITE); 
        this.repaint(0,0,getWidth(),getHeight());    
        
        if(cClick){
            drawIndTree(g);
        }else{
        drawTree(g);
        }
    }

    //mouse methods 
    public void mouseClicked (MouseEvent me) {
        //only works for left mouse click
        switch(me.getModifiers()){ 
            case InputEvent.BUTTON1_MASK: {
        
                int xpos = me.getX();
                int ypos = me.getY();
                B = !B; 
       
                if(xpos > fx && xpos < fx+175 && ypos > fy && ypos < fy+80){
                    fClick = true;
                }
        
                if(xpos > mx && xpos < mx+175 && ypos > my && ypos < my+80){
                    mClick = true;
                }
        
                if(xpos > cx && xpos < cx+175 && ypos > cy && ypos < cy+80){    
                    System.out.println("click");
                    cClick = !cClick;        
                }

                for(int i = 0; i < kClick.length; i++){
                    if(xpos > kx[i] && xpos < kx[i]+175 && ypos > ky && ypos < ky+80){
                        kClick[i] = true;
                    }
                }
            }
        }
    }
    public void mouseEntered (MouseEvent me) {} 
    public void mousePressed (MouseEvent me) {} 
    public void mouseReleased (MouseEvent me) {}  
    public void mouseExited (MouseEvent me) {}  

}