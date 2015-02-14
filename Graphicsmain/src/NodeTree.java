
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
        boolean tNode;
        
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
        
        Node(String first, String last, char g){
            fName = first;
            lName = last;
            age = 0;
            gender = g;
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
        public Node curr;
        public int familySize;
        
        //constructor for NodeTree
        public NodeTree(){
            root = null;
            curr = null;
            familySize = 0;
        }
        
        //Operations
        public void addNode(String first, String last){
            Node N = new Node(first,last);
            if(familySize == 0){
                root = N; 
            }
        }
        
        public void addNode(String first, String last, String ffirst, String flast, String mfirst, String mlast, char gender){
            Node N = new Node(first,last,gender);
            addtNode(N, false);
            //Node F = new Node(ffirst, flast);
            //Node M = new Node(mfirst, flast);
            //addMother(N,M);
            //addFather(N,F);
            Node temp;
            if(familySize == 0){
                root = N; 
                curr = N;
            }
            else{
                temp = findPerson(root,null,first,last);
                if(temp != null){
                    Node temp2;
                    for(int i = 0; i < temp.child.size(); i++){
                        temp2 = temp.child.get(i);
                        addChild(N,temp2);
                        if(N.gender == 'm') addFather(temp2, N);
                        else if (N.gender == 'f') addMother(temp2,N);
                    }
                //add rest of transfers
                }
            }
            
            temp = findPerson(root,null, ffirst, flast);
            if(temp == null){
                temp = new Node(ffirst, flast,'m');
                addtNode(temp, true);
                //System.out.println(printName(temp));
            }//else transefer its mother father ...
            addFather(N,temp);
            addChild(temp,N);
            temp = findPerson(root,null,mfirst,mlast);
            if(temp == null){
                temp = new Node(mfirst,mlast,'f');
                addtNode(temp, true);
                //System.out.println(printName(temp));
            }//else transfer its mother father ...
            addMother(N,temp);
            addChild(temp,N);
            familySize++;
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
            if(g != 'f' && g != 'm'){
                throw new RuntimeException("NodeTree Error: addGender(Node p, char g)"
                        + " must be given either 'f' or 'm'.");
            }
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
        
        public void addChild(Node P, Node C){
            //test for in aldready child holder there
            P.child.add(C);
            //System.out.println(printName(P) + ":" + P.child.size());
            //if(P.gender == 'm')addFather(C,P);
            //else if(P.gender == 'f') addMother(C,P);
        }
        
        public void addtNode(Node N, boolean temp){
            N.tNode = temp;
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
        
        public Node getRoot(){
            return root;
        }
        
        public Node getCurr(){
            return curr;
        }
        
        public void tMother(){
            curr = curr.mother;
        }
        
        public void tFather(){
            curr = curr.father;
        }
    
        public String printName(Node p){
          String s = p.fName + ", " + p.lName;
          return s;
        }
        
        public void printTNode(Node N){
            System.out.println(N.tNode);
        }
        
        public int numOfChild(Node N){
            return N.child.size();
        }
    
}
