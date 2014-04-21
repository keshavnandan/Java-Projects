/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myrunnable;

/**
 *
 * @author training
 */
class Crow implements Runnable{
    Thread t1, t2;
    void a1(){
        for(int i = 0; i < 10; i++)
        System.err.println("a1");
    }
    void a2(){
        for(int i = 0; i < 10; i++)
        System.out.println("a2");
    }
    @Override
    public void run(){
        if(Thread.currentThread() == t1)
             a1();
        else a2();
    }
    void initThreads(){
        t1 = new Thread(this);
        t2 = new Thread(this);
        t1.start();
        t2.start();
}

}
public class MyRunnable {

    /**
     * @param args the command line arguments
     */

public static void main(String[] args) {
        // TODO code application logic here
        new Crow().initThreads();
    }
}
