/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixtracing;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.io.*;
import java.util.Scanner;


/**
 *
 * @author keshav
 */
public class Solution {

    long ncr(long n, long r){
        if(r == 0) return 1;
        if(r == 1) return n;
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(1);
        BigDecimal c = new BigDecimal(1000000007);
        for(int i = 0; i < r; i++){
            a = a.multiply(new BigDecimal(i+1)) ;
            b = b.multiply(new BigDecimal(n-i));
//            a = a.remainder(c);
//            b = b.remainder(c);
        }
        return ((a.divide(b))).longValue();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long t = 1, m = 1, n = 1, k = 1;
         Scanner cin = new Scanner(System.in);
        t = cin.nextLong();
        while(t > 0){
            t--;
            m = cin.nextLong();
            n  = cin.nextLong();
            k = Math.min(m, n);
            Solution s = new Solution();
            System.out.println(s.ncr(m+n, k));
        }
    }
}
