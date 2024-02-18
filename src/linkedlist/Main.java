package linkedlist;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {


        // LinkedList = stores nodes in 2 parts (data + address)
        //              Nodes are in non-consecutive memory locations
        //              Elements are linked using pointers

        //                          Singly Linked List
        //              Node                Node                Node
        //         [data | address] -> [data | address] -> [data | address]
        //                          Doubly Linked List
        //                    Node                           Node
        //         [address | data | address] <-> [address | data | address]

        //         Advantages?
        //         1. Dynamic Data Structure (allocates needed memory while running)
        //         2. Insertion and Deletion of Node is easy. O(1) constant time
        //         3. No/Low memory waste

        //         Disadvantages?
        //         1. Greater memory usage (additional pointers)
        //         2. No random access of elements (no index [i])
        //         3. Accessing/searching elements is more time consuming. O(n) Liner time

        //         uses?
        //         1. implements Stack/Queues
        //         2. GPS navigation
        //         3. music playlist


        LinkedList<String> linkedList = new LinkedList<>();

        // can be treated as a stack
        // linkedList.push("A");
        // linkedList.push("B");
        // linkedList.push("C");
        // linkedList.push("D");
        // linkedList.push("F");
        // linkedList.pop();

        // can be treated as a queue
        // linkedList.offer("A");
        // linkedList.offer("B");
        // linkedList.offer("C");
        // linkedList.offer("D");
        // linkedList.offer("F");
        // linkedList.poll();


        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");

        linkedList.add(4, "E");
        linkedList.remove("E");

        System.out.println(linkedList.indexOf("F"));

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());

        linkedList.addFirst("0");
        linkedList.addLast("G");

        String first = linkedList.removeFirst();
        String last = linkedList.removeLast();

        System.out.println(first);
        System.out.println(last);

        System.out.println(linkedList);


    }


}
