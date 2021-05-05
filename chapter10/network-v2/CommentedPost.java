import java.util.*;

/**
 * Write a description of class CommentedPost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CommentedPost extends Post
{
    // instance variables - replace the example below with your own
    private int likes;
    private ArrayList<String> comments;
    /**
     * Constructor for objects of class CommentedPost
     */
    public CommentedPost(String author)
    {
        // initialise instance variables
        super(author);
        likes = 0;
        comments = new ArrayList<>();
    }

    public void addComment(String text)
    {
        comments.add(text);
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    @Override
    protected void display()
    {
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
        super.display(); 
    }
}
