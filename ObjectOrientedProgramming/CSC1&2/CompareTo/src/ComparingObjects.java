package comparingobjects;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rileyoest
 */
public class ComparingObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Car> myCars = new ArrayList<>();

        myCars.add(new Car("Chevy", 2020));
        myCars.add(new Car("Ford", 2020));
        myCars.add(new Car("Toyota", 2018));
        
        Collections.sort(myCars); // calls the object's compareTo() method
        
        /**
        compareTo(a, b) indicates whether a or b comes first alphanumerically

        If elements(list) = numbers ⟹ Collections.Sort(List) sorts numerically
        If elements(list) = Strings ⟹ Collections.Sort(List) sorts alphabetically
        If elements(list) = objects ⟹ Collections.Sort(List) sorts based on the compareTo() method implementation

        */
        
        
        // print the cars in sorted order:
        for(Car c : myCars){
            c.printInfo();
        }
        
        int x = 5, y = 10;
        
        System.out.println(Integer.compare(x,y));
        System.out.println(Integer.compare(y,x));
        int z = 5;
        System.out.println(Integer.compare(x, z));
        
        // Comparing variables
        // ==========================
        
        // Integer.compare(a,b);
        // Double.compare(a,b);
        // str1.compareTo(str2);
        
    }
    
}
