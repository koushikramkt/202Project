/**
 * Write a description of class GameEndState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameEndState  extends State
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class GameEndState
     */
    public GameEndState(QuizWorld q)
    {
        super(q);
    }

     @Override
    public void execute()
    {
        quizWorld.callGetScore();
    }
}
