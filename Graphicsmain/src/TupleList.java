
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
public class TupleList {
    public class Tuple{ 
        public final String first; 
        public final String second; 
        public Tuple(String f, String s) { 
            this.first = f; 
            this.second = s; 
        }
        public String getFirst(){
            return this.first;
        }
        public String getSecond(){
            return this.second;
        }
    }
    
    List<Tuple> tList;
    
    TupleList(){
        tList = new ArrayList();
    }
    
    public int size(){
        return tList.size();
    }
    
    public String getFirst(int i){
        return tList.get(i).getFirst();
    }
    
    public String getSecond(int i){
        return tList.get(i).getSecond();
    }
    
    public void add(String f, String s){
        tList.add(new Tuple(f,s));
    }
    
    public void remove(int index){
        tList.remove(index);
    }
    
}
