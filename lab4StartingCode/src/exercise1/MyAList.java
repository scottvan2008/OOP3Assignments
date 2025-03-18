package exercise1;

import java.util.ArrayList;
import java.util.Iterator;

public class MyAList<E> implements Iterable<E>
{
    private ArrayList<E> list;

    /**
     * Constructor for MyAList
     */
    public MyAList()
    {
        this.list = new ArrayList<E>();
    }
    
    /**
     * Adds the specified item to the end of the list
     * @param item the item to be added
     */
    public void add(E item)
    {
        list.add(item);
    }
    
    /**
     * Adds all items from the specified list to this list
     * @param items the list of items to be added
     */
    public void addAll(MyAList<E> items)
    {
        for (E item : items)
        {
            this.add(item);
        }
    }
    
    /**
     * Returns the item at the specified index
     * @param index the index of the item to be returned
     * @return the item at the specified index
     */
    public E get(int index)
    {
        return list.get(index);
    }
    
    /**
     * Removes the item at the specified index
     * @param index the index of the item to be removed
     */
    public void remove(int index)
    {
        list.remove(index);
    }
    
    /**
     * Sets the item at the specified index to the specified value
     * @param index the index of the item to be set
     * @param item the value to which the item will be set
     */
    public void set(int index, E item)
    {
        list.set(index, item);
    }
    
    /**
     * Returns the number of items in the list
     * @return the number of items in the list
     */
    public int size()
    {
        return list.size();
    }
    
    /**
     * Returns whether the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    
    /**
     * Returns an array containing all of the items in the list
     * @return an array containing all of the items in the list
     */
    public Object[] toArray()
    {
        return list.toArray();
    }
    
    /**
     * Removes all items from the list
     */
    public void clear()
    {
        list.clear();
    }

    @Override
    public Iterator<E> iterator()
    {
        return list.iterator();
    }
}