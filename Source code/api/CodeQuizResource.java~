package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import QuizMachine.QuizMachine ;

public class CodeQuizResource extends ServerResource {

    QuizMachine machine = QuizMachine.getInstance() ;
    int maxNumberOfPlayer = 2;

    @Get
    public Representation get() throws JSONException { //to start the game

       /* String banner = machine.toString() ;
        int count = machine.getCount() ;
        String state = machine.getStateString() ;

        JSONObject json = new JSONObject() ;
        json.put( "banner", banner ) ;
        json.put( "count", count ) ;
        json.put( "state", state ) ;

        return new JsonRepresentation ( json ) ;*/
        
        int numberOfUser = machine.getUserCount();
        JSONObject json = new JSONObject() ;
        json.put( "numberOfUser", numberOfUser ) ;
        return new JsonRepresentation ( json ); 
    }
    
    


    @Post
    public Representation post(JsonRepresentation jsonRep) { // add users and give them unique id

       /* JSONObject json = jsonRep.getJsonObject() ;
        String action = json.getString("action") ;
        System.out.println( "action: " + action ) ;

        if ( action.equals( "insert-quarter") )
            machine.insertQuarter() ;
        if ( action.equals( "turn-crank") )
            machine.turnCrank();

        JSONObject response = new JSONObject() ;
        String state = machine.getStateString() ;
        response.put( "result", state ) ;

        return new JsonRepresentation ( response ) ;*/
        
        int playerId = 0;
        JSONObject json = jsonRep.getJsonObject() ;
        String action = json.getString("action");
        if(action.equals("NewUser"))
        { 
            if(machine.getUserCount() < maxNumberOfPlayer) 
            {
                playerId = machine.setUserCount();
            }
            
        }
        if(action.equals("KillUsers")){ //rest for new game
            playerId = machine.resetUserCount();
        }
        

        JSONObject response = new JSONObject() ;
        //String state = machine.getStateString() ;
        response.put( "playerId", playerId ) ;

        return new JsonRepresentation ( response ) ;
    }
}

