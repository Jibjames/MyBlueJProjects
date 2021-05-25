import java.util.List;
import java.util.Random;

/**
 * Write a description of class Animal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Animal
{
    // A shared random number generator to control breeding.
    protected static final Random rand = Randomizer.getRandom();

    // instance variables - replace the example below with your own
    // The fox's age.
    private boolean alive;
    // The fox's position.
    private Location location;
    // The field occupied.
    private Field field;

    protected int age;
    /**
     * Constructor for objects of class Animal
     */
    public Animal(Field field, Location location)
    {
        this.age = 0;
        alive = true;
        this.field = field;
        setLocation(location);
    }

    abstract protected int getBreedingAge();

    abstract protected int getMaxAge();

    abstract protected int getMaxLitterSize();

    abstract protected double getBreedingProbability();
    
    //abstract protected void act(List<Actor> newActors);

    /**
     * Increase the age. This could result in the fox's death.
     */
    protected void incrementAge()
    {
        age++;
        if(age > getMaxAge()) {
            setDead();
        }
    }

    public boolean canBreed() 
    {
        return age >= getBreedingAge();
    }

    public boolean isAlive()
    {
        return alive;
    }

    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    protected Location getLocation()
    {
        return location;
    }
    
    protected Field getField()
    {
        return field;
    }
    
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    protected int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }

    /*protected void giveBirth(List<Animal> newAnimals)
    {
        // New aniamls are born into adjacent locations.
        // Get a list of adjacent free locations.
        
        List<Location> free = getField().getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            this young = new Object.this(false, getField(), loc);
            newAnimals.add(young);
        }
    }
    */
}
