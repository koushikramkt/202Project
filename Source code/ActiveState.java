/**
 * Write a description of class ActiveState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActiveState  extends State
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ActiveState
     */
    public ActiveState(QuizWorld q)
    {
        super(q);
    }

    @Override
    public void execute()
    {

         quizWorld.showQuestion();
         quizWorld.isMultiplayer = true;
    }
}
