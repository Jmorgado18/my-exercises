package io.codeforall.bootcamp;

import java.awt.*;

public class LinkedList {

    private final Node head;
    private int length = 0;
    private int count = 0;


    public LinkedList() {
        this.head = new Node(null);

    }

    public int size() {
        return this.length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(Object data) {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public Object get(int index) {
        //throw new UnsupportedOperationException();

        int i = -1;
        Node iterator = head;
        while (iterator != null) {

            if (i == index) {
                return iterator.data;
            }
            iterator = iterator.next;
            i++;

        }
        return null;

    }


    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(Object data) {
        //Retorna o index onde está a DATA que demos como argumento
        //throw new UnsupportedOperationException();

        int i = 0;
        Node iterator = head.getNext();

        while (iterator != null) {

            if (iterator.getData().equals(data)) {
                return i;
            }
            iterator = iterator.getNext();
            i++;
        }
        return -1;
    }

    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data) {
        //Remove um Node (recebe data como argumento
        //no Node anterior, re-atribui o endereço para o Node seguinte

        Node iterator = head;

        while (iterator.getNext() != null) {

            if (iterator.getNext().getData().equals(data)) {

                iterator.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;


    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {

            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
