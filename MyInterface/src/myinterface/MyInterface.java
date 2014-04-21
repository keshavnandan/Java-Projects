/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterface;

/**
 *
 * @author training
 */
abstract class Vehicle{
    int numSeats;
    int numWheels;
}
interface Info{
    void seats();
    void wheels();
}

class Car extends Vehicle implements Info{
    @Override
    public void seats(){
        numSeats = 4;
        System.out.println("I have "+numSeats+" seats.");
    }
    @Override
    public void wheels(){
        numWheels = 4;
        System.out.println("I have "+numWheels+" wheels");
    }
}

class Bike extends Vehicle implements Info{
    @Override
    public void seats(){
        numSeats = 2;
        System.out.println("I have "+numSeats+" seats.");
    }
    @Override
    public void wheels(){
        numWheels = 2;
        System.out.println("I have "+numWheels+" wheels");
    }
    
}
public class MyInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Info ref = null;
        if (args[0].equals("B")) ref  = new Bike();
        else ref = new Car();
        ref.seats();
        ref.wheels();
    }
    
}

