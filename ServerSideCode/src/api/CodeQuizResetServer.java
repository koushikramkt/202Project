package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import QuizMachine.QuizMachine ;

public class CodeQuizResetServer extends ServerResource {

    QuizMachine machine = QuizMachine.getInstance() ;
    

    @Get
    public Representation get() throws JSONException { //to reset the server
     
        
        machine.resetTheQuizMachine();
        JSONObject json = new JSONObject() ;
        json.put( "Success", 1 ) ;
        return new JsonRepresentation ( json ); 
    }
    
    


}

