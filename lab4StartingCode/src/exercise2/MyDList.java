package exercise2;

public class MyDList<E>
{
    private MyNode<E> head;
    private MyNode<E> tail;
    private int size;
    
    /**
     * Constructor for MyDList
     */
    public MyDList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Returns the head node of the list
     * @return the head node of the list
     */
    public MyNode<E> getHead()
    {
        return head;
    }
    
    /**
     * Adds an item to the beginning of the list
     * @param item the item to be added
     */
    public void addFirst(E item)
    {
        MyNode<E> newNode = new MyNode<>(item);
        
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        
        size++;
    }
    
    /**
     * Adds an item to the end of the list
     * @param item the item to be added
     */
    public void addLast(E item)
    {
        MyNode<E> newNode = new MyNode<>(item);
        
        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        
        size++;
    }
    
    /**
     * Removes and returns the first item in the list
     * @return the first item in the list
     * @throws RuntimeException if the list is empty
     */
    public E removeFirst()
    {
        if (isEmpty())
        {
            throw new RuntimeException("List is empty");
        }
        
        E element = head.getElement();
        
        if (head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.getNext();
            head.setPrev(null);
        }
        
        size--;
        return element;
    }
    
    /**
     * Removes and returns the last item in the list
     * @return the last item in the list
     * @throws RuntimeException if the list is empty
     */
    public E removeLast()
    {
        if (isEmpty())
        {
            throw new RuntimeException("List is empty");
        }
        
        E element = tail.getElement();
        
        if (head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        
        size--;
        return element;
    }
    
    /**
     * Returns the number of items in the list
     * @return the number of items in the list
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Returns whether the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
}