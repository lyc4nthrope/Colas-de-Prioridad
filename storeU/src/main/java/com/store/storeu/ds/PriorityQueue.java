package com.store.storeu.ds;

public class PriorityQueue<T extends Comparable<T>> {
    private Node<T> head;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void offer(T item) {
        Node<T> node = new Node<>(item);
        if (head == null || item.compareTo(head.data) < 0) {
            node.next = head;
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null && item.compareTo(current.next.data) >= 0) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
        size++;
    }

    public T poll() {
        if (head == null) return null;
        T result = head.data;
        head = head.next;
        size--;
        return result;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz) {
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        Node<T> current = head;
        for (int i = 0; i < size && current != null; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    public int size() {
        return size;
    }
}