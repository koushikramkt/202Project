package api ;

import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class CodeQuizServer extends Application {

    public static void main(String[] args) throws Exception {
        Component server = new Component() ;
        server.getServers().add(Protocol.HTTP, 8080) ;
        server.getDefaultHost().attach(new CodeQuizServer()) ;
        server.start();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext()) ;
        router.attach("/codeQuiz", CodeQuizResource.class);
        router.attach("/codeQuizScore", CodeQuizScoreKeeper.class);
        router.attach("/codeQuizPlayTracker", CodeQuizPlayTracker.class);
	router.attach("/codeQuizResetServer", CodeQuizResetServer.class);
	
        return router;
    }
    
}
