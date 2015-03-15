
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class Graphicsmain {
    public static void main(String[] args){
        ImportFile imf = new ImportFile();
        imf.setVisible(true);
        while(!imf.checkForFile()){
            System.out.printf("");
        }
        JFrame f = new JFrame("Family Tree");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graphicsrun gr = new Graphicsrun(imf.Import());
        f.add(gr);
        f.setSize(1200,900);
        f.setVisible(true);
    }
}