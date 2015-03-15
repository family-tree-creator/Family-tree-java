
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ImportFile extends JFrame {
    boolean hasFile = false;
    File sf;
    public ImportFile(){
        super("Choose a family tree file");
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contain = getContentPane();
        contain.setLayout(new BoxLayout(contain, BoxLayout.PAGE_AXIS));
        JButton open = new JButton("Open");
        JLabel instruction1 = new JLabel(
                           " Select a file to open in the family tree program.");
        JLabel instruction2 = new JLabel(" To navigate in the tree click the parents or children ");
        JLabel instruction3 = new JLabel(" of the current person.");
        JLabel instruction4 = new JLabel(" Click on the current person to view their infomation.");
        open.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                JFileChooser choose = new JFileChooser();
                int state = choose.showOpenDialog(ImportFile.this);
                if(state == JFileChooser.APPROVE_OPTION){
                    sf = choose.getSelectedFile();
                    hasFile = true;
                    dispose();
                    if (sf == null){
                        System.err.println("File not opened");
                    }
                }
            }
        });
        contain.add(open);
        contain.add(instruction1);
        contain.add(instruction2);
        contain.add(instruction3);
        contain.add(instruction4);
    }
    
    public boolean checkForFile(){
        return hasFile;
    }
    
    public NodeTree Import(){
        NodeTree N = new NodeTree();
        FileReader in = null;
        try{
            in = new FileReader(sf);
            BufferedReader br = new BufferedReader(in);
            String check;
            while((check = br.readLine()) != null){
                MakeNode(N, check);
            }
            in.close();
        }catch(IOException failRead) { //add catch for unable to open file
            System.err.println(failRead.getMessage());
        }
        return N;
    }
    
    public static void MakeNode(NodeTree T, String input){
        String[] info = input.split(";");
        //check for right size and has first and last name
        if(info.length < 10){
            System.err.println(info.length);
            System.err.println("Not enough info to make a node");
            return;
        }
        char gender = ' ';
        int[] birth = null;
        int[] death = null;
        TupleList child = null;
        String[] bdate;
        String[] ddate;
        String[] children;
        String[] c;
        if(info[2].equalsIgnoreCase("Male")) gender = 'm';
        else if(info[2].equalsIgnoreCase("Female")) gender = 'f';
        else gender = ' ';
        //else throw error
        if(!info[3].equals("")){
            birth = new int[3];
            bdate = info[3].split("-");
            for(int i = 0; i < 3; i++){
                birth[i] = Integer.valueOf(bdate[i]);
            }
        }
        if(!info[4].equals("")){
            death = new int[3];
            ddate = info[4].split("-");
            for(int i = 0; i < 3; i++){
                death[i] = Integer.valueOf(ddate[i]);
            }
        }
        if(!info[9].equals("")){
            child = new TupleList();
            children = info[9].split(",");
            for(int i = 0; i < children.length; i++){
                c = children[i].split(" ");
                child.add(c[0], c[1]);
            }
        }
        
        T.addNode(info[0], info[1], gender, birth, death, info[5], info[6], 
                  info[7], info[8], child);        
    }
}