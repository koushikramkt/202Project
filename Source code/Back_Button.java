import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back_Button extends Button
{
    /**
     * Act - do whatever the Back_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            startAction();
           
        }
        // Add your action code here.
    } 
    
        public void startAction(){
       getWorldOfType(QuizWorld.class);
       //getWorld().addObject(new CopacabanaBrazil(),0,0);
    }
}
