/**
 * Write a description of class WaitingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaitingState  extends State
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class WaitingState
     */
    public WaitingState(QuizWorld q)
    {
        super(q);
    }

   @Override
    public void execute()
    {
                        try{
                Thread.sleep(1000);
                }catch(Exception e){e.printStackTrace();}
    }
}
