import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Answer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Answer extends Actor
{
   private String text;
    private boolean correct;

    /**
     * Create a new answer.
     */
    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }
    
    /**
     * When added to the world, draw.
     */
    public void addedToWorld(World world) {
        draw(Color.BLACK);
    }
    
    /**
     * Draw the answer to screen.
     */
    private void draw(Color colour) {
        GreenfootImage image = new GreenfootImage(500, 60);
        image.setColor(colour);
        image.setFont(new Font("SansSerif", Font.BOLD, 15));
        image.drawString("*" + text, 100, 60);
        
        setImage(image);
    }
    
    /**
     * Highlight when hovered over, and tell QuizWorld when
     * we've been clicked on along with whether we're right
     * or wrong.
     */
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            if(correct) {
                ((QuizWorld)getWorld()).rightAnswer();
            }
            else {
                ((QuizWorld)getWorld()).wrongAnswer();
            }
        }
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse==null) return;
        
        if(mouse.getActor()==this) {
            draw(Color.RED);
        }
        else {
            draw(Color.BLACK);
        }
    }  
}
