

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class NodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NodeTest
{
    Node<Integer> node0;
    Node<Integer> node1;
    Node<Integer> node2;
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        node0 = new Node(000);
        node1 = new Node(111);
        node2 = new Node(222);
        
        node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node0);
        
        node0.setPrev(node2);
        node1.setPrev(node0);
        node2.setPrev(node1);
    }
    
    @Test
    public void testGetNext()
    {
        node0.getNext().equals(node1);
    }

    @Test void testGetPrevious()
    {
        node2.getPrev().equals(node1);    
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
