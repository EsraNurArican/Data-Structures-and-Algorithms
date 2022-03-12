import java.security.InvalidParameterException;
import java.util.AbstractList;
import java.util.List;

/**
 * LinkedArrayList class extends AbstractList and implements List
 * @param <E> generic type parameter
 */
public class LinkedArrayList<E> extends AbstractList implements List {

    /**
     * Inner node class to represent the nodes of the LinkedArrayList
     * Each node keeps an array as data field
     * @param <E> generic type parameter
     */
    public static class Node<E>{
        /**
         * private data field as array
         */
        private E[] data;
        /**
         * integer size value for arrays size
         */
        private int sizeArr;
        /**
         * integer used value for used elements
         */
        private int used;

        /**
         * private node keeps next node
         */
        private Node<E> next;
        /**
         * private node keeps previous node
         */
        private Node<E> prev;

        /**
         * Constructor that takes one parameter as array
         * @param dataItem generic type array value
         */
        private Node(E[] dataItem) {
            data = (E[]) new Object [5];
            System.arraycopy(dataItem, 0, data, 0, dataItem.length);
            sizeArr=dataItem.length;
            used=dataItem.length;
            prev = next = null;
        }

        /**
         * Constructor that takes three parameters
         * @param dataItem generic type array value
         * @param next Node for next
         * @param prev Node for previous
         */
        private Node(E[] dataItem, Node next, Node prev) {
            System.arraycopy(dataItem, 0, data, 0, dataItem.length);
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * private data field type generic Node head
     */
    private Node<E>head=null;
    /**
     * private data field type generic Node tail
     */
    private Node<E>tail=null;
    /**
     * Private integer size keeps the size of the linkedArrayList
     */
    private int size=0;

    /**
     * Add method adds an element to the LinkedArrayList
     * @param index index information that new node to be add
     * @param element new element to add
     * @throws InvalidParameterException
     */
    public void add(int index, Object element) throws InvalidParameterException {
        if (index < 0 || index > size)
            throw new InvalidParameterException();
        Node<E> newNode = new Node<E>((E[]) element);
        //if  list is empty, index must be 0
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        // insert before the head
        else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        // insert after the tail
        else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        // general case
        else {
            Node<E> nodeRef = head;
            for (int i = 1; i < index; i++)
                nodeRef = nodeRef.next;
            // nodeRef now points to the node before the insert point

            newNode.next = nodeRef.next;
            nodeRef.next = newNode;
            newNode.prev = nodeRef;
            newNode.next.prev = newNode;
        }
        size++;
    }

    /**
     * Overridden size method
     * @return size of the linkedArrayList
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     *
     * @param index
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public Object get(int index) {
        return null;
    }

    /**
     * Overridden toString method to print list's elements
     * @return string list's elements
     */
    @Override
    public String toString() {
        Node<E> nodeRef = tail;
        StringBuilder result = new StringBuilder();
        while (nodeRef != null){
            for(int i=0;i<nodeRef.data.length;i++){
                result.append(nodeRef.data[i]+ " ");
            }
            if (nodeRef.prev != null)
                result.append(" ==> ");
            nodeRef = nodeRef.prev;
        }
        return result.toString();
    }
}
