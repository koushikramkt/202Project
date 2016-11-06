import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class How_to_play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class How_to_play extends Actor
{
    Button startGame;
    /**
     * Act - do whatever the How_to_play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private List<Text> text;
    
    public How_to_play(List<Text> rules){
        this.text=rules;
        
        
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }   
    
    public void addedToWorld(World world){
                    GreenfootImage image = new GreenfootImage(500, 100);
                    setImage(image);
                    System.out.println("I am inside");
                    
                    for(int i=0; i<text.size() ; i++){
                    getWorld().addObject(text.get(i), i+250, (i*20+100));
    }
}
}
