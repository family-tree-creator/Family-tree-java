
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
        int[] birth; 
        int[] death;
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
            birth = null;
            death = null; 
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
            birth = null;
            death = null; 
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
            birth = null;
            death = null; 
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
            birth = null;
            death = null; 
            mother = null;
            father = null;
            spouse = new ArrayList();
            child = new ArrayList();
        }
        
        Node(String first, String last, char g, int[] b, int[] d){
            fName = first;
            lName = last;
            age = calculateAge(b,d);
            gender = g;
            birth = b;
            death = d; 
            mother = null;
            father = null;
            spouse = new ArrayList();
            child = new ArrayList();
        }
        
        public int calculateAge(int[] b, int[] d){
            int deathyear=d[2];
            if(d[2] == 0){
                deathyear=2015;
            }
            int age = deathyear-b[2];
            if(b[1] > d[1]) age--;
            else if(b[1] == d[1] && b[0] > d[0]) age--;
            return age;
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
        //creats a simple node not attached to anything
        public void addNode(String first, String last){
            Node N = new Node(first,last);
            if(familySize == 0){
                root = N; 
                curr = N;
            }
        }
        
        //creates a simple node and a tree but not spouses
        public void addNode(String first, String last, char gender, String ffirst, String flast, String mfirst, String mlast){
            Node N = new Node(first,last,gender);
            addtNode(N, false);
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
                    if(temp.father != null)
                        addFather(N, temp.father);
                    if(temp.mother != null)
                        addMother(N, temp.mother);
                //add rest of transfers
                }
            }
            
            addFather(N, ffirst, flast);
            addMother(N, mfirst, mlast);
            familySize++;
        }
        
        //creates a full node and a tree (spouses to be added)
        public void addNode(String first, String last, char gender,  int[] birth, int[] death, String ffirst, String flast, String mfirst, String mlast){
            Node N = new Node(first,last, gender, birth, death);
            addtNode(N, false);
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
                    if(temp.father != null)
                        addFather(N, temp.father);
                    if(temp.mother != null)
                        addMother(N, temp.mother);
                    //addSpouse
                }
            }
            addFather(N, ffirst, flast);
            addMother(N, mfirst, mlast);
            //addSpouse
            familySize++;
        }
        
        public void addNode(String first, String last, char gender,  int[] birth, int[] death, String ffirst, String flast, String mfirst, String mlast, TupleList childs){
            Node N = new Node(first,last, gender, birth, death);
            addtNode(N, false);
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
                    if(temp.father != null)
                        addFather(N, temp.father);
                    if(temp.mother != null)
                        addMother(N, temp.mother);
                    //addSpouse
                }
            }
            addFather(N, ffirst, flast);
            addMother(N, mfirst, mlast);
            //System.out.println("child stuff");
            addChild(N, childs);
            //System.out.println("child stuff end");
            //addSpouse
            
            
            
            familySize++;
        }
        
        //public Node makeNode(String first, String last, char gender, String ffirst, String flast, String mfirst, String mlast){
          
        
        //}
        
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
        
        //add m to c.mother and replaces m's temp child with real
        public void addMother(Node c, Node m){
            c.mother = m;
            Node temp;
            for(int i = 0; i < m.child.size(); i++){
                temp = m.child.get(i);
                if(c.fName.equals(temp.fName) && c.lName.equals(temp.lName)){
                    m.child.set(i, c);
                    return;
                }
            }
            addChild(m,c);
            //System.out.println("addMother: child not found.");
        }
        
        //creates a temp mother and connects to child
        public void addMother(Node c, String mfirst, String mlast){
            Node temp = findPerson(root,null,mfirst,mlast);
            if(temp == null){
                temp = new Node(mfirst,mlast,'f');
                addtNode(temp, true);
                //System.out.println(printName(temp));
            }//else transfer its mother father ...
            addMother(c,temp);
            //addChild(temp,c);
        }
        
        //add f to c.father and replaces f's temp child with real
        public void addFather(Node c, Node f){
            c.father = f;
            Node temp;
            for(int i = 0; i < f.child.size(); i++){
                temp = f.child.get(i);
                if(c.fName.equals(temp.fName) && c.lName.equals(temp.lName)){
                    f.child.set(i, c);
                    return;
                }
            }
            addChild(f,c);
            //System.out.println("addFather: child not found.");
        }
        
        //creates a temp father and connects to child
        public void addFather(Node c, String ffirst, String flast){
            Node temp = findPerson(root,null, ffirst, flast);
            if(temp == null){
                temp = new Node(ffirst, flast,'m');
                addtNode(temp, true);
                //System.out.println(printName(temp));
            }//else transefer its mother father ...
            addFather(c,temp);
            //addChild(temp,c);
        }
        
        //to be worked on
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
        
        //creates temp child node and connects to parent
        public void addChild(Node P, String first, String last){
            Node C = new Node(first,last);
            
            //check if child already child of parent
            for(int i = 0; i < P.child.size(); i++){
                if (first.equals(P.child.get(i).fName) && last.equals(P.child.get(i).lName)){
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
        
        //add child to parent's child list
        public void addChild(Node P, Node C){
            //test for in aldready child holder there
            P.child.add(C);
            //System.out.println(printName(P) + ":" + P.child.size());
            //if(P.gender == 'm')addFather(C,P);
            //else if(P.gender == 'f') addMother(C,P);
        }
        
        public void addChild(Node P, TupleList check){
            Node temp;
            for(int i = 0; i < P.child.size(); i++){
                temp = P.child.get(i);
                System.out.println(Integer.toString(check.size()));
                for(int j = 0; i < check.size(); j++){
                    if(temp.fName.equals(check.getFirst(j)) && temp.lName.equals(check.getSecond(j))){
                        check.remove(j);
                        break;
                    }
                }
            }
            for(int k = 0; k < check.size(); k++){
                P.child.add(new Node(check.getFirst(k), check.getSecond(k)));
            }
        }
        
        //adds the tag of temp node
        public void addtNode(Node N, boolean temp){
            N.tNode = temp;
        }
        
        //finds a node in the tree with same first and last name
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
        
        //make curr equal to curr's mother
        public void tMother(){
            curr = curr.mother;
        }
        
        //make curr equal to curr's father
        public void tFather(){
            curr = curr.father;
        }
        
        //make curr equal to curr's child with same first and last name
        public void tChild(String fname, String lname){
            Node temp;
            for(int i = 0; i < curr.child.size(); i++){
                temp = curr.child.get(i);
                if(temp.fName.equals(fname) && temp.lName.equals(lname)){
                    curr = temp;
                    return;
                }
            }
            //print an error message.
            System.out.println("nope");
        }
        
        public void tChild(int index){
            if(index < curr.child.size()){
                curr = curr.child.get(index);
                return;
            }
            System.out.println("nope");
        }
    
        //returns a string with node's name
        public String printName(Node p){
          String s = p.fName + " " + p.lName;
          return s;
        }
        
        //returns a string with curr's name
        public String printCurrName(){
            return curr.fName + " " + curr.lName;
        }
        
        public String printCurrAge(){
            if(curr.age > 0){
                return Integer.toString(curr.age);
            }else{
                return "";
            }
        }
        
        //returns a string with curr's birth and death date
        public String printCurrBirth(){
            String bd = "";
            
            if(curr.birth != null){
                for(int i = 0; i < 3; i++){
                    bd += Integer.toString(curr.birth[i]);
                    if(i < 2){
                        bd+= "/";
                    }
                }
            }
            return bd;
        }
        
        public String printCurrDeath(){
            String bd = "";
            
            if(curr.death!= null && curr.death[0] != 0){
                for(int i = 0; i < 3; i++){
                    bd += Integer.toString(curr.death[i]);
                    if(i < 2){
                        bd+= "/";
                    }
                }
            }
            return bd;
        }
        
        //returns string with curr's full info
        public String printCurrNode(){
            //String node = "";
            return printCurrName() + ", age: " + printCurrAge() + ", birth: " + printCurrBirth() + ", death: " + printCurrDeath();
        }
        
        //prints the temp flag
        public void printTNode(Node N){
            System.out.println(N.tNode);
        }
        
        //returns number of childrend a node has
        public int numOfChild(Node N){
            return N.child.size();
        }
        
        public int currNumC(){
            return curr.child.size();
        }
        
        /*public List<Node> createChildren(){
            List<Node> child = new ArrayList();
            Node temp;
            temp = addNode("H", "Hz", 'm', "A", "Az", "I", "Iz");
            
            return child;
        }*/
    
}
