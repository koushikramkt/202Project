import greenfoot.*;
/**
 * Write a description of class QuizAdapter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuizAdapter  extends Adapter
{
     public QuizAdapter( QuizWorld q)
     {
         super(q);
        }
            @Override
           public void end() {
        quizWorld.clear();
        int total = quizWorld.wrong + quizWorld.correct;
        Text text = new Text("You scored: " + quizWorld.correct + "/" + total + ".");
        Text text2 = new Text("That's " + (int)((((double)quizWorld.correct)/total)*100) + "%!");
        quizWorld.addObject(text, 250, 50);
        quizWorld.addObject(text2, 250, 70);
       System.out.println("isMultiplayer"+quizWorld.isMultiplayer+ "For PlayerId: "+quizWorld.playerId +"correct:"+quizWorld.correct);

        if(quizWorld.isMultiplayer)
        {
            // call set score on server
            quizWorld.callSetScore(quizWorld.playerId , quizWorld.correct);
            quizWorld.callSetUserGameEndStatus();
            quizWorld.setWaitingState();
            while(true){
                System.out.println("Inside check while");
                
                if(quizWorld.callGetUserGameEndStatus())
                {
                    quizWorld.setGameEndState();
                    quizWorld.getGameState().execute();
                    break;
                }
                quizWorld.getGameState().execute();

            }
            Text results= new Text("Other player is still playing.");
            Text SecondPlayersScore= new Text("0");
            //get score on server

            if (quizWorld.correct==quizWorld.score[0]&&quizWorld.correct==quizWorld.score[1])
            {//  draw
                results = new Text("Draw! Well played");
                SecondPlayersScore = new Text("Opponent Scored: "+quizWorld.score[1]+"");
            }
             
            if(quizWorld.correct == quizWorld.score[0] && quizWorld.correct<quizWorld.score[1])
            {// lose
                results = new Text("Lose! Sorry but you came second!");
                SecondPlayersScore = new Text("Opponent Scored: "+quizWorld.score[1]+"");
            }
            
            if(quizWorld.correct == quizWorld.score[0] && quizWorld.correct>quizWorld.score[1])
            {//win
                results = new Text("Winner! That was really great!");
                SecondPlayersScore = new Text("Opponent Scored: "+quizWorld.score[1]+"");
            }
            
            if(quizWorld.correct < quizWorld.score[0] && quizWorld.correct==quizWorld.score[1])
            {// lose
                results = new Text("Lose! Sorry but you came second!");
                SecondPlayersScore = new Text("Opponent Scored: "+quizWorld.score[0]+"");
            }
            
            if(quizWorld.correct >quizWorld.score[0] && quizWorld.correct==quizWorld.score[1])
            {//win 
                results = new Text("Winner! That was really great!");
                SecondPlayersScore = new Text("Opponent Scored: "+quizWorld.score[0]+"");
            }
            
             
            quizWorld.addObject(results, 250, 90);
            quizWorld.addObject(SecondPlayersScore, 250, 120);
            
        }
        
         Greenfoot.stop();
    }
}
