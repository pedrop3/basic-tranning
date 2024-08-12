package JavaDataStructures.LinkedLists;

import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    //inner class
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head" + head.value);
    }

    public void getTail() {
        System.out.println("Tail" + tail.value);

    }

    public void getLength() {
        System.out.println("Length" + length);
    }

    /**
     * Add element in LinkedList and returns void
     *
     */
    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    private Node removeLast() {
        if (length == 0) throw new NoSuchElementException();

        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return tail;
    }

    public Node remove(int index ) {
        if(length < 0 || index >= length) return null;
        if(length == 0) return  removeFirst();
        if(length - 1 == index) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        length++;
    }

    public Node removeFirst() {
        if (length == 0) throw new NoSuchElementException();

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;

        for (int x = 0; x < index; x++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value)  {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public void  reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for( int i = 0; i< length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}

class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(1);

        linkedList.append(2);
        linkedList.append(3);


        linkedList.prepend(4);

        linkedList.set(4,5);
        linkedList.printList();

        linkedList.remove(2);
        System.out.println("\nAfter remove");
        linkedList.printList();

        linkedList.reverse();
        System.out.println("\nAfter reverse");
        linkedList.printList(); 

    }
}


