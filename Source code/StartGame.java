import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Button
{
    /**
     * Act - do whatever the StartGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            startAction();
           
        }
       
    }    
    
    public void startAction(){
        
        
       getWorldOfType(QuizWorld.class).setStartGame();
       
       //getWorld().addObject(new CopacabanaBrazil(),0,0);
    }
}
