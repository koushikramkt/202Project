import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 550, 1);
        
        EasyButton eb = new EasyButton();
        addObject(eb, 1300,700);
        eb.setLocation(462,174);

        MediumButton mb = new MediumButton();
        addObject(mb,919,359);
        mb.setLocation(462,253);
        
        HardButton hb = new HardButton();
        addObject(hb,919,359);
        hb.setLocation(462,333);

    }
}
