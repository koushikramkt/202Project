import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Multiplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Multiplayer extends Button
{
    /**
     * Act - do whatever the Multiplayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            startAction();  
        }
    }    
    
    public void startAction(){
        QuizWorld q = (QuizWorld)getWorld();
         q.getGameState().execute();
        q.setOnePlayerState();
               
        q.getGameState().execute();
    }
}
