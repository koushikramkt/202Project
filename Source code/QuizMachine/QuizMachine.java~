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
    int []  scores = new int[2];
	boolean playerOneEnded = false;
	boolean playerTwoEnded = false; 
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

		scores[0]=0; //player one
		scores[1]=0;
               
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
    
    public void setScore(int playerId , int s)
    {
        /*if(playerId==0){
            playerOneScore = score;
        }
        if(playerId==1){
            playerTwoScore = score;
        }*/
	scores[playerId-1]=s;
    }
    
    public int[] getScore()
    {    
        /*if(playerId==0){
            return playerTwoScore;
        }
        if(playerId==1){
            return playerOneScore;
        }*/

		

        return scores;
    }
    //---------------------------------------------

    //-----------For Game ending, score display---
	


	public void setUserGameEndStatus(int playerId)
	{
		if(playerId==0)
		{
			playerOneEnded= true;
		}else if(playerId==1)
		{
			playerTwoEnded= true;
		}
				
	}
	public boolean getUserGameEndStatus()
	{
		if(playerOneEnded && playerTwoEnded)
		{
			
			return true;
		}
		return false;
	}



    //---------------------------------------------


   //------reset the machine after the game-----------

	public void resetTheQuizMachine()
	{
		playerOneEnded = false;
		playerTwoEnded = false; 
		countUsers = 0;
    		playerOneScore = 0;
    		playerTwoScore = 0;
		scores[0]=0;
		scores[1]=0;
	}
   //---------------------------------------------	
}
