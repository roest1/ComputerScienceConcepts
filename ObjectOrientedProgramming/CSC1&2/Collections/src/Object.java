package collections;

/**
 *
 * @author rileyoest
 */
public class Object {
    
    private String name;
    private long ID;
    
    // constructor for an Object

    protected Object(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }
    
    protected void printInfo(){
        System.out.println("Student Name: " + name);
        System.out.println("ID number: " + ID);
    }
    
}
