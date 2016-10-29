import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Write a description of class MyWorld here.
 *  
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuizWorld extends World
{

    Button startgame;
    Button rules;
    private List<Question> questions;
    private int questionNum;
    private int wrong;
    private int correct;
    private How_to_play xrules;
    private int ruleNum;
    private List<Text> xtext;
 
       
    /**
     * Create all the questions and answers.
     * NOTE: This is not the best way to do this at all, in fact it's rather messy.
     * The "proper" way would've been to implement copy constructors instead of 
     * declaring lots of new variables, but I was just being lazy :-)
     */
    public QuizWorld()
    {
        super(900, 550, 1);
        changeGameLevel(new Easy());
        //questions = (new Easy()).getQuestion();
               
        xtext= new ArrayList<Text>();
        Text rule1=new Text("Single player mode");
        xtext.add(rule1);
        Text rule2=new Text("•	Player gets 1 point for each correct answer.");
        xtext.add(rule2);
        Text rule3=new Text("•	There are no negative points for an incorrect answer.");
        xtext.add(rule3);
        Text rule4=new Text("•	A player can view hints about the question anytime.");
        xtext.add(rule4);
        Text rule5=new Text(" ");
        xtext.add(rule5);
        Text rule6=new Text("Multiplayer mode");
        xtext.add(rule6);
        Text rule7=new Text("•	Players who selects the correct answer first gets 1 point.");
        xtext.add(rule7);
        Text rule8=new Text("•	A new question will be displayed to both the players, once any players answers correctly");
        xtext.add(rule8);
        Text rule9=new Text("once any players answers correctly");
        Text rule10=new Text("•	There are no negative points for an incorrect answer.");
        xtext.add(rule10);
        Text rule11=new Text("•	A player can anytime click on the hints button to get a hint.");
        xtext.add(rule11);
        Text rule12=new Text("•	At the end of each round the player who has more score is the winner.");
        xtext.add(rule12);
        xrules = new How_to_play(xtext);
       
        
       
        //super(1207  , 704   , 1);
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        prepare();        
    }
    
    public void changeGameLevel(GameLevel glGameLevel)
    {
        this.questions = glGameLevel.getQuestion();
    }

    public void prepare(){

        startgame = new StartGame();
        addObject(startgame, 1300,700);
        startgame.setLocation(812,174);

        rules = new Rules();
        addObject(rules,919,359);
        rules.setLocation(914,353);
        Title title = new Title();
        addObject(title,301,81);
        title.setLocation(262,101);

        rules.setLocation(814,239);
        rules.setLocation(673,240);
        startgame.setLocation(668,175);
        rules.setLocation(427,248);
        startgame.setLocation(428,188);
        title.setLocation(169,53);
        startgame.setLocation(484,112);
        rules.setLocation(484,176);
    }
    
  
    
    public void setStartGame(){ //@Rohan,  you can call your classes 
        setBackground(new GreenfootImage("QuestionsBackground.png"));
        removeObject(startgame);
        
        showQuestion();
        
       //System.out.println("Inside StartGame!");     
       
       //Clean 
       /*rules, startGame, title to empty the screen and the you can add your 
        * objects in this method.
        */
       
    }
    
    
    public void setInfoPage(){ //@Vedant,  you can call your classes 
        setBackground(new GreenfootImage("QuestionsBackground.png"));
        removeObject(rules);
       
        showrules(); 
        
       //System.out.println("Inside InfoPage!");       
       //Clean 
       /*rules, startGame, title to empty the screen and 
        * the you can add your objects in this method.
        */

    }
    
    private void showrules(){
        clear();
        addObject(xrules, 250, 50);
    }
    
    /**
     * Wipes the world and shows the question.
     */
    private void showQuestion() {
        clear();
        addObject(questions.get(questionNum), 250, 50);
    }
    
    /**
     * Clears the world of the previous question.
     */
    private void clear() {
        removeObjects(getObjects(null));
    }
    
    /**
     * Records an answer as correct and advances.
     */
    public void rightAnswer() {
        correct++;
        advance(true);
    }
    
    /**
     * Records an answer as incorrect and advances.
     */
    public void wrongAnswer() {
        wrong++;
        advance(false);
    }
    
    /**
     * Advances to the next question.
     */
    public void nextQuestion() {
        questionNum++;
        if(questionNum==questions.size()) {
            end();
        }
        else {
            showQuestion();
        }
    }
    
    /**
     * Called when the user has clicked on an answer.
     * @correct true if the answer is correct, false otherwise.
     */
    private void advance(boolean correct) {
        Question question = questions.get(questionNum);
        if(question.hasExplanation()) {
            clear();
            if(correct) {
                addObject(new Text("Correct!"), 250, 30);
            }
            else {
                addObject(new Text("Wrong!"), 250, 30);
            }
            addObject(question.getExplanation(), 250, 140);
            addObject(new Text("Press space to continue..."), 250, getHeight()-30);
        }
        else { 
            nextQuestion();
        }
    }
    
    /**
     * Called at the end of the game - displays the score.
     */
    private void end() {
        clear();
        int total = wrong+correct;
        Text text = new Text("You scored: " + correct + "/" + total + ".");
        Text text2 = new Text("That's " + (int)((((double)correct)/total)*100) + "%!");
        addObject(text, 250, 50);
        addObject(text2, 250, 70);
        Greenfoot.stop();
    }
    
    /**
     * Wraps a single string into an array of strings, maximum 60 characters.
     * Uses clever regular expression stuff that I was too lazy to work out
     * myself!
     * @author http://joust.kano.net/weblog/archives/000060.html
     */
    public static String[] wordWrap(String str) {
        Pattern wrapRE = Pattern.compile(".{0,59}(?:\\S(?:-| |$)|$)");
        List list = new LinkedList();
        Matcher m = wrapRE.matcher(str);
        while (m.find()) list.add(m.group());
        return (String[]) list.toArray(new String[list.size()]);
    }
    

    
}
