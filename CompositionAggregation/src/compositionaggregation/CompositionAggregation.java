/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compositionaggregation;

/**
 *
 * @author training
 */
class Display{}
class Processor{}
class Memory{}

class Laptop{
    Display d = new Display();
    Processor p = new Processor();
    Memory m = new Memory();
}

class Desktop{
    Display d = new Display();
    Processor p = null;
    Memory m = null;
    void setProcessor(Processor p){
        this.p = p;
    }
    void setMemory(Memory m){
        this.m = m;
    }
}

public class CompositionAggregation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Laptop  L = new Laptop();
        Desktop D = new Desktop();
        Memory m  = new Memory();
        Processor p = new Processor();
        D.setMemory(m);
        D.setProcessor(p);
    }
}
