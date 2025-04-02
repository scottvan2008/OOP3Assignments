package implementations;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyQueue<T> implements QueueADT<T> {

    private MyDLL<T> list;

    public MyQueue() {
        list = new MyDLL<>();
    }

    @Override
    public void enqueue(T item) {
        if (item == null) throw new NullPointerException();
        list.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new EmptyQueueException();
        return list.remove(0);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyQueueException();
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void dequeueAll() {
        clear();
    }

    @Override
    public boolean contains(T item) {
        if (item == null) throw new NullPointerException();
        return list.contains(item);
    }

    @Override
    public int search(T item) {
        if (item == null) return -1;
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(list.get(i), item)) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public T[] toArray(T[] holder) {
        return list.toArray(holder);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean equals(Object thatQueue) {
        if (this == thatQueue) return true;
        if (thatQueue == null || !(thatQueue instanceof QueueADT)) return false;
        QueueADT<?> other = (QueueADT<?>) thatQueue;
        if (this.size() != other.size()) return false;
        Iterator<T> it1 = this.iterator();
        Iterator<?> it2 = other.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            if (!Objects.equals(it1.next(), it2.next())) return false;
        }
        return true;
    }
}
