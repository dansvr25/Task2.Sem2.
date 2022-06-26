package ru.vsu.cs.sviridov_d_v.ProjectFiles;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T> {
    private SimpleLinkedListNode head = null;
    private SimpleLinkedList<T>.SimpleLinkedListNode tail = null;
    private int size = 0;

    public SimpleLinkedList() {
    }

    public void addFirst(T value) {
        this.head = new SimpleLinkedList.SimpleLinkedListNode(value, this.head);
        if (this.size == 0) {
            this.tail = this.head;
        }

        ++this.size;
    }

    public void addLast(T value) {
        if (this.size == 0) {
            this.head = this.tail = new SimpleLinkedList.SimpleLinkedListNode(value);
        } else {
            this.tail.next = new SimpleLinkedList.SimpleLinkedListNode(value);
            this.tail = this.tail.next;
        }

        ++this.size;
    }

    private void checkEmptyError() throws SimpleLinkedList.SimpleLinkedListException {
        if (this.size == 0) {
            throw new SimpleLinkedList.SimpleLinkedListException("Empty list");
        }
    }

    private SimpleLinkedList<T>.SimpleLinkedListNode getNode(int index) {
        SimpleLinkedList<T>.SimpleLinkedListNode curr = this.head;

        for(int i = 0; i < index; ++i) {
            curr = curr.next;
        }

        return curr;
    }

    public void removeFirst() throws SimpleLinkedList.SimpleLinkedListException {
        this.checkEmptyError();
        this.head = this.head.next;
        if (this.size == 1) {
            this.tail = null;
        }

        --this.size;
    }

    public void removeLast() throws SimpleLinkedList.SimpleLinkedListException {
        this.checkEmptyError();
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = this.getNode(this.size - 2);
            this.tail.next = null;
        }

        --this.size;
    }

    public void remove(int index) throws SimpleLinkedList.SimpleLinkedListException {
        this.checkEmptyError();
        if (index >= 0 && index < this.size) {
            if (index == 0) {
                this.removeFirst();
            } else {
                SimpleLinkedList<T>.SimpleLinkedListNode prev = this.getNode(index - 1);
                prev.next = prev.next.next;
                if (prev.next == null) {
                    this.tail = prev;
                }

                --this.size;
            }

        } else {
            throw new SimpleLinkedList.SimpleLinkedListException("Incorrect index");
        }
    }

    public int size() {
        return this.size;
    }

    public T get(int index) throws SimpleLinkedList.SimpleLinkedListException {
        this.checkEmptyError();
        return this.getNode(index).value;
    }

    public Object getFirst() throws SimpleLinkedList.SimpleLinkedListException {
        this.checkEmptyError();
        return this.head.value;
    }

    public T getLast() throws SimpleLinkedList.SimpleLinkedListException {
        this.checkEmptyError();
        return this.tail.value;
    }

    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            SimpleLinkedList<T>.SimpleLinkedListNode curr;

            SimpleLinkedListIterator() {
                this.curr = SimpleLinkedList.this.head;
            }

            public boolean hasNext() {
                return this.curr != null;
            }

            public T next() {
                T value = this.curr.value;
                this.curr = this.curr.next;
                return value;
            }
        }

        return new SimpleLinkedListIterator();
    }

    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedList<T>.SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedList<T>.SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, (SimpleLinkedList.SimpleLinkedListNode)null);
        }
    }

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }
}