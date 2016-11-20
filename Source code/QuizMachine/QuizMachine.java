package QuizMachine ;

public class QuizMachine {
 
	private static QuizMachine theMachine ;

	/*State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;*/
 
	/*State state = soldOutState;*/
	int countUsers = 0;
    
    int playerOneScore = 0;
    int playerTwoScore = 0;

	private QuizMachine() { }
 
	public static QuizMachine getInstance() {
		if (theMachine == null) {
			theMachine = new QuizMachine() ;
			theMachine.init() ;
			return theMachine ;
		}
		else {
			return theMachine ;
		}
	}
 
	private void init(  ) {
		countUsers = 0;
        playerOneScore = 0;
        playerTwoScore = 0;
               
	}

    public int setUserCount(){
        return ++this.countUsers;
    }

	public int getUserCount() {
		return this.countUsers;
	}

    public int  resetUserCount(){
        this.countUsers=0;
        return this.countUsers;
    }
    
    //---------For score keeping-------------------
    
    public void setScore(int playerId , int score)
    {
        if(playerId==0){
            playerOneScore = score;
        }
        if(playerId==1){
            playerTwoScore = score;
        }
    }
    
    public int getScore(int playerId)
    {    
        if(playerId==0){
            return playerTwoScore;
        }
        if(playerId==1){
            return playerOneScore;
        }
        return 0;
    }
    //---------------------------------------------
}
