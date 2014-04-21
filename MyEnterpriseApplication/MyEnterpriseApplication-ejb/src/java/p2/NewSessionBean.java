/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import javax.ejb.Stateless;

/**
 *
 * @author training
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @Override
    public int businessMethod(int x, int y) {
        return x+y;
    }    
}
