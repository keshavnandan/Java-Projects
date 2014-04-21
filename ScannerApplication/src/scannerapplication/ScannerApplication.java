/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerapplication;

import java.util.Scanner;

/**
 *
 * @author training
 */
public class ScannerApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int x = sc.nextInt();
        System.out.println(s+x);
    }
}
