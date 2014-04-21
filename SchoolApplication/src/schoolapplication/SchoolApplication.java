/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolapplication;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author training
 */
enum Status {FAIL, PASS}
class Student implements Serializable, Comparable{
    String name;
    int id;
    int m1;
    int m2;
    int total;
    Status s;
    public int compareTo(Object obj){
        if(id > ((Student)obj).id)
            return 1;
        return -1;
    }
}

class Teacher{
    ArrayList sl = new ArrayList();
    HashSet hs = new HashSet();
    void getDetails(){
        String l;
        boolean done = false;
        int i = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        while(!done){
            Student s = new Student();
            System.out.print("Enter the name : ");
            l = br.readLine();
            s.name = l;
            System.out.print("Enter the id : ");
            l = br.readLine();
            s.id = Integer.parseInt(l);
            System.out.println("Enter the marks in the first subject  : ");
            l = br.readLine();
            s.m1 = Integer.parseInt(l);
            System.out.println("Enter the marks in the second subject : ");
            l = br.readLine();
            s.m2 = Integer.parseInt(l);
            sl.add(s);
            hs.add(s);
            System.out.println("Add another student (y/n)?");
            l = br.readLine();
            if(l.equals("n")) done = true;
        }
        }
        catch(IOException e){
            e.printStackTrace();
        }
}
    void calculate(){
            for(int i = 0; i < sl.size(); i++){
                Student s = (Student)sl.get(i);
                s.total = s.m1+s.m2;
                if(s.total < 50) s.s = Status.FAIL;
                else s.s = Status.PASS;
            }
    }
    
    void printStudent(Student s){
            System.out.println("Name                 : "+s.name);
            System.out.println("id                   : "+s.id);
            System.out.println("Marks in 1st subject : "+s.m1);
            System.out.println("Marks in 2nd subject : "+s.m2);
            if(s.s == Status.FAIL)
                System.out.println("Great!!! You failed.\nHave a nice day.");
            else System.out.println("Pass");
            System.out.println("***********************");

    }
    
    void display(int in){
        if(in == 0){
            for(int i = 0; i < sl.size(); i++){
                Student s = (Student)sl.get(i);
            }
        }
        else if(in == 1){
            Iterator i = hs.iterator();
            while(i.hasNext()){
                Student s  = (Student)i.next();
                printStudent(s);
            }
        }
        else {
            TreeSet ts = new TreeSet(hs);
            Iterator i = ts.iterator();
            while(i.hasNext()){
                Student s  = (Student)i.next();
                printStudent(s);
            }
        }
    }
    
    void store(){
        try{
            FileOutputStream  fos = new FileOutputStream("student.sz");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(sl);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    void fetch(){
        try{
            FileInputStream  fis = new FileInputStream("student.sz");
            ObjectInputStream os = new ObjectInputStream(fis);
            sl = (ArrayList)os.readObject();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
public class SchoolApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Teacher t = new Teacher();
        t.getDetails();
        t.calculate();
        t.store();
        t.fetch();
        t.display(2);
    }
}
