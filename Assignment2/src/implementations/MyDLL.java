package implementations;

import utilities.Iterator;
import utilities.ListADT;

import java.util.NoSuchElementException;

import java.util.Objects;


class MyDLLNode<E> {

    E data;
    MyDLLNode<E> next;
    MyDLLNode<E> prev;

    public MyDLLNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


public class MyDLL<E> implements ListADT<E> {

    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) {
        if (toAdd == null)
            throw new NullPointerException();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            if (tail != null) tail.next = newNode;
            tail = newNode;
        } else {
            MyDLLNode<E> current = getNode(index);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) {
        if (toAdd == null)
            throw new NullPointerException();
        return add(size, toAdd);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) {
        if (toAdd == null)
            throw new NullPointerException();
        for (int i = 0; i < toAdd.size(); i++) {
            add(toAdd.get(i));
        }
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        MyDLLNode<E> node = getNode(index);

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        size--;
        return node.data;
    }

    @Override
    public E remove(E toRemove) {
        if (toRemove == null)
            throw new NullPointerException();
        MyDLLNode<E> current = head;
        int index = 0;
        while (current != null) {
            if (Objects.equals(current.data, toRemove)) {
                return remove(index);
            }
            current = current.next;
            index++;
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) {
        if (toChange == null)
            throw new NullPointerException();
        checkIndex(index);
        MyDLLNode<E> node = getNode(index);
        E old = node.data;
        node.data = toChange;
        return old;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) {
        if (toFind == null)
            throw new NullPointerException();
        MyDLLNode<E> current = head;
        while (current != null) {
            if (Objects.equals(current.data, toFind)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(E[] toHold) {
        if (toHold == null)
            throw new NullPointerException();
        if (toHold.length < size) {
            toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
        }

        MyDLLNode<E> current = head;
        int i = 0;
        while (current != null) {
            toHold[i++] = current.data;
            current = current.next;
        }
        if (toHold.length > size) {
            toHold[size] = null;
        }
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyDLLNode<E> current = head;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyDLLIterator();
    }

    // Helpers
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private MyDLLNode<E> getNode(int index) {
        MyDLLNode<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--)
                current = current.prev;
        }
        return current;
    }

    private class MyDLLIterator implements Iterator<E> {
        private MyDLLNode<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}

