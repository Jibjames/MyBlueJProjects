import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * Write a description of class PopulationGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PopulationGenerator
{
    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;    
    // Lists of animals in the field.
    private List<Actor> actors;
    /**
     * Constructor for objects of class PopulationGenerator
     */
    public PopulationGenerator()
    {
        actors = new ArrayList<>();
    }

    /**
     * Randomly populate the field with foxes and rabbits.
     */
    public List<Actor> populate(Field field)
    {
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    actors.add(fox);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    actors.add(rabbit);
                }
                // else leave the location empty.
            }
        }
        return actors;
    }
}
