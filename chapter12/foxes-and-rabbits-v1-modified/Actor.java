import java.util.List;

/**
 * Write a description of interface Actor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Actor
{
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     * @return   the result produced by sampleMethod
     */
    void act(List<Actor> newActors);
    
    boolean isAlive();
}
