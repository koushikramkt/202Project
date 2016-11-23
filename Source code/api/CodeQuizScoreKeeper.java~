package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import QuizMachine.QuizMachine ;

public class CodeQuizScoreKeeper extends ServerResource {

    QuizMachine machine = QuizMachine.getInstance() ;
    int maxNumberOfPlayer = 2;

    @Get
    public Representation get() throws JSONException { //get user score
  
       JSONObject json = new JSONObject();
  
        int[] playerScores = machine.getScore();
  
        json.put( "PlayerOneScore", playerScores[0] ) ;
	json.put( "PlayerTwoScore", playerScores[1]  );
        return new JsonRepresentation ( json ); 
    }
    
    


    @Post
    public Representation post(JsonRepresentation jsonRep) { //  set User score 

        //int playerId = 0;
        JSONObject json = jsonRep.getJsonObject() ;
        int playerId = Integer.parseInt(json.getString("playerId"));
        int score = Integer.parseInt(json.getString("score"));
        
        machine.setScore(playerId,score);      
        

        JSONObject response = new JSONObject() ;
        //String state = machine.getStateString() ;
        response.put( "playerId", playerId ) ;

        return new JsonRepresentation ( response ) ;
    }
}

