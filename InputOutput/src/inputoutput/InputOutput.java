/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inputoutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author training
 */
public class InputOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int c = 0;
        try{
            FileInputStream  fis = new FileInputStream("./src/inputoutput/input.txt");
            FileOutputStream fos = new FileOutputStream("src/inputoutput/output.txt");
            while((c = fis.read()) != -1){
                System.out.print((char)c);
                fos.write(c);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
