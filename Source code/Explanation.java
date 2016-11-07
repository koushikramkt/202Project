import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;


public class Explanation extends Actor
{
    private String[] text;

    /**
     * Create a new explanation, and wrap
     * it nicely.
     */
    public Explanation(String text) {
        this.text = QuizWorld.wordWrap(text);
    }
    
    /**
     * When the object is added to the world, draw it.
     */
    public void addedToWorld(World world) {
        draw();
    }
    
    /**
     * Draw on screen.
     */
    private void draw() {
        GreenfootImage image = new GreenfootImage(500, 200);
        image.setFont(new Font("SansSerif", Font.BOLD, 16));

        for(int i=0 ; i<text.length ; i++) {
            image.drawString(text[i], 10, 20+(i*20));
        }
        
        setImage(image);
    }
    
    /**
     * If space is pressed, advance to the next question.
     */
    public void act() {
        if(Greenfoot.isKeyDown("space")) {
            ((QuizWorld)getWorld()).nextQuestion();
        }
    }
}
