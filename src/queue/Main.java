package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        // Queue = FIFO data structure. First-In First-Out
        //         A collection designed for holding elements prior to processing
        //         linear data structure.
        //
        //         add      = enqueue, offer()
        //         remove   = dequeue, poll()

        Queue<String> queue = new LinkedList<>();

        // check to see if queue is empty (inherited from collections that queue implements)

        System.out.println(queue.isEmpty());

        // insert elements into this queue

        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.contains("Harold"));

        // Print the queue
        System.out.println(queue);

        // peek
        System.out.println(queue.peek());

        // dequeue

        queue.poll();

        // peek
        System.out.println(queue);
        System.out.println(queue.peek());


        // Where are queues useful?
        // 1. Keyboard Buffer (Letters should appear on the screen in the order they're pressed)
        // 2. Printer Queue (Print jobs should be completed in order)
        // 3. Used in linkedLists, PriorityQueues, Breadth-first search

    }

}
