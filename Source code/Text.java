import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;


public class Text extends Actor
{
    private String text;
    
    /**
     * Create some text
     */
    public Text(String text) {
        this.text = text;
    }
    
    /**
     * When the text is added to the world, draw it on screen
     */
    public void addedToWorld(World world) {
        draw();
    }
    
    /**
     * Draw the text.
     */
    private void draw() {
        GreenfootImage image = new GreenfootImage(500, 30);
        image.setFont(new Font("SansSerif", Font.BOLD, 16));

        for(int i=0 ; i<text.length() ; i+=60) {
            int max = (i+60) > text.length() ? text.length() : i+60;
            image.drawString(text.substring(i,max), 10, 20+(i/3));
        }
        
        setImage(image);
    }
}
