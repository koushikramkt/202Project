import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Waiting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waiting extends Button
{
    /**
     * Act - do whatever the Waiting wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //getWorldOfType(QuizWorld.class).setStartGame(new Easy());
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            startAction();  
        }
    }  
    
    public void startAction(){
        int numberOfPlayers = getWorldOfType(QuizWorld.class).callGetNumberOfPlayers();
        System.out.println("From Waiting: Number of players (Need 2 player to play the game) :"+numberOfPlayers);
        if(numberOfPlayers==2)
        {
                    QuizWorld q = (QuizWorld)getWorld();
                    q.setActiveState();
                   getWorldOfType(QuizWorld.class).setStartGame(new multiplePlayerQuestions());
            
        }
    }
}
