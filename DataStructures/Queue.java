package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node first;    // beginning of queue
    private Node last;     // end of queue
    private int n;         // number of elements on queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    // Initializes an empty queue
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    // Returns true if this queue is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Returns the number of items in this queue
    public int size() {
        return n;
    }

    // Returns the item least recently added to this queue
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    // Adds the item to this queue
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    // Removes and returns the item on this queue that was least recently added
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    // Returns a string representation of this queue
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    // Returns an iterator that iterates over the items in this queue in FIFO order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}