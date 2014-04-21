/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

/**
 *
 * @author training
 */
class MyFactory{
    int item = 0;
    synchronized public void produce(){
        item++;
        System.out.println("p"+item);
        try{
            notify();
            wait();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public void consume(){
        System.out.println("c"+item);
        try{
            notify();
            wait();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ProducerThread extends Thread{
    MyFactory mf;
    ProducerThread(MyFactory mf){
        this.mf = mf;
    }
    @Override
    public void run(){
        for(int i = 0; i < 10; i++)
        mf.produce();
    }
}

class ConsumerThread extends Thread{
    MyFactory mf;
    ConsumerThread(MyFactory mf) {
        this.mf = mf;
    }
    @Override
    public void run(){
        for(int i = 0; i < 10; i++)
        mf.consume();
    }    
}
public class ProducerConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyFactory MF = new MyFactory();
        ProducerThread PT = new ProducerThread(MF);
        ConsumerThread CT = new ConsumerThread(MF);
        PT.start();
        CT.start();
        try{
            PT.join();
            CT.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
