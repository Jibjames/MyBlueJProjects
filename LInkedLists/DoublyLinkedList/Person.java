import java.util.Random;

/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private String ID;
    
    /**
     * Constructor for objects of class Person
     */
    public Person(String fName, String lName)
    {
        firstName = fName;
        lastName = lName;
        //need 9 digit ID with exception handling
        this.ID = createID();
    }

    public String getName()
    {
        return firstName + " " + lastName;   
    }
    
    public String getID()
    {
        return ID;    
    }
    
    public String createID()
    {
        Random rand = new Random();
        String s = "";
        for(int i = 0; i < 9; i++) {
            s = s + String.valueOf(rand.nextInt(9));
        }
        return s;
        
    }
    
    @Override
    public String toString()
    {
        return this.getName() + " " + this.getID();    
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o){
            return true;
        }
        if(!(o instanceof Person)) {
            return false;
        }
        Person other = (Person) o;
        return this.getName().equals(other.getName()) &&
                this.getID().equals(other.getID());
    }
}
