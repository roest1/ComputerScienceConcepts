package collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class Collections {

    /**
        How to choose a collection:
        ----------------------------------------------------------
        1. Determine access patterns (insertion, removal, access).
        2. Determine key/value types.
        3. Determine if order matters.
        4. Choose collection based on efficiency requirements.
    */


    public static void main(String[] args) {
        
        //* Collections in Java *//
        
        // Lists: ArrayList and LinkedList // 
        
        /**
        LinkedList: Efficient for inserting/removing elements in the middle,
        efficient sequential access, inefficient random access.
        Use when concerned about insertion/removal efficiency.
        
        LinkedList<Student> myStudents = new LinkedList<>();
        myStudents.add(new Student("Riley", 899859039));
        ...
        */
        
        // Maps: HashMap and TreeMap // 
        
        /**
        TreeMap: Orders items by keys (use when key order matters)
        
        TreeMap<String, String> translator = new TreeMap<>();
        translator.put("anaranjado", "orange");
        ...
        */
        
        /**
        HashMap: Does not guarantee order
        
        HashMap<String, String> transltr = new HashMap<>();
        transltr.put("azul", "blue");
        ...
        */
        
        // Stacks & Queues // 

        /**
        Stacks: Last in, First out (LIFO)
        
        Stack<String> s = new Stack<>();
        s.push("alpha");
        s.push("beta");
        ...
        */


        /**
        Queues: First in, First out (FIFO)
        
        Queue<String> q = new LinkedList<>();
        q.add("first");
        q.add("second");
        ...
        */
    }
}
