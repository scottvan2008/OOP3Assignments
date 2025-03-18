package exercise2;

public class MyNode<E>
{
    private E element;
    private MyNode<E> next;
    private MyNode<E> prev;
    
    /**
     * Default constructor for MyNode
     */
    public MyNode()
    {
        this.element = null;
        this.next = null;
        this.prev = null;
    }
    
    /**
     * Constructor for MyNode with an element
     * @param element the element to be stored in this node
     */
    public MyNode(E element)
    {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
    
    /**
     * Returns the element stored in this node
     * @return the element stored in this node
     */
    public E getElement()
    {
        return element;
    }
    
    /**
     * Sets the element stored in this node
     * @param element the element to be stored in this node
     */
    public void setElement(E element)
    {
        this.element = element;
    }
    
    /**
     * Returns the next node
     * @return the next node
     */
    public MyNode<E> getNext()
    {
        return next;
    }
    
    /**
     * Sets the next node
     * @param next the next node
     */
    public void setNext(MyNode<E> next)
    {
        this.next = next;
    }
    
    /**
     * Returns the previous node
     * @return the previous node
     */
    public MyNode<E> getPrev()
    {
        return prev;
    }
    
    /**
     * Sets the previous node
     * @param prev the previous node
     */
    public void setPrev(MyNode<E> prev)
    {
        this.prev = prev;
    }
}