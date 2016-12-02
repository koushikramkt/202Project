/**
 * Write a description of class StateFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StateFactory  
{

    public StateFactory()
    {
    }

    public static State getState(String stateName , QuizWorld  q)
    {
        if("OnePlayerState".equals(stateName))
        {
            return new OnePlayerState(q);
        }
        else if("NoPlayerState".equals(stateName))
        {
            return new NoPlayerState(q);
        }
        else if("WaitingState".equals(stateName))
        {
            return new WaitingState(q);
        }
        else if("ActiveState".equals(stateName))
        {
            return new ActiveState(q);
        }
        else if("GameEndState".equals(stateName))
        {
            return new GameEndState(q);
        }
        return null;
    }
}
