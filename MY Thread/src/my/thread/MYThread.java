/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.thread;

/**
 *
 * @author training
 */

class MT extends Thread{
    MT(String s){
        super(s);
    }
    void a1(){
        for(int i = 0; i < 20; i++)
            System.out.println("a1");
            try{
                sleep(100);
            }
            catch(InterruptedException e){
                e.printStackTrace();
        }
    }
    void a2(){
        for(int i = 0; i < 20; i++)
            System.out.println("a2");
            try{
                sleep(100);
            }
            catch(InterruptedException e){
                e.printStackTrace();
        }
    }

    @Override
        public void run(){
        if(getName().equals("A1")) a1();
        else a2();
    }

}

public class MYThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MT t1 = new MT("A1");
        MT t2 = new MT("A2");
        try{
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
