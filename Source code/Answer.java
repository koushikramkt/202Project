import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * An answer - several of these are displayed per question.
 * 
 * @author Michael Berry (mjrb4)
 * @version 07/05/09
 */
public class Answer extends Actor
{
    private String answerText;
    private boolean isCorrect;

    /**
     * Create a new answer.
     */
    public Answer(String text, boolean correct) {
        this.answerText = text;
        this.isCorrect = correct;
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
        GreenfootImage image = new GreenfootImage(500, 50);
        image.setColor(colour);
        image.setFont(new Font("SansSerif", Font.BOLD, 14));
        image.drawString(answerText, 10, 20);
        setImage(image);
    }
    
    /**
     * Highlight when hovered over, and tell QuizWorld when
     * we've been clicked on along with whether we're right
     * or wrong.
     */
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            if(isCorrect) {
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
