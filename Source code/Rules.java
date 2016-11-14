import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rules extends Button
{
    /**
     * Act - do whatever the Rules wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            startActivity();  
        }
    }
    
    public void startActivity()
    {
           getWorldOfType(QuizWorld.class).setInfoPage();
           //getWorld().addObject(new CopacabanaBrazil(),0,0);
       
    }    
}
