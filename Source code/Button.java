import greenfoot.*; 
import greenfoot.core.WorldHandler;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import javax.swing.*;
import java.awt.Toolkit; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    Cursor defaultCursor;
    JPanel panel;

    public Button(){
    
        panel= WorldHandler.getInstance().getWorldCanvas();
        defaultCursor = panel.getCursor();
    }
    public void act() 
    {
        // Add your action code here.
        checkMouseClicked();
        checkMouseMoved();
    }    

    public void checkMouseMoved(){
     
        if(Greenfoot.mouseMoved(this)){
             changeCursor();
        }else{
            setDefaultCursor();
        }
    }
    public void checkMouseClicked ()
    { 
        if(Greenfoot.mouseClicked(this)){
            startAction();
           
        }
       

    }

    public void setDefaultCursor(){
        panel.setCursor(defaultCursor);
    }
    
    public void changeCursor(){

        GreenfootImage cursorImage = new GreenfootImage("images/hand_cursor.png");
        defaultCursor = panel.getCursor();
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage.getAwtImage(), new Point(0, 0), "Cursor");
        panel.setCursor(cursor);
    }
    //override this fucntion in all button subclasses to perform certain action 
    //based on button purpose
    public void startAction(){
        System.out.println(" button clicked");
    }
}
