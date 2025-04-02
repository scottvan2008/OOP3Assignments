package implementations;

import utilities.Iterator;
import utilities.StackADT;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyStack<T> implements StackADT<T> {

    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    @Override
    public void push(T item) {
        if (item == null) throw new NullPointerException();
        list.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.get(list.size() - 1);
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
    public boolean contains(T item) {
        if (item == null) throw new NullPointerException();
        return list.contains(item);
    }

    @Override
    public int search(T item) {
        if (item == null) throw new NullPointerException();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (Objects.equals(list.get(i), item)) {
                return list.size() - i;
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        for (int i = size() - 1, j = 0; i >= 0; i--, j++) {
            result[j] = list.get(i);
        }
        return result;
    }

    @Override
    public T[] toArray(T[] holder) {
        if (holder == null) throw new NullPointerException();
        if (holder.length < size()) {
            holder = (T[]) java.lang.reflect.Array.newInstance(holder.getClass().getComponentType(), size());
        }
        for (int i = size() - 1, j = 0; i >= 0; i--, j++) {
            holder[j] = list.get(i);
        }
        if (holder.length > size()) {
            holder[size()] = null;
        }
        return holder;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return list.get(index--);
            }
        };
    }

    @Override
    public boolean stackOverflow() {
        return false;
    }

    @Override
    public boolean equals(Object thatStack) {
        if (this == thatStack) return true;
        if (thatStack == null || !(thatStack instanceof StackADT)) return false;
        StackADT<?> other = (StackADT<?>) thatStack;
        if (this.size() != other.size()) return false;
        Iterator<T> it1 = this.iterator();
        Iterator<?> it2 = other.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            if (!Objects.equals(it1.next(), it2.next())) return false;
        }
        return true;
    }
}
