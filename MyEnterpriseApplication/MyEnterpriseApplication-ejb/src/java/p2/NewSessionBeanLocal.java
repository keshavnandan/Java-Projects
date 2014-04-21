/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import javax.ejb.Local;

/**
 *
 * @author training
 */
@Local
public interface NewSessionBeanLocal {

    int businessMethod(int x, int y);
    
}
