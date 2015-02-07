/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Crazypinata
 */
import java.io.*;

public class ImportFile {
    public void Import(String s){
        FileReader in = null;
        try{
            in = new FileReader(s);
            BufferedReader br = new BufferedReader(in);
            String check;
            while((check = br.readLine()) != null){
                System.out.println(check);
            }
            in.close();
        }catch(IOException failRead) { //add catch for unable to open file
            System.err.println(failRead.getMessage());
        }
    }
}
