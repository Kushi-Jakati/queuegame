package edu.guilford;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Hello world!
 *
 */
public class PQDemo 
{
    public static void main( String[] args )
    {
        // Build a priority queue of random FullName objects
        // it will be sorted according to the natural ordering of FullName
        // as determined by the compareTo method and the sortOrder attribute
        // of the FullName class
        //The PriorityQueue is a class that implements the Queue interface
        //It is a queue that is sorted according to the natural ordering (Comparable) of
        //the objects that are added to it. 

        PriorityQueue<FullName> pq = new PriorityQueue<FullName>();
        // Add 20 FullName objects to the priority queue
        for (int i = 0; i < 20; i++) {
            FullName fn = new FullName();
            pq.add(fn);
        }

        // Print out the priority queue. We can't just print the priority queue
        // we got a weird result.  Now use poll to print out the priority queue in order.
        System.out.println("The priority queue is: ");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
            //poll removes the top element from the priority queue and returns it
        }
        //Efficient for sizes of 1000 or less

        //Let us build a queue to show the difference between a priority queue and a stack
        Stack<FullName> s = new Stack<FullName>();
        for (int i = 0; i < 20; i++) {
            FullName fn = new FullName();
            s.push(fn);
        }
        System.out.println("\nThe stack is: ");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
            //pop removes the top element from the stack and returns it
            //difference between poll and pop is that poll is for queues and pop is for stacks
        }

        System.out.println("\nIs that stack empty? " + s.isEmpty());
        //isEmpty returns true if the stack is empty and false if it is not empty
        //is the same for queues
        System.out.println("\nIs that priority queue empty? " + pq.isEmpty());
        //isEmpty returns true if the priority queue is empty and false if it is not empty
        //the stack and priority queue are empty because we removed all the elements from them
        //with pop and poll

        //Instantaite a TreeSet of FullName objects
        //The TreeSet is a class that implements the Set interface
        //It is a set that is sorted according to the natural ordering (Comparable) of
        //the objects that are added to it.
        //Add 20 FullName objects to the TreeSet
        TreeSet<FullName> ts = new TreeSet<FullName>();
        for (int i = 0; i < 20; i++) {
            FullName fn = new FullName();
            s.push(fn);
        }

        //print out the stack
        System.out.println("\nThe stack is: ");
        System.out.println(s);
        //pop off elements of the stack and add them to the TreeSet
        while (!s.isEmpty()) {
            //popping off element of stack returns that element and removes it from the stack
            ts.add(s.pop());
        }

        //Print out the TreeSet
        System.out.println("\nThe TreeSet is: ");
        System.out.println(ts);
        //size
        System.out.println("\nThe size of the TreeSet is: " + ts.size());

        //you will see duplicates removed tree set v stack


        //moving on...
        //Show that set is iterable using a for each loop
        System.out.println("\nUsing a for each loop to print out the TreeSet: ");
        for (FullName fn : ts) {
            System.out.println(fn);
        }

        //Is the set empty after we have iterated through it?
        System.out.println("\nIs the TreeSet empty? " + ts.isEmpty());
        //A set is a nondestructive data structure.  It is not empty after we have iterated through it.
        //Sets and lists have nondestructive iterators.  Queues and stacks have destructive iterators.
        //Difference between destructive and nondestructive iterators is whether accessing the elemnt 
        //removes it from the data structure or not.

        //Let us build a TreeMap of FullNae objects using the last name as a key; 
        TreeMap<String, FullName> map = new TreeMap<String, FullName>();
        //add 20 FullName objects to the TreeMap
        for (int i = 0; i < 20; i++) {
            FullName name = new FullName();
            String key = name.getLastName();
            //get first initial of last name
            //key = key.substring(0, 1);
            //get first initial of first name
            //key = key + name.getFirstName().substring(0, 1);
            //if key is already in the TreeMap, add a 1 to the end of it
            if (map.containsKey(key)) {
                key = key + i;
            }
            //Issue: what if we want to add data later? 
            map.put(key, name);
        }

        System.out.println("\nThe TreeMap is: ");
        System.out.println(map);
        //map size
        System.out.println("\nThe size of the TreeMap is: " + map.size());

        //Suppose that our values are a list of all FullName objects with the same last name
        TreeMap<String, ArrayList<FullName>> map2 = new TreeMap<String, ArrayList<FullName>>();
        //each key is associated with an ArrayList of FullName objects with that last name
        //add 20 FullName objects to the TreeMap
        for(int i = 0; i<20; i++ ) {
            FullName name = new FullName();
            String key = name.getLastName();
            //if the key is not in the map, add <key, new ArrayList<FullName>()>
            //so we have some place tostore the list of FullName objects with that last name
            if(!map2.containsKey(key)) {
                map2.put(key, new ArrayList<FullName>());
            }
            //get the ArrayList of FullName objects with that last name
            ArrayList<FullName> list = map2.get(key);
            //add the FullName object to the ArrayList
            list.add(name);
        }

        System.out.println("\nThe TreeMap is: ");
        System.out.println(map2);
        //map size
        System.out.println("\nThe size of the TreeMap is: " + map2.size());
        //get key for Anderson
        System.out.println("\nThe key for Anderson is: " + map2.get("Anderson"));

    }
}
