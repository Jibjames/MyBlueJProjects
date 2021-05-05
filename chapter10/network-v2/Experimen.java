import java.util.*;

/**
 * Write a description of class Experimen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Experimen
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Experimen
     */
    public Experimen(int x)
    {
        // initialise instance variables
        x = 0;
    }

    public String toString()
    {
        return "String";
    }

    public static void main(String[] args)
    {
        ArrayList<Experimen> myList = new java.util.ArrayList<Experimen>();
        myList.add(new Experimen(1));

        for(Object st : myList)
        {
            System.out.println(st);
        }
    }

    
}
