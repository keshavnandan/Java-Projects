/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import javax.ejb.Local;

/**
 *
 * @author training
 */
@Local
public interface StatefulSessionBeanLocal {

    String businessMethod(String parameter);
    
}
