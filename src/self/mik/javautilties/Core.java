package self.mik.javautilties;

import java.util.LinkedList;
import java.util.Queue;

public class Core {
    public static void printLetter(int n){
     if (n == 0){
         return;
     }
     System.out.print("a");
     printLetter(n-1);
     System.out.print("b");
    }
    public static void main(String[] args){
        printLetter(5);
        Queue<Integer> queue = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + queue.peek());
        // 3. Push new element.
        queue.offer(5);
        queue.offer(13);
        queue.offer(8);
        queue.offer(6);
        // 4. Pop an element.
        queue.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + queue.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + queue.size());
    }
}
