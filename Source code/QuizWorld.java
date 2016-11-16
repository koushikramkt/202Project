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
        Text rule1=new Text("How to Play!!!");
        xtext.add(rule1);
        Text rule2=new Text("Single player mode");
        xtext.add(rule2);
        Text rule3=new Text("•  Player gets 1 point for each correct answer.");
        xtext.add(rule3);
        Text rule4=new Text("•  There are no negative points for an incorrect answer.");
        xtext.add(rule4);
        Text rule5=new Text("•  A player can view hints about the question anytime.");
        xtext.add(rule5);
        Text rule6=new Text(" ");
        xtext.add(rule6);
        Text rule7=new Text("Multiplayer mode");
        xtext.add(rule7);
        Text rule8=new Text("• Players who selects the correct answer first gets 1 point");
        xtext.add(rule8);
        Text rule9=new Text("• A new question will be displayed to both the players, once any players answers correctly");
        xtext.add(rule9);
        Text rule10=new Text("once any players answers correctly");
        Text rule11=new Text("• There are no negative points for an incorrect answer.");
        xtext.add(rule11);
        Text rule12=new Text("• A player can anytime click on the hints button to get a hint.");
        xtext.add(rule12);
        Text rule13=new Text("• At the end of each round the player who has more score ");
        xtext.add(rule13);
        Text rule14=new Text("  wins");
        xtext.add(rule14);
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
        
        EasyButton eb = new EasyButton();
        addObject(eb, 1300,700);
        eb.setLocation(484,112);

        MediumButton mb = new MediumButton();
        addObject(mb,919,359);
        mb.setLocation(484,212);
        
        HardButton hb = new HardButton();
        addObject(hb,919,359);
        hb.setLocation(484,312);
        
        /*startgame = new StartGame();
        addObject(startgame, 1300,700);
        startgame.setLocation(812,174);*/
        
        Multiplayer multi = new Multiplayer();
        addObject(multi, 919, 359);
        multi.setLocation(484, 370);
        
        rules = new Rules();
        addObject(rules,919,359);
        rules.setLocation(484,470);
        
        Title title = new Title();
        addObject(title,301,81);
        title.setLocation(262,101);

        //rules.setLocation(814,239);
        //rules.setLocation(673,240);
        //startgame.setLocation(668,175);
        //rules.setLocation(427,248);
        //startgame.setLocation(428,188);
        //title.setLocation(169,53);
        //startgame.setLocation(484,112);

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
  
    
    public void setStartGame(GameLevel gl){ //@Rohan,  you can call your classes 
        
        
        changeGameLevel(gl);
        
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
        Rules rules = new Rules();
        addObject(rules, 10, 10);
        rules.setLocation(120,50);
        
                Back_Button back_button = new Back_Button();
                addObject(back_button,10,10);
                back_button.setLocation(150,440);

    }
    
    public void setWaitPage(){
        setBackground(new GreenfootImage("QuizWorldVer2.jpg"));
        clear();
        
        Waiting waitmsg = new Waiting();
        addObject(waitmsg,50,50);
        waitmsg.setLocation(250,250);
  
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
        int total = 13;
            Text text = new Text("You scored: " + correct + "/" + total + ".");
            Text text2 = new Text("That's " + (int)((((double)this.correct)/total)*100) + "%!");
            addObject(text, 250, 500);
            addObject(text2, 250, 530);
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
                                    int total = 13;
            Text text = new Text("You scored: " + correct + "/" + total + ".");
                                Text text2 = new Text("That's " + (int)((((double)this.correct)/total)*100) + "%!");
                        addObject(text, 250, 500);
                                addObject(text2, 250, 530);
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
                        int total = 13;
                        addObject(new Text("Correct!"), 250, 30);
                        Text text = new Text("You scored: " + this.correct + "/" + total + ".");
                                Text text2 = new Text("That's " + (int)((((double)this.correct)/total)*100) + "%!");
                        addObject(text, 250, 500);
                                addObject(text2, 250, 530);
                        
            }
            else {
                                        int total = 13;
                addObject(new Text("Wrong!"), 250, 30);
                Text text = new Text("You scored: " + this.correct + "/" + total + ".");
                                                Text text2 = new Text("That's " + (int)((((double)this.correct)/total)*100) + "%!");
                                                                               
                        addObject(text, 250, 500);
                         addObject(text2, 250, 530);
            }
            addObject(question.getExplanation(), 250, 140);
            //addObject(new Text("Press space to continue..."), 250, getHeight()-30);
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
