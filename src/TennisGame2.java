
public class TennisGame2 implements TennisGame
{
    private static final int _FORTY = 3;
	private static final int _THIRTY = 2;
	private static final int _FIFTEEN = 1;
	private static final int _LOVE = 0;
	public int player1Points = 0;
    public int player2Points = 0;
    
    private String player1Name;
    private String player2Name;
        
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getLiteralScore(){
    	String literalScore = "";
    	if (isNormal())		           
		    literalScore = getLiteralForNormal();		
		if (isTie())		    
		    literalScore = getLiteralForTie();		
		if (isDeuce())
			literalScore = getLiteralForDeuce();
		if (isInAdvantageOver(player1Points,player2Points))		
		    literalScore = getLiteralForAdvantage();				
		if (isInAdvantageOver(player2Points,player1Points))		
		    literalScore = getLiteralForAdvantage1();		
		if (isWinnerOver( player1Points, player2Points))		
		    literalScore = getLiteralForWinner();		
		if (isWinnerOver( player2Points,player1Points))		
		    literalScore = getLiteralForWinner1();
		
      
        return literalScore;
    }

	private String getLiteralForWinner1() {
		return "Win for player2";
	}

	private String getLiteralForWinner() {
		return "Win for player1";
	}

	private String getLiteralForAdvantage1() {
		return "Advantage player2";
	}

	private String getLiteralForAdvantage() {
		return "Advantage player1";
	}

	private String getLiteralForDeuce() {
		return "Deuce";
	}

	private String getLiteralForTie() {
		return getLiteral(player1Points) + "-All";
	}

	private String getLiteralForNormal() {
		return getLiteral(player1Points) + "-" + getLiteral(player2Points);
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
		if (P1point==_LOVE)
			result = "Love";
		if (P1point==_FIFTEEN)
			result = "Fifteen";
		if (P1point==_THIRTY)
			result = "Thirty";
		if (P1point==_FORTY)
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