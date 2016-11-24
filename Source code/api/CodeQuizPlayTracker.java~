package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import QuizMachine.QuizMachine ;

public class CodeQuizPlayTracker extends ServerResource {

    QuizMachine machine = QuizMachine.getInstance() ;
    

    @Get
    public Representation get() throws JSONException { //to start the game

       
        boolean endTheGame = machine.getUserGameEndStatus(); //If both the players are done
        JSONObject json = new JSONObject() ;

        json.put( "endTheGame", endTheGame ) ;
        return new JsonRepresentation ( json ); 
    }
    
    


    @Post
    public Representation post(JsonRepresentation jsonRep) { // add users and give them unique id

       
        int playerId = 0;
        JSONObject json = jsonRep.getJsonObject() ;
        playerId = Integer.parseInt(json.getString("playerId"));

         machine.setUserGameEndStatus(playerId);

        JSONObject response = new JSONObject() ;
        //String state = machine.getStateString() ;
        response.put( "playerId", playerId ) ;

        return new JsonRepresentation ( response ) ;
    }
}

