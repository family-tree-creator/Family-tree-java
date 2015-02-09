
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
  
    public class Node{
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
        
        //constructor w/ no parameters
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
        
        //constructor w/ parameters for Names
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
        
        //constructor w/ parameter for Names and Age
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
    }
    
        //fields for NodeTree class
        public Node root;
        public int familySize;
        
        //constructor for NodeTree
        public NodeTree(){
            root = null;
            familySize = 0;
        }
        
        //Operations
        public void addRoot(String first, String last){
            Node N = new Node(first,last);
            if(familySize == 0){
                root = N; 
            }
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
            //check if f or m
            p.gender = g;
        }
        
        public void addMother(Node c, Node m){
            c.mother = m;
        }
        
        public void addFather(Node c, Node f){
            c.father = f;
        }
        
        public void addSpouse(Node C, String first, String last){
            Node S = new Node(first,last);
            
            //check if spouse already spouse
            for(int i = 0; i < C.spouse.size(); i++){
                if (first == C.spouse.get(i).fName){
                    return;
                }    
            }
            
            C.spouse.add(S);
            familySize++;
        }
        
        public void addChild(Node P, String first, String last){
            Node C = new Node(first,last);
            
            //check if child already child of parent
            for(int i = 0; i < P.child.size(); i++){
                if (first == P.child.get(i).fName){
                    return;
                }    
            }
            
            P.child.add(C);
            familySize++;
            
            //if parent has gender, associate as father or mother
            if (P.gender == 'm'){
                addFather(C,P);
            }else if (P.gender == 'f'){
                addMother(C,P);
            }
        }
        
        public Node findPerson(Node R, Node C, String first, String last){
          if(R == null) return null;
          
          if(R.fName.equals(first) && R.lName.equals(last)){
            return R;
          }
          Node temp = findPerson(R.father, R, first, last);
          if(temp != null){
            return temp;
          }
          temp = findPerson(R.mother, R, first, last);
          if(temp != null){
            return temp;
          }
          for(int i = 0; i < R.child.size(); i++){
            if(R.child.get(i) != C){
                temp = findPerson(R.child.get(i), R, first, last);
                if(temp != null){
                    return temp;
                }
            }
          }
          return null;
        }
    
        public String printName(Node p){
          String s = p.fName + ", " + p.lName;
          return s;
        }
    
}
