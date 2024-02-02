package arrays;

import java.util.PriorityQueue;

/**
 * PriorityQueue
 */
public class PriorityQueueExemplo {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        
        priorityQueue.add("dishes");
        priorityQueue.add("laundry");
        priorityQueue.add("bills");
        priorityQueue.offer("bills");

        System.out.print(priorityQueue.size() + " " + priorityQueue.poll() );
        System.out.print(" "+ priorityQueue.peek()+ " "+priorityQueue.poll());
        System.out.print(" "+ priorityQueue.poll()+ " "+ priorityQueue.poll());

    }
}