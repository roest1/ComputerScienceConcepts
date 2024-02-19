package comparingobjects;

/**
 * @author rileyoest
 */
public class Car implements Comparable<Car>{
    /**
    Comparable interface allows you to determine how your objects will be
    compared to each other
    */
    
    private String make;
    private int year;
    
    
    public Car(String make, int year){
        this.make = make;
        this.year = year;
    }
    
    public void printInfo(){
        System.out.printf("Make: %S\nYear: %d\n", make, year);
    }
    
    /** 
    compareTo() method 
    @returns -1 if year < other.year
    @returns 0 if year == other.year
    @returns 1 if year > other.year
    */

    public int compareTo(Car other) {
        if(Integer.compare(year, other.year) != 0){ // Sort based on year. If year is equal, sort based on make.
           return Integer.compare(year, other.year);
        }
        else{
            return make.compareTo(other.make);
        }
    }
}
