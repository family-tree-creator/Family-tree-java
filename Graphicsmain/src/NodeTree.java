
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Crazypinata
 */
public class NodeTree {
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
        
        Node(){
            fName = "";
            lName = "";
            age = 0;
            gender = ' ';
            birth = 0;
            death = 0; 
            mother = null;
            father = null;
            spouse = new ArrayList();
            child = new ArrayList();
        }
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
        Node(String first, String last,int a){
            fName = first;
            lName = last;
            age = a;
            gender = ' ';
            birth = 0;
            death = 0; 
            mother = null;
            father = null;
            spouse = new ArrayList();
            child = new ArrayList();
        }
        
        public void addFname(Node p, String first){
            //check != null
            p.fName = first;
        }
        
        public void addLname(Node p, String last){
            //check != null
            p.lName = last;
        }
        
        public void addAge(Node p, int a){
            //check > 0
            p.age = a;
        }
        
        public void addGender(Node p, char g){
            //check if g or m
            p.gender = g;
        }
        
        public void addMother(Node c, Node m){
            c.mother = m;
        }
        
        public void addFather(Node c, Node f){
            c.father = f;
        }
        
        public void addSpouse(Node c, Node s){
            c.spouse.add(s);
        }
        
        public void addChild(Node p, Node c){
            p.child.add(c);
        }
    }
    
    
    
}
