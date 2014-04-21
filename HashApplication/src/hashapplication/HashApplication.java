/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashapplication;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
/**
 *
 * @author training
 */
public class HashApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap OracleMap = new HashMap();
        
        for(int i = 1; i <= 2; i++){
            HashMap LocMap = new HashMap();
            for(int j = 1; j <= 2; j++)
                LocMap.put(10*i+j, 10*j);
            OracleMap.put(i, LocMap);
        }
        Set s = OracleMap.keySet();
        Iterator it = s.iterator();
        while(it.hasNext()){
            HashMap hm = (HashMap)OracleMap.get(it.next());
            Set st = hm.keySet();
            Iterator itr = st.iterator();
            while(itr.hasNext()){
                int x = (int)itr.next();
                System.out.println(x+" "+hm.get(x));
            }
        }
    }
}
