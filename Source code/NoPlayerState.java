/**
 * Write a description of class NoPlayerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NoPlayerState  extends State
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class NoPlayerState
     */
    public NoPlayerState(QuizWorld q)
    {
        super(q);
    }
    
    @Override
    public void execute()
    {
            quizWorld.callRegisterPlayers();
        
        quizWorld.setWaitPage();
        quizWorld.setOnePlayerState();
    }

}   
