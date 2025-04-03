package implementations;

import utilities.StackADT;
import utilities.Iterator;

import java.util.EmptyStackException;
import java.util.Objects;
import java.io.Serializable;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E>, Serializable {

    private MyArrayList<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException();
        list.add(toAdd);
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[list.size()];
        for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = list.get(i);
        }
        return arr;
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) throw new NullPointerException();
        if (holder.length < list.size()) {
            holder = (E[]) java.lang.reflect.Array.newInstance(holder.getClass().getComponentType(), list.size());
        }
        for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
            holder[j] = list.get(i);
        }
        if (holder.length > list.size()) {
            holder[list.size()] = null;
        }
        return holder;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException();
        return list.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        if (toFind == null) return -1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (Objects.equals(list.get(i), toFind)) {
                return list.size() - i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = list.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                return list.get(index--);
            }
        };
    }

    @Override
    public boolean equals(StackADT<E> that) {
        if (this == that) return true;
        if (that == null || this.size() != that.size()) return false;
        Iterator<E> it1 = this.iterator();
        Iterator<E> it2 = that.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            if (!Objects.equals(it1.next(), it2.next())) return false;
        }
        return true;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean stackOverflow() {
        return false;
    }
}
