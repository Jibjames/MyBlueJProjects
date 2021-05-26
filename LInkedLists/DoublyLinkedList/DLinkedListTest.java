
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DLinkedListTest
{
    DLinkedList<Person> Dlist;
    Person guy1, girl2, dude3;
    
    /**
     * Default constructor for test class DLinkedListTest
     */
    public DLinkedListTest()
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
        Dlist = new DLinkedList();
        guy1 = new Person("guy", "one");
        girl2 = new Person("girl", "two");
        dude3 = new Person("dude", "three");
        Dlist.add(guy1);
        Dlist.add(girl2);
        Dlist.add(dude3);
    }
    
    @Test 
    public void testAddandSize() 
    {
        assertTrue(Dlist.size() == 3);     
    }
    
    @Test void testAddFirst()
    {
        Person guyNew = new Person("guy", "new");
        Dlist.addFirst(guyNew);
        assertTrue(Dlist.getT(0).equals(guyNew));
    }
    
    @Test
    public void testGetT()
    {
       assertTrue(Dlist.getT(0).equals(guy1));
       assertTrue(Dlist.getT(1).equals(girl2)); 
    }
    
    @Test
    public void testRemove()
    {
        Dlist.remove(1);
        assertTrue(Dlist.getT(1).equals(dude3));
    }
    
    @Test
    public void testGet()
    {
        assertTrue(Dlist.get(1).equals(Dlist.getStart().getNext()));   
    }
    
    @Test
    public void testContains()
    {
        assertTrue(Dlist.contains(guy1)); 
        assertTrue(Dlist.contains(dude3));
    }
    @Test
    public void testSet()
    {
        Person guyNew = new Person("guyNew", "new");
        Dlist.set(guyNew, 1);
        assertTrue(Dlist.getT(1).equals(guyNew));    
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        Dlist = null;
    }
}
