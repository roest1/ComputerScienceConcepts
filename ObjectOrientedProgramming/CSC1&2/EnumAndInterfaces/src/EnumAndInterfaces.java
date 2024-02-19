package enumandinterfaces;

import javafx.scene.media.Media;

/**
 * @author rileyoest
 */
public class EnumAndInterfaces {

    /**
     * 
     * Enums provide a way to define a type with a fixed set of constant values.
     * 
     * Interfaces define a contract that classes must adhere to by implementing specific methods.
     * 
     * Interfaces are all about defining capabilities that a class should have.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
           
        Enums
        Enums are used when you want a variable that can take on only a certain
        enumerated set of values. Enums are implicitly public, static, and final.

        */


        /**
         
        Interfaces
        Interfaces are another way to achieve abstraction in Java.
        Methods declared in an interface are by default abstract, meaning they
        have only method signatures and no implementation.
        Interfaces define a contract that implementing classes must adhere to.

        */

        
        /**

        For example, the Comparable interface means that a class implementing it
        must implement the compareTo() method.
        An interface defines a contract that an implementing class must fulfill.
        
        */



        /**
        Key points about interfaces:
        - We can't create an instance of an interface.
        - A class can implement more than one interface.
        - A class that implements an interface must implement all the methods in that
        interface.
        - All methods in an interface are public and abstract.
        - All fields in an interface are public, static, and final.
        */

        /**
        Popular Java interfaces:
        - Serializable, Cloneable, Readable, Appendable, Closeable, AutoCloseable, Observable, Iterable
         */

        //create an object of the media class
        Media mediaFile = new Media();
    }
    
}
