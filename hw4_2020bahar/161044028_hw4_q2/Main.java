import java.util.Iterator;

/**
 * Main class written for testing the MyDeque class
 */
public class Main {
    /**
     * Static main method calls every method in the MyDeque class.
     * Tests the methods for MyDeque class.
     * @param args String parameter
     */
    public static void main(String [] args){

        //Creating deque object for testing
        MyDeque<Integer> deque =new MyDeque<Integer>();
        System.out.println("---ADD FIRST TEST--- ");
        deque.addFirst(1);
        System.out.println("1 added.");
        deque.printDequeue();
        deque.addFirst(2);
        System.out.println("2 added.");
        deque.printDequeue();
        deque.addFirst(3);
        System.out.println("3 added.");
        deque.printDequeue();

        System.out.println("---ADD LAST TEST--- ");
        deque.addLast(5);
        System.out.println("5 added.");
        deque.printDequeue();
        deque.addLast(6);
        System.out.println("6 added.");
        deque.printDequeue();
        deque.addLast(7);
        System.out.println("7 added.");
        deque.printDequeue();

        System.out.println("---OFFER FIRST TEST--- ");
        deque.offerFirst(4);
        System.out.println("4 added.");
        deque.printDequeue();
        deque.offerFirst(0);
        System.out.println("0 added.");
        deque.printDequeue();

        System.out.println("---OFFER LAST TEST--- ");
        deque.offerLast(9);
        System.out.println("9 added.");
        deque.printDequeue();
        deque.offerLast(1);
        System.out.println("1 added.");
        deque.printDequeue();

        System.out.println("---REMOVE FIRST TEST---");
        System.out.println("Calling removeFirst..");
        deque.removeFirst();
        deque.printDequeue();
        deque.printRemoved();
        System.out.println("Calling removeFirst..");
        deque.removeFirst();
        deque.printDequeue();
        deque.printRemoved();
        System.out.println("Calling removeFirst..");
        deque.removeFirst();
        deque.printDequeue();
        deque.printRemoved();

        System.out.println("---REMOVE LAST TEST---");
        System.out.println("Calling removeLast..");
        deque.removeLast();
        deque.printDequeue();
        System.out.println("Calling removeLast..");
        deque.removeLast();
        deque.printDequeue();
        System.out.println("Calling removeLast..");
        deque.removeLast();
        deque.printDequeue();

        System.out.println("---POLL FIRST TEST---");
        System.out.println("Calling pollFirst..");
        deque.pollFirst();
        deque.printDequeue();
        System.out.println("---POLL LAST TEST---");
        System.out.println("Calling pollLast..");
        deque.pollLast();
        deque.printDequeue();

        System.out.println("---GET FIRST TEST---");
        System.out.println("Calling getFirst..");
        System.out.println(deque.getFirst());

        System.out.println("---GET LAST TEST---");
        System.out.println("Calling getLast..");
        System.out.println(deque.getLast());

        System.out.println("---PEEK FIRST TEST---");
        System.out.println("Calling peekFirst..");
        System.out.println(deque.peekFirst());

        System.out.println("---PEEK LAST TEST---");
        System.out.println("Calling peekLast..");
        System.out.println(deque.peekLast());

        System.out.println("---ADD TEST---");
        deque.add(10);
        System.out.println("10 added.");
        deque.printDequeue();
        deque.add(13);
        System.out.println("13 added.");
        deque.printDequeue();

        System.out.println("---OFFER TEST---");
        deque.offer(15);
        System.out.println("15 added.");
        deque.printDequeue();
        deque.offer(17);
        System.out.println("17 added.");
        deque.printDequeue();

        System.out.println("---SIZE TEST---");
        deque.printDequeue();
        System.out.println("size called: "+deque.size());

        System.out.println("---REMOVE TEST---");
        deque.remove();
        System.out.println("Remove called.");
        deque.printDequeue();
        deque.remove();
        System.out.println("Remove called.");
        deque.printDequeue();

        System.out.println("---POLL TEST---");
        deque.poll();
        System.out.println("poll called.");
        deque.printDequeue();
        deque.poll();
        System.out.println("poll called.");
        deque.printDequeue();

        System.out.println("---ELEMENT TEST---");
        System.out.println("element called.");
        System.out.println(deque.element());

        System.out.println("---PEEK TEST---");
        System.out.println("peek called.");
        System.out.println(deque.peek());

        System.out.println("---CLEAR TEST---");
        deque.clear();
        deque.printDequeue();
        System.out.println("size called after clearing deque: "+deque.size());
        System.out.println("isEmpty called: "+deque.isEmpty());

        System.out.println("---PUSH TEST---");
        deque.push(3);
        System.out.println("3 pushed.");
        deque.printDequeue();
        deque.push(6);
        System.out.println("6 pushed.");
        deque.printDequeue();
        deque.push(5);
        System.out.println("5 pushed.");
        deque.printDequeue();

        System.out.println("---POP TEST---");
        deque.pop();
        System.out.println("pop called.");
        deque.printDequeue();

        System.out.println("---IS EMPTY TEST---");
        deque.printDequeue();
        System.out.println("isEmpty called: "+deque.isEmpty());

        System.out.println("---ITERATOR TEST---");
        System.out.println("Reaching the deque's head with iterator.");
        System.out.println(deque.iterator().next());

    }
}
