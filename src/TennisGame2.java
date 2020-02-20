
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    String score = "";
    
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        
    	if (isNormal())		           
		    score = getLiteral(player1Points) + "-" + getLiteral(player2Points);		
		if (isTie())
		{
		    score = getLiteral(player1Points);
		    score += "-All";
		}
		if (isDeuce())
			score = "Deuce";
		if (isInAdvantageOver(player1Points,player2Points))		
		    score = "Advantage player1";				
		if (isInAdvantageOver(player2Points,player1Points))		
		    score = "Advantage player2";		
		if (isWinnerOver( player1Points, player2Points))		
		    score = "Win for player1";		
		if (isWinnerOver( player2Points,player1Points))		
		    score = "Win for player2";
		
      
        return score;
    }
	
	private boolean isWinnerOver(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}


	private boolean isInAdvantageOver(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}
	
	private boolean isNormal() {
		return player1Points != player2Points;
	}

	private String getLiteral(int P1point) {
		String result="";
		if (P1point==0)
			result = "Love";
		if (P1point==1)
			result = "Fifteen";
		if (P1point==2)
			result = "Thirty";
		if (P1point==3)
			result = "Forty";
		return result;
	}

	
	private boolean isDeuce() {
		return player1Points==player2Points && player1Points>=3;
	}
	
	
	private boolean isTie() {
		return player1Points == player2Points && player1Points < 4;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}