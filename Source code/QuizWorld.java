import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
 
import org.json.JSONObject;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;
import java.io.IOException;
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
    public int questionNum;
    public int wrong;
    public int correct;
    public How_to_play xrules;
    public int ruleNum;
    public List<Text> xtext;
 
    private String URLplayers = "http://35.165.108.247:8080/codeQuiz" ;
    private String URLscore = "http://35.165.108.247:8080/codeQuizScore" ;
    private String URLplayTracker= "http://35.165.108.247:8080/codeQuizPlayTracker";
    private String URLresetServer= "http://35.165.108.247:8080/codeQuizResetServer";
    ClientResource clientPlayers ; 
    ClientResource clientScoreKeeper ;
    ClientResource clientPlayTracker;
    ClientResource clientResetServer;
    public boolean isMultiplayer=false;
    int playerId;
    int [] score=new int[2];
    
    private State gameState = null;
    private State noPlayerState = StateFactory.getState("NoPlayerState",this);
    private State onePlayerState = StateFactory.getState("OnePlayerState",this);
    private State activeState = StateFactory.getState("ActiveState",this);
    private State waitingState = StateFactory.getState("WaitingState",this);
    private State gameEndState = StateFactory.getState("GameEndState", this);
    
    private Adapter adapter = new QuizAdapter(this);
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
        /*------------test api calls------*/
        /*callRegisterPlayers();
        callRegisterPlayers();
        callGetNumberOfPlayers();
        callSetScore();
        callGetScore();*/
        /*----------Test Ended------*/
        callGetCleanServer();

        
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

        title.setLocation(164,35);
        eb.setLocation(510,64);
        mb.setLocation(574,196);
        rules.setLocation(269,472);
        multi.setLocation(737,469);
        hb.setLocation(532,351);
        mb.setLocation(587,212);
        eb.setLocation(523,69);
        title.setLocation(164,75);
        
        setNoPlayerState();
        
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
        
        if(gl!= null && gl instanceof multiplePlayerQuestions)
        {
            gameState.execute();
        }
        
        else
        {
        showQuestion();
        }
        
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
        isMultiplayer=true;
        
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
    public void showQuestion() {
        clear();
       
        addObject(questions.get(questionNum), 250, 50);
        int total = 5;
            Text text = new Text("You scored: " + correct + "/" + total + ".");
            Text text2 = new Text("That's " + (int)((((double)this.correct)/total)*100) + "%!");
            addObject(text, 250, 500);
            addObject(text2, 250, 530);
    }
    
    /**
     * Clears the world of the previous question.
     */
    public void clear() {
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
           adapter.end();
        }
        else {
            showQuestion();
                                    int total = 5;
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
                        int total = 5;
                        addObject(new Text("Correct!"), 250, 30);
                        Text text = new Text("You scored: " + this.correct + "/" + total + ".");
                                Text text2 = new Text("That's " + (int)((((double)this.correct)/total)*100) + "%!");
                        addObject(text, 250, 500);
                                addObject(text2, 250, 530);
                        
            }
            else {
                                        int total = 5;
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
    public void end() {
        clear();
        int total = wrong+correct;
        Text text = new Text("You scored: " + correct + "/" + total + ".");
        Text text2 = new Text("That's " + (int)((((double)correct)/total)*100) + "%!");
        addObject(text, 250, 50);
        addObject(text2, 250, 70);
       System.out.println("isMultiplayer"+isMultiplayer+ "For PlayerId: "+playerId +"correct :"+correct);
        //isMultiplayer=true;
        if(isMultiplayer)
        {
            // call set score on server
            callSetScore(playerId , correct);
            callSetUserGameEndStatus();
            setWaitingState();
            while(true){
                System.out.println("Inside check while");
                
                if(callGetUserGameEndStatus())
                {
                    setGameEndState();
                    gameState.execute();
                    break;
                }
                gameState.execute();

            }
            Text results= new Text("Other player is still playing.");
            Text SecondPlayersScore= new Text("0");
            //get score on server

            if (correct==score[0]&&correct==score[1])
            {//  draw
                results = new Text("Draw! Well played");
                SecondPlayersScore = new Text("Opponent Scored: "+score[1]+"");
            }
             
            if(correct == score[0] && correct<score[1])
            {// lose
                results = new Text("Lose! Sorry but you came second!");
                SecondPlayersScore = new Text("Opponent Scored: "+score[1]+"");
            }
            
            if(correct == score[0] && correct>score[1])
            {//win
                results = new Text("Winner! That was really great!");
                SecondPlayersScore = new Text("Opponent Scored: "+score[1]+"");
            }
            
            if(correct < score[0] && correct==score[1])
            {// lose
                results = new Text("Lose! Sorry but you came second!");
                SecondPlayersScore = new Text("Opponent Scored: "+score[0]+"");
            }
            
            if(correct >score[0] && correct==score[1])
            {//win 
                results = new Text("Winner! That was really great!");
                SecondPlayersScore = new Text("Opponent Scored: "+score[0]+"");
            }
            
             
            addObject(results, 250, 90);
            addObject(SecondPlayersScore, 250, 120);
            
        }
        
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
       
    public void callRegisterPlayers()//set codeQuiz
    {
        //params
        //{"action":"NewUser"}
        try{
            clientPlayers = new ClientResource( URLplayers ); 
            JSONObject json = new JSONObject();
            json.put("action", "NewUser");
            Representation result_string = clientPlayers.post(new JsonRepresentation(json), MediaType.APPLICATION_JSON);
            JSONObject jsonreply = new JSONObject(result_string.getText());
            playerId = ((int)jsonreply.get("playerId"));
            System.out.println("callRegisterPlayers- New playerId:"+playerId);
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //reply
       /* {"playerId": 1}*/
    }
    public int callGetNumberOfPlayers()//get codeQuiz
    {
        int numberOfUsers = 0;
         try{
            clientPlayers = new ClientResource( URLplayers );
            Representation result_string = clientPlayers.get();
            JSONObject jsonreply = new JSONObject(result_string.getText());
            numberOfUsers = (int) jsonreply.get("numberOfUser");
            System.out.println("callGetNumberOfPlayers- numberOfUsers:"+numberOfUsers);
           
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return numberOfUsers;
        //reply
        //{ "numberOfUser": 2}    start game only when count is 2
        
    }
    public void callSetScore(int playerId,int score) //set codeQuizScore
    {
        //params
        //{"playerId":"0","score":"100"} or 
        //{"playerId":"1","score":"200"}
        
        
        try{
        /*int playerId=0;
        int score =100;*/
        System.out.println("Inside callSetScore for playerId: "+playerId+" with score: "+score); 
        clientScoreKeeper =new ClientResource( URLscore ); 
        JSONObject json = new JSONObject();
        json.put("playerId", playerId+"");
        json.put("score", score+"");
        
        Representation result_string = clientScoreKeeper.post(new JsonRepresentation(json), MediaType.APPLICATION_JSON);
        JSONObject jsonreply = new JSONObject(result_string.getText());
        int playerIdFromReply = (int)jsonreply.get("playerId");
        System.out.println("callSetScore- score is set for playerId:"+playerIdFromReply);
         } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //reply
        //{"playerId":0}
    }
    public void callGetScore() //get codeQuizScore
    {
         try{
            clientScoreKeeper = new ClientResource( URLscore );
            Representation result_string = clientScoreKeeper.get();
            JSONObject jsonreply = new JSONObject(result_string.getText());
            int playerTwoScore = (int) jsonreply.get("PlayerTwoScore");
            int playerOneScore = (int) jsonreply.get("PlayerOneScore");
            score[0] = playerOneScore;
            score[1] = playerTwoScore;
            System.out.println("callGetScore- playerTwoScore:"+playerTwoScore +"  playerOneScore:"+playerOneScore);
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //reply
         //{"PlayerTwoScore":0,"PlayerOneScore":0}
    }
    
    public boolean callGetUserGameEndStatus() //get codeQuizScore
    {
        
        System.out.println("Inside callGetUserGameEndStatus");
        boolean endTheGame = false;
         try{
            clientPlayTracker = new ClientResource( URLplayTracker );
            Representation result_string = clientPlayTracker.get();
            JSONObject jsonreply = new JSONObject(result_string.getText());
            endTheGame = (boolean) jsonreply.get("endTheGame");
            System.out.println("callGetScore- EndTheGame: "+endTheGame);         
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return endTheGame;
        //reply
         //{"endTheGame":false}
    }
    
    public void callSetUserGameEndStatus() //get codeQuizScore
    {//{"playerId":"1"}
         try{

        clientPlayTracker =new ClientResource( URLplayTracker ); 
        JSONObject json = new JSONObject();
        json.put("playerId", (playerId-1)+"");
        
        Representation result_string = clientPlayTracker.post(new JsonRepresentation(json), MediaType.APPLICATION_JSON);
        JSONObject jsonreply = new JSONObject(result_string.getText());
        int playerIdFromReply = (int)jsonreply.get("playerId");
        System.out.println("GameEndStatus- Game ended for playerId:"+playerIdFromReply);
         } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //reply
         //{"playerId":1}
    }
    
    
    
    public void callGetCleanServer() //get codeQuizScore
    {
        
        System.out.println("Inside callGetCleanServer");
        int success = 0;
         try{
            clientResetServer = new ClientResource( URLresetServer );
            Representation result_string = clientResetServer.get();
            JSONObject jsonreply = new JSONObject(result_string.getText());
            success = (int)jsonreply.get("Success");
            System.out.println("callGetScore- Success: "+success);         
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //reply
         //{"Success":1}
    }
    
    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }
    


    public void setNoPlayerState() {
        this.gameState = noPlayerState;
    }
    


    public void setOnePlayerState() {
        this.gameState = onePlayerState;
    }
    public void setActiveState() {
        this.gameState = activeState;
    }
    
        public void setWaitingState() {
        this.gameState = waitingState;
    }
    
        public void setGameEndState() {
        this.gameState = gameEndState;
    }


    
}
