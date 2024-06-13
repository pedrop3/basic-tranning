package JavaDataStructures.LinkedLists;

import java.io.IOException;
import java.util.Scanner;

public class SimpleLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList llist = new SinglyLinkedList();

        Scanner scanner = new Scanner(System.in);
        int llistCount = scanner.nextInt();

        while (llistCount > 0) {
            int llistItem = scanner.nextInt();
            SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);
            llist.head = llist_head;

            llistCount--;

        }

        llist.printList();
        scanner.close();

    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            return newNode;
        }

        SinglyLinkedListNode current = head;
        head = newNode;
        head.next = current;

        return head;

    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            return newNode;
        }

        SinglyLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;

    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }

        public void printList() {
            SinglyLinkedListNode current = this.head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

        public void add(int value, int position) {
            if (position < 0) {
                throw new IndexOutOfBoundsException("Position is out of bounds.");
            }
        
            
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);

            SinglyLinkedListNode current = this.head;
            SinglyLinkedListNode forward = null;

            int i = 0;

            while (i < position && current != null) {

                forward = current;
                current = current.next;

                i++;
            }

            boolean isHead = i == 0;
            
            if (isHead) {
                this.head = newNode;
                this.head.next = current;
            } else {
                newNode.next = current;
                forward.next = newNode;

            }

        }
    }

    public static void printSinglyLinkedList(SinglyLinkedList node)
            throws IOException {

        SinglyLinkedListNode current = node.head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}
