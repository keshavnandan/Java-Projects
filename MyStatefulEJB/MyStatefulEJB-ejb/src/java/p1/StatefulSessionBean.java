/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

/**
 *
 * @author training
 */
@Stateful
public class StatefulSessionBean implements StatefulSessionBeanLocal {
    
    int x = 0;
    String s = "";
    @Override
    public String businessMethod(String st) {
        s += "<h2>"+Integer.toString(++x)+". done</h2><br>";
        return s;
    }
    
    @PostConstruct
    public void create(){
        System.out.println("Output: Created");
    }
    @PrePassivate
    public void activate(){
        System.out.println("Output: Activate");
    }
    @PostActivate
    public void deactivate(){
        System.out.println("Output: Deactivate");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Output: PreDistroy");
    }
}
