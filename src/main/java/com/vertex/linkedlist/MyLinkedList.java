package com.vertex.linkedlist;

public class MyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public MyLinkedList() {
        lastNode = new Node<T>(null, null, firstNode);
        firstNode = new Node<T>(null, lastNode, null);
    }

    public void addFirst(T element) {
        Node<T> newNode = firstNode;
        newNode.setElement(element);
        firstNode = new Node<T>(null, newNode, null);
        newNode.setPrev(firstNode);
        size++;
    }

    public void addLast(T element) {
        Node<T> newNode = lastNode;
        newNode.setElement(element);
        lastNode = new Node<T>(null, null, newNode);
        newNode.setNext(lastNode);
        size++;
    }

    public int size() {
        return size;
    }

    public T getByIndex(int index) {
        Node<T> elemByIndex = firstNode.getNext();
        for (int i = 0; i < index; i++) {
            elemByIndex = getNextElement(elemByIndex);
        }
        return elemByIndex.getElement();
    }

    private Node<T> getNextElement(Node<T> elemByIndex) {
        return elemByIndex.getNext();
    }

    private class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;


        public Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
