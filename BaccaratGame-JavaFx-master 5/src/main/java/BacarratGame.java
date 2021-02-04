
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

class BaccaratGame {

	
	public ArrayList<Card> playerHand ;
	public ArrayList<Card> bankerHand ;
	
	public BaccaratDealer dealer ;
	public BaccaratGameLogic gameLogic = new BaccaratGameLogic();;
	public String bidOnPerson ;
	public double bet ;
	public double totalWinnings ;
	Card thirdPlayerCard=null;
	
	// constructor
	public BaccaratGame()
	{ playerHand = new ArrayList<>();
		bankerHand = new ArrayList<>();
		dealer = new BaccaratDealer();
		bet =0.0 ;
		bidOnPerson ="";
		totalWinnings = 0.0;
	}
	/* Function to determine if the user won or lost their bet and return the amount won or lost based
      on the current bet */
	public double evaluateWinnings()
	{
//		theDealer.generateDeck();
		if(gameLogic.evaluatePlayerDraw(playerHand) == true){
			thirdPlayerCard=dealer.drawOne();
			playerHand.add(thirdPlayerCard);
		}

		if(gameLogic.evaluateBankerDraw(bankerHand, thirdPlayerCard)==true){ // banker 3rd draw depends on the players third card
			bankerHand.add(dealer.drawOne());
		}
		if(gameLogic.whoWon(playerHand,bankerHand)==(bidOnPerson)){
			if(bidOnPerson=="Banker") {
				totalWinnings = totalWinnings + (bet*(0.95));
				return (bet*(0.95));
			}
			if(bidOnPerson=="Player"){
				totalWinnings = totalWinnings + bet;
				return bet;
			}
			if(bidOnPerson=="Tie"){
				totalWinnings = totalWinnings + (bet*(7));
				return (bet*(7));
			}
		}
		return bet;
	}

	
}
