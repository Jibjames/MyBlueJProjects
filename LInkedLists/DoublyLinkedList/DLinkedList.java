import java.io.IOException;

/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DLinkedList<T>
{
    private Node<T> start;
    private Node<T> end;
    private int size;
    
    public DLinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    
    public boolean contains(T data) 
    {
        boolean bool = false;
        Node<T> temp = start;
        while (bool == false) {
            if (temp.getData().equals(data)) {
                bool = true;    
            }
            temp = temp.getNext();
        }
        return bool;
    }
    
    public void addFirst(T data)
    {
        if (size() == 0) {
            add(data);
        } else {
            Node<T> node = new Node(data);
            node.setNext(start);
            node.setPrev(end);
            
            start.setPrev(node);
            end.setNext(node);
            
            start = node;
            size += 1;
        }
    }
    
    public void add(T data)
    {
        if (size() == 0) {
            Node<T> node = new Node(data);
            start = node;
            end = node;
            
            node.setNext(start);
            node.setPrev(end);
            
            size += 1;
        } else {
            Node<T> node = new Node(data);
            node.setNext(start);
            node.setPrev(end);
            
            end.setNext(node);
            start.setPrev(node);
            
            end = node;
            size += 1;
        }
    }
    
    public void addEnd(T data)
    {
        add(data);    
    }
    
    //Adds between two nodes.  Adds at the Index given.
    public void addBetween(T data, int index) 
    {
        if (size() > 1 && index < size()) {
            Node<T> node = new Node(data);
            Node<T> prev = get(index - 1);
            Node<T> next = get(index);
            
            node.setNext(next);
            node.setPrev(prev);
            
            prev.setNext(node);
            next.setPrev(node);
            
            size += 1;
        }
    }
    
    public Node<T> get(int index)
    { 
        Node<T> temp = start;
        if (index < size() && index >= 0) 
        {   
            int count = 0;
            if (count < index) {
                temp = temp.getNext();
                count += 1;
            }
        }      
        return temp;
    } 
    
    public T getT(int index)
    {
        T data = null;
        Node<T> temp = start;
        if (index < size() && index >= 0) 
        {   
            int count = 0;
            if (count < index) {
                temp = temp.getNext();
                count += 1;
            }
            data = temp.getData();
        }  
        
        return data;
    }
    
    //removes the node at given index and returns it
    public T remove(int index)
    {
        T data = null;
        try {
            Node<T> node = get(index);
            data= node.getData();
            
            Node<T> prev = node.getPrev();
            Node<T> next = node.getNext();
            //remove node pointers
            node.setNext(null);
            node.setPrev(null);
            //set surrounding nodes to each other
            prev.setNext(next);
            next.setPrev(prev);
            size -= 1;
        }
        catch(Exception e) {
            System.out.println("Index does not exist");    
        }
        
        return data;   
    }
    
    public T removeFirst()
    {
        T data = null;
        if (size() > 0) {
            data = start.getData();
            Node<T> temp = start; //Why temp?
            start = start.getNext();
            start.setPrev(end);
            temp.setNext(null);
            size -= 1;
        }
        return data;   
    }
    
    public T removeLast()
    {
        T data = null;
        if (size() > 0) {
            data = end.getData();
            end = end.getPrev();
            end.setNext(start);
            size -= 1;
        }
        return data;   
    }
    
    //returns replaced data
    public T set(T data, int index) 
    {
        Node<T> node = get(index);
        T oldData = node.getData();
        node.setData(data);
        
        return oldData;
        /* Didn't have to do all that....just swap data
        Node<T> replace = null;
        if (size() > 0 && index < size()) {
            replace = get(index);
            Node<T> node = new Node(data);
            //set new node pointers
            node.setNext(replace.getNext());
            node.setPrev(replace.getPrev());
            //change next and prev to new node
            node.getNext().setPrev(node);
            node.getPrev().setNext(node);
            //remove old node pointers
            replace.setNext(null);
            replace.setPrev(null);
        }
        return replace;
        */
    }
    
    public Node<T> getStart()
    {
        return this.start;    
    }
    
    public int size() 
    {
        return size;   
    }
    
     public void clear()
    {
        start = null;
        end = null;
        size = 0; 
    }
}
