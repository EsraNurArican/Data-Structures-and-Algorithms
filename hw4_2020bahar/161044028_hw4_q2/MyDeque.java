import java.util.*;
import java.util.function.Consumer;

public class MyDeque<E> extends AbstractCollection<E> implements Deque<E> {
    /**
     * Inner class Node to represent the linked list structure
     * @param <E> type parameter
     */
    private static class Node<E>{

        private Node<E> prev;
        private Node<E> next;
        private E data;

        public Node<E> getPrev() {
            return prev;
        }
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public E getData() {
            return data;
        }
        public void setValue(E data) {
            this.data = data;
        }
    }

    /**
     * Inner MyIterator class to use in MyDeque class.
     * Written to iterate through elements in deque
     * @param <E> type parameter
     */
    private static class MyIterator<E> implements Iterator<E> {

        private Node<E> current;

        public MyIterator(MyDeque deque){
            current=deque.head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            E data = current.getData();
            current = current.getNext();
            return data;
        }

        /**
         * Performs the given action for each remaining element until all elements
         * have been processed or the action throws an exception.
         * @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         */
        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            if (action==null)
                throw new NullPointerException("action is null");
            while (hasNext())
                action.accept(next());
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         */
        @Override
        public void remove() {
                throw new UnsupportedOperationException();
        }
    }

    Node<E> head;
    Node<E> tail;
    Node<E> headRemoved;
    Node<E> tailRemoved;
    MyIterator<E> iterator;
    int size;
    int capacity=1000;

    /**
     * No parameter constructor
     * Assigns null to Node variables in the class
     * Creates iterator. Assigns zero to size.
     */
    MyDeque() {
        head = tail = null;
        headRemoved = tailRemoved = null;
        iterator = new MyIterator<>(this);
        size = 0;
    }

    /**
     * Inserts the specified element at the front of this deque
     * if it is possible to do so immediately without violating capacity restrictions.
     * If removedLinkedList is not empty, it takes a node from there to not create new node.
     * If removedLinkedList is empty, it creates new to for the element to be add.
     * When using a capacity-restricted deque, it is generally preferable to use method offerFirst(E).
     * @param e the element to add
     * @throws NullPointerException if the element cannot be added at this time due to capacity restrictions
     * @throws IllegalStateException if the specified element is null and this deque does not permit null elements
     */
    @Override
    public void addFirst(E e)  throws NullPointerException,IllegalStateException{
        if(size==capacity)
            throw new IllegalStateException("can not add,due to capacity restrictions");
        //If removed linked list is not empty
        if(tailRemoved!=null){
            //Removed node takes the new value to be add
            tailRemoved.setValue(e);

            if(head != null)
                head.setPrev(tailRemoved);

            if(head == null)
                tail = tailRemoved;

            Node<E> newNode = new Node<E>();
            newNode.setValue(e);
            newNode.setNext(head);
            head.prev=tailRemoved;
            head=newNode;
            tailRemoved.prev =null;
        }
        else if(tailRemoved==null) {
            Node<E> newNode = new Node<E>();
            newNode.setValue(e);
            newNode.setNext(head);
            if (head != null)
                head.setPrev(newNode);
            if (head == null)
                tail = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Inserts the specified element at the end of this deque
     * if it is possible to do so immediately without violating capacity restrictions.
     * When using a capacity-restricted deque, it is generally preferable to use method offerLast(E).
     * If removedLinkedList is not empty, it takes a node from there to not create new node.
     * If removedLinkedList is empty, it creates new to for the element to be add.
     * This method is equivalent to add(E).
     * @param e the element to add
     * @throws IllegalStateException if the specified element is null and this deque does not permit null elements
     */
    @Override
    public void addLast(E e)throws IllegalStateException {
        if(size==capacity)
            throw new IllegalStateException("can not add,due to capacity restrictions");
        Node<E> newNode = new Node<E>();
        newNode.setValue(e);
        newNode.setPrev(tail);
        if(tail != null)
            tail.setNext(newNode);
        if(tail == null)
            head = newNode;

        tail = newNode;
        size++;
    }

    /**
     * Inserts the specified element at the front of this deque unless it would violate capacity restrictions.
     * When using a capacity-restricted deque, this method is generally preferable to the addFirst(E) method,
     * which can fail to insert an element only by throwing an exception.
     * @throws NullPointerException - if the specified element is null and this deque does not permit null elements
     * @param e the element to add
     * @return true if the element was added to this deque, else false
     */
    @Override
    public boolean offerFirst(E e) {
        if(e==null)
            throw new NullPointerException("can not add a null element!");
        //If removed linked list is not empty
        if(tailRemoved!=null){
            //Removed node takes the new value to be add
            tailRemoved.setValue(e);

            if(head != null)
                head.setPrev(tailRemoved);

            if(head == null)
                tail = tailRemoved;

            Node<E> newNode = new Node<E>();
            newNode.setValue(e);
            newNode.setNext(head);
            head.prev=tailRemoved;
            head=newNode;
            tailRemoved.prev =null;
        }
        else if(tailRemoved==null) {
            Node<E> newNode = new Node<E>();
            newNode.setValue(e);
            newNode.setNext(head);
            if (head != null)
                head.setPrev(newNode);
            if (head == null)
                tail = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the end of this deque unless it would violate capacity restrictions.
     * When using a capacity-restricted deque, this method is generally preferable to the addLast(E) method,
     * which can fail to insert an element only by throwing an exception.
     * @throws NullPointerException - if the specified element is null and this deque does not permit null elements
     * @param e the element to add
     * @return true if the element was added to this deque, else false
     */
    @Override
    public boolean offerLast(E e) {
        if(e==null)
            throw new NullPointerException("can not add a null element!");

        Node<E> newNode = new Node<E>();
        newNode.setValue(e);
        newNode.setPrev(tail);
        if(tail != null)
            tail.setNext(newNode);
        if(tail == null)
            head = newNode;

        tail = newNode;
        size++;
        return true;
    }

    /**
     * Retrieves and removes the first element of this deque.
     * This method differs from pollFirst only in that it throws an exception if this deque is empty.
     * After removing first item from deque, this method adds that node to removedLinkedList to use it later.
     * @throws NoSuchElementException - if this deque is empty
     * @return the head of this deque
     */
    @Override
    public E removeFirst() {
        if(head == null){
           throw new NoSuchElementException("can not remove,deque is empty");
        }
        //remove an item from the beginning of the queue
        Node<E> temp = head.getNext();
        if(temp != null) {
            temp.setPrev(null);
        }
        if(temp == null) {
            tail = null;
        }
        //Adding removed item to removed list
        if(tailRemoved != null)
            tailRemoved.setNext(head);
        if(tailRemoved == null)
            headRemoved = head;
        tailRemoved = head;
        tailRemoved.next=null;
        head = temp;
        size--;
        return head.data;
    }

    /**
     * Retrieves and removes the last element of this deque.
     * This method differs from pollLast only in that it throws an exception if this deque is empty.
     * After removing last item from deque, this method adds that node to removedLinkedList to use it later.
     * @throws NoSuchElementException - if this deque is empty
     * @return the tail of this deque
     */
    @Override
    public E removeLast() {
        if(tail == null){
            throw new NullPointerException("Deque underflow!! unable to remove.");
        }
        //remove an item from the end of the queue
        Node<E> temp = tail.getPrev();
        if(temp != null)
            temp.setNext(null);
        if(temp == null)
            head = null;
        //Adding removed item to removed list
        if(headRemoved != null)
            headRemoved.setNext(tail);
        if(headRemoved == null)
            tailRemoved = tail;
        headRemoved = tail;
        headRemoved.next=null;

        tail = temp;
        size--;
        return tail.data;
    }

    /**
     * Retrieves and removes the first element of this deque, or returns null if this deque is empty.
     * @return head of this deque, or null if this deque is empty
     */
    @Override
    public E pollFirst() {
        if(head==null)
            return null;

        //remove an item from the beginning of the queue
        Node<E> temp = head.getNext();
        if(temp != null) {
            temp.setPrev(null);
        }
        if(temp == null) {
            tail = null;
        }
        //Adding removed item to removed list

        if(tailRemoved != null)
            tailRemoved.setNext(head);
        if(tailRemoved == null)
            headRemoved = head;
        tailRemoved = head;
        tailRemoved.next=null;
        head = temp;
        size--;
        return head.data;

    }

    /**
     * Retrieves and removes the last element of this deque, or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E pollLast() {
        //remove an item from the end of the queue
        Node<E> temp = tail.getPrev();
        if(temp != null)
            temp.setNext(null);
        if(temp == null)
            head = null;
        //Adding removed item to removed list
        if(headRemoved != null)
            headRemoved.setNext(tail);
        if(headRemoved == null)
            tailRemoved = tail;
        headRemoved = tail;
        headRemoved.next=null;
        tail = temp;
        size--;
        return tail.data;
    }

    /**
     * Retrieves, but does not remove, the first element of this deque.
     * This method differs from peekFirst only in that it throws an exception if this deque is empty
     * @return head of deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E getFirst() throws NoSuchElementException{
        if(head==null){
            throw new NoSuchElementException("This deque is empty!");
        }
        return head.data;

    }

    /**
     * Retrieves, but does not remove, the last element of this deque.
     * This method differs from peekLast only in that it throws an exception if this deque is empty.
     * @return the tail of this deque
     * @throws  NoSuchElementException - if this deque is empty
     */
    @Override
    public E getLast() {
        if(head==null){
            throw new NoSuchElementException("This deque is empty!");
        }
        return tail.data;
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public E peekFirst() {
        if(head==null)
            return null;
        return head.data;
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E peekLast() {
        if(head==null)
            return null;
        return tail.data;
    }

    /**
     * Removes the first occurrence of the specified element from this deque.
     * @param o element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }


    /**
     * Removes the last occurrence of the specified element from this deque.
     * @param o element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    /**
     * Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque)
     * This method is equivalent to addLast(E).
     * @param e generic type element to add
     * @return true if adding done
     * @throws IllegalStateException  if the element cannot be added at this time due to capacity restrictions
     */
    @Override
    public boolean add(E e) throws IllegalStateException {
        if(size==capacity)
            throw new IllegalStateException("can not add,due to capacity restrictions");

        Node<E> newNode = new Node<>();
        newNode.setValue(e);
        newNode.setPrev(tail);
        if(tail != null)
            tail.setNext(newNode);
        if(tail == null)
            head = newNode;

        tail = newNode;
        size++;
        return true;
    }

    /**
     * Inserts the specified element into the queue represented by this deque
     * returning true upon success and false if no space is currently available.
     * This method is equivalent to offerLast(E).
     * @throws NullPointerException - if the specified element is null and this deque does not permit null elements
     * @param e the element to add
     * @return true if the element was added to this deque, else false
     */
    @Override
    public boolean offer(E e) throws NullPointerException{
        if(e==null)
            throw new NullPointerException("specified element is null!");

        Node<E> newNode = new Node<E>();
        newNode.setValue(e);
        newNode.setPrev(tail);
        if(tail != null)
            tail.setNext(newNode);
        if(tail == null)
            head = newNode;

        tail = newNode;
        size++;
        return true;

    }

    /**
     * Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque).
     * This method differs from poll only in that it throws an exception if this deque is empty.
     * This method is equivalent to removeFirst().
     * @throws NoSuchElementException - if this deque is empty
     * @return the head of the queue represented by this deque
     */
    @Override
    public E remove() throws NoSuchElementException{
        if(head==null)
            throw new NoSuchElementException("this deque is empty!");
        //remove an item from the beginning of the queue
        Node<E> temp = head.getNext();
        if(temp != null) {
            temp.setPrev(null);
        }
        if(temp == null) {
            tail = null;
        }
        //Adding removed item to removed list
        if(tailRemoved != null)
            tailRemoved.setNext(head);
        if(tailRemoved == null)
            headRemoved = head;
        tailRemoved = head;
        tailRemoved.next=null;
        head = temp;
        size--;
        return head.data;
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     * This method is equivalent to pollFirst().
     * @return the first element of this deque, or null if this deque is empty
     */
    @Override
    public E poll() {
        if(head==null)
            return null;
        //remove an item from the beginning of the queue
        Node<E> temp = head.getNext();
        if(temp != null) {
            temp.setPrev(null);
        }
        if(temp == null) {
            tail = null;
        }
        //Adding removed item to removed list
        if(tailRemoved != null)
            tailRemoved.setNext(head);
        if(tailRemoved == null)
            headRemoved = head;
        tailRemoved = head;
        tailRemoved.next=null;
        head = temp;
        size--;
        return head.data;

    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque).
     * This method differs from peek only in that it throws an exception if this deque is empty.
     * This method is equivalent to getFirst().
     * @throws NoSuchElementException - if this deque is empty
     * @return the head of the queue represented by this deque
     */
    @Override
    public E element() {
        if(head==null)
            throw new NoSuchElementException("this deque is empty!");
        return head.data;
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque
     * (in other words, the first element of this deque), or returns null if this deque is empty.
     * This method is equivalent to peekFirst().
     * @return the head of the queue represented by this deque, or null if this deque is empty
     */
    @Override
    public E peek() {
        if(head==null)
            return null;
        return head.data;
    }

    /**
     * Clears the deque
     */
    @Override
    public void clear() {
        size=0;
        head=null;
    }

    /**
     * Pushes an element onto the stack represented by this deque (in other words, at the head of this deque)
     * if it is possible to do so immediately without violating capacity restrictions,
     * returning true upon success and throwing an IllegalStateException if no space is currently available.
     * This method is equivalent to addFirst(E).
     * @throws IllegalStateException - if the element cannot be added at this time due to capacity restrictions
     * @throws NullPointerException - if the specified element is null and this deque does not permit null elements
     * @param e the element to push
     */
    @Override
    public void push(E e)throws IllegalStateException,NullPointerException {
        if(size==capacity)
            throw new IllegalStateException("can not add,due to capacity restrictions");
        if(e==null)
            throw new NullPointerException("element to be add is null!");

        //If removed linked list is not empty
        if(tailRemoved!=null){
            //Removed node takes the new value to be add
            tailRemoved.setValue(e);

            if(head != null)
                head.setPrev(tailRemoved);

            if(head == null)
                tail = tailRemoved;

            Node<E> newNode = new Node<E>();
            newNode.setValue(e);
            newNode.setNext(head);
            //head.prev=tailRemoved;
            head=newNode;
            tailRemoved.prev =null;
        }
        else if(tailRemoved==null) {
            Node<E> newNode = new Node<E>();
            newNode.setValue(e);
            newNode.setNext(head);
            if (head != null)
                head.setPrev(newNode);
            if (head == null)
                tail = newNode;
            head = newNode;
        }
        size++;

    }

    /**
     * Pops an element from the stack represented by this deque.
     * In other words, removes and returns the first element of this deque.
     * This method is equivalent to removeFirst().
     * @throws NoSuchElementException - if this deque is empty
     * @return the element at the front of this deque (which is the top of the stack represented by this deque)
     */
    @Override
    public E pop() throws NoSuchElementException{
        if(head==null)
            throw new NoSuchElementException("this deque is empty");
        //remove an item from the beginning of the queue
        Node<E> temp = head.getNext();
        if(temp != null) {
            temp.setPrev(null);
        }
        if(temp == null) {
            tail = null;
        }
        //Adding removed item to removed list

        if(tailRemoved != null)
            tailRemoved.setNext(head);
        if(tailRemoved == null)
            headRemoved = head;
        tailRemoved = head;
        tailRemoved.next=null;
        head = temp;
        size--;
        return head.data;
    }

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     *
     * @return {@code true} if this collection contains no elements
     */
    @Override
    public boolean isEmpty() {
        return (head==null);
    }

    /**
     * Returns an iterator over the elements in this deque in proper sequence.
     * The elements will be returned in order from first (head) to last (tail).
     *
     * @return an iterator over the elements in this deque in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        iterator=new MyIterator<>(this);
        iterator.current=head;
        return iterator;
    }


    /**
     * Returns an iterator over the elements in this deque in reverse
     * sequential order.  The elements will be returned in order from
     * last (tail) to first (head).
     *
     * @return an iterator over the elements in this deque in reverse
     * sequence
     */
    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    /**
     * Prints the values in deque to the screen
     */
    public void printDequeue(){
        if(head==null){
            System.out.println("This deque is empty.");
            return;
        }
        System.out.print("Values in deque:  ");
        Node temp= new Node();
        temp=head;
        while(temp!=null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.print("\n");

    }

    /**
     * Prints the values in the removed linked list to the screen
     */
    public void printRemoved(){
        System.out.print("Values in removed linked list:  ");
        Node temp= new Node();
        temp=headRemoved;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
}//end of MyDeque class
