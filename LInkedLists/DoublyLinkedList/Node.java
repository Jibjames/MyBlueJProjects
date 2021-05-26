
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node<T>
{
    // instance variables - replace the example below with your own
    private T data;
    private Node<T> next;
    private Node<T> prev;
    /**
     * Constructor for objects of class Node
     */
    public Node(T data)
    {
        this.data = data;
        next = null;
    }
    
    public void setNext(Node<T> node)
    {
        this.next = node;
    }
    
    public void setPrev(Node<T> node)
    {
        this.prev = node;   
    }
    
    public T getData()
    {
        return data;
    }
    
    public void setData(T data)
    {
        this.data = data;   
    }
    
    public Node<T> getNext()
    {
        return next;
    }
    
    public Node<T> getPrev()
    {
        return prev;
    }
}
