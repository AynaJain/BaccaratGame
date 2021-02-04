
import java.util.ArrayList;

public class BaccaratGameLogic {


	// Function that takes in a hand and returns how many points is that hand worth
	public static int handTotal(ArrayList<Card> hand)
	{
		int total =0;
		int i=0;
		while(i<hand.size()){
			if(hand.get(i).value <10){
				total = total + hand.get(i).value;
			}
			if(total >=10){
				total=total-10; // this gives the second digit of the number greater than 10
			}
			++i;
		}
		return total;
	}

	// Function to evaluate two hands at the end of the game and return a string depending on the winner,
	//"Player","Banker" or "Draw"
	public static String whoWon(ArrayList<Card> hand1, ArrayList<Card>hand2)
	{
		
		if( handTotal(hand1) == handTotal(hand2))
			return "Draw";
		
		else if(handTotal(hand1)> handTotal(hand2))
			return "Player";
		else if(handTotal(hand1)< handTotal(hand2))
			return "Banker";

		else return "Invalid";  // something else
	}

	// Function to check if banker should be dealt a third card. Return true if required else false
	public static boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard)
	{
		int total_Banker = handTotal(hand);
		if(total_Banker <3) {
			return true;
		}

		else if(total_Banker >6){
			return false;
		}

		if(total_Banker<6 && (playerCard==null ))
			return true;

		// conditions for third card draw for banker
		if((playerCard.value ==0 && total_Banker<4) || (playerCard.value ==1 && total_Banker<4) || (playerCard.value ==9 && total_Banker<4)
				|| (playerCard.value == 2 && total_Banker <5) || (playerCard.value == 3 && total_Banker <5)
				|| (playerCard.value==4 && total_Banker<6) || (playerCard.value==5 && total_Banker<6)
				|| (playerCard.value==6 && total_Banker<7) || (playerCard.value==7 && total_Banker<7)
				|| (playerCard.value==8 && total_Banker<3)){
			return true;
		}
		return false;
	}

	// Function to check is player should be dealt a third card. Return true if required else false
	public static boolean evaluatePlayerDraw(ArrayList<Card> hand)
	{
		if(handTotal(hand)<6){
			return true;
		}
		else{
			return false;
		}
		
	}
	
}
	