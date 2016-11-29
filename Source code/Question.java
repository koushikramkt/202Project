import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;

/**
 * A question the user is asked.
 * 
 * @author Enigma
 * @version 2016/10/20
 */
public class Question extends Actor {

    private String[] text;
    private List<Answer> answers;
    private Explanation explanation;
    
    /**
     * Create a new question.
     */
    public Question(String question, List<Answer> answers) {
        text = QuizWorld.wordWrap(question);
        this.answers = answers;
    }
    
    /**
     * Set the explanation for this question.
     */
    public void setExplanation(String explanation) {
        this.explanation = new Explanation(explanation);
    }
    
    /**
     * Get the explanation for this question.
     */
    public Explanation getExplanation() {
        return explanation;
    }
    
    /**
     * Determine whether this question has an explanation.
     */
    public boolean hasExplanation() {
        return explanation != null;
    }
    
    /**
     * Draw when added to the world.
     */
    public void addedToWorld(World world) {
        GreenfootImage image = new GreenfootImage(500, 100);
        GreenfootImage image2 = new GreenfootImage(500, 100);
           
        
        image2.drawRect(0,0,500,500);
        image2.fillRect(0,0,500,500);
        image2.setColor(Color.PINK);
        image2.setTransparency(100);
        setImage(image2);        
        
        
        image.setFont(new Font("SansSerif", Font.BOLD, 15));

        
        
        for(int i=0 ; i<text.length ; i++) {
           
            image.drawString(text[i], 10, 20+(i*25));
            image.setColor(Color.BLACK);
            
        }
        
        setImage(image);
        setLocation(250,100);
        //image.setColor(Color.RED);
        //image.fill();

     
        // change the this code to formast answers.
        for(int i=0 ; i<answers.size() ; i++) {
           


          
        if(i == 0)
        {

            getWorld().addObject(answers.get(i), 200, 200);
            System.out.println((text.length*50)+i*50);

        }
        
        else if (i==1){
         getWorld().addObject(answers.get(i), 200, 250);
            System.out.println((text.length*50)+i*50);
        }
        else if (i==2){ getWorld().addObject(answers.get(i), 500, 200);
            System.out.println((text.length*50)+i*50);

           
            //getWorld().addObject(answers.get(i), 200, (text.length*30)+i*80);

        }
        else{ getWorld().addObject(answers.get(i), 500, 250);
            System.out.println((text.length*50)+i*50);
        
        }
        
        
        }
    }

}
