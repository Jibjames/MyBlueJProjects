

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class SimulatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SimulatorTest
{
    private Simulator testSimulator;

    /**
     * Default constructor for test class SimulatorTest
     */
    public SimulatorTest()
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
        testSimulator = new Simulator();
        testSimulator.simulate(100);
    }

    private boolean notDead() 
    {
        Field field = testSimulator.getField();
        List<Animal> animals = testSimulator.getAnimals();
       

        if (animals.stream().anyMatch(r -> r.isAlive() == false)) {
            return false;
        }
        return true;   
    }
    
    private boolean isConsistent() 
    {
        Field field = testSimulator.getField();
        List<Animal> animals = testSimulator.getAnimals();
          

        for(int i = 0; i <= field.getWidth(); i++) {
            for(int j = 0; j <= field.getDepth(); j++) {
                
                if(! animals.contains(field.getObjectAt(i, j))) {
                    return false;
                }
            } 
        }
        return true;   
    }
          
    @Test
    public void testConsistency() {
        testSimulator.simulateOneStep();
        assertEquals(true, isConsistent());
    }
    
    @Test
    public void testNotDead() {
        testSimulator.simulateOneStep();
        assertEquals(true, notDead());
    }


/**  
    public boolean testtest()
        {
            testSim.simulate(100);
            
            List<Fox> foxList = testSim.getFoxes();
            Field theField = testSim.getField();
            boolean areEqual;
        
            for(int i = 0; i < foxList.size(); i++) {
        
                if (foxList[0].getLocation() == theField.getObjectAt(foxList[0].getLocation())
                    return true;
                else    
                    return false;
            }   
        }
*/

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
