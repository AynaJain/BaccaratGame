
import java.util.ArrayList;
import java.util.Collections;

public class BaccaratDealer {
	ArrayList<Card> deck;

	BaccaratDealer()
	{
		deck = new ArrayList<Card>();
	}

	// Function to generate a new standard deck of 52 cards where each card is the instance of Card class
	// in ArrayList<Card> deck
	public void generateDeck()
	{
		// generate each suite
		//  generate diamonds
	     deck = new ArrayList<Card>();
//	     String TypeOfCard;
		for(int i = 1 ; i < 14 ; ++i)
		{
			Card diamondCard = new Card("Diamonds",i);
			deck.add(diamondCard);
			if(i == 1)
				diamondCard.typeOfCard = "AD";
			if(i==2)
				diamondCard.typeOfCard = "2D";
			if(i == 3)
				diamondCard.typeOfCard = "3D";
			if(i==4)
				diamondCard.typeOfCard = "4D";
			if(i == 5)
				diamondCard.typeOfCard = "5D";
			if(i==6)
				diamondCard.typeOfCard = "6D";
			if(i == 7)
				diamondCard.typeOfCard = "7D";
			if(i==8)
				diamondCard.typeOfCard = "8D";
			if(i==9)
				diamondCard.typeOfCard = "9D";
			if(i==10)
				diamondCard.typeOfCard = "10D";
			if(i==11)
				diamondCard.typeOfCard = "JD";
			if(i==12)
				diamondCard.typeOfCard = "QD";
			if(i==13)
				diamondCard.typeOfCard = "KD";


		}
		// generate hearts
		for(int i = 1 ; i < 14 ; ++i)
		{
			Card heartCard = new Card("Hearts",i);
			deck.add(heartCard);
			if(i == 1)
				heartCard.typeOfCard = "AH";
			if(i==2)
				heartCard.typeOfCard = "2H";
			if(i == 3)
				heartCard.typeOfCard = "3H";
			if(i==4)
				heartCard.typeOfCard = "4H";
			if(i == 5)
				heartCard.typeOfCard = "5H";
			if(i==6)
				heartCard.typeOfCard = "6H";
			if(i == 7)
				heartCard.typeOfCard = "7H";
			if(i==8)
				heartCard.typeOfCard = "8H";
			if(i==9)
				heartCard.typeOfCard = "9H";
			if(i==10)
				heartCard.typeOfCard = "10H";
			if(i==11)
				heartCard.typeOfCard = "JH";
			if(i==12)
				heartCard.typeOfCard = "QH";
			if(i==13)
				heartCard.typeOfCard = "KH";
		}
		// generate Spades
		for(int i = 1 ; i < 14 ; ++i)
		{
			Card spadeCard = new Card("Spades",i);
			deck.add(spadeCard);
			if(i == 1)
				spadeCard.typeOfCard = "AS";
			if(i==2)
				spadeCard.typeOfCard = "2S";
			if(i == 3)
				spadeCard.typeOfCard = "3S";
			if(i==4)
				spadeCard.typeOfCard = "4S";
			if(i == 5)
				spadeCard.typeOfCard = "5S";
			if(i==6)
				spadeCard.typeOfCard = "6S";
			if(i == 7)
				spadeCard.typeOfCard = "7S";
			if(i==8)
				spadeCard.typeOfCard = "8S";
			if(i==9)
				spadeCard.typeOfCard = "9S";
			if(i==10)
				spadeCard.typeOfCard = "10S";
			if(i==11)
				spadeCard.typeOfCard = "JS";
			if(i==12)
				spadeCard.typeOfCard = "QS";
			if(i==13)
				spadeCard.typeOfCard = "KS";
		}
		//generate Clubs
		for(int i = 1 ; i < 14 ; ++i)
		{
			Card clubCard = new Card("Clubs",i);
			deck.add(clubCard);
			if(i == 1)
				clubCard.typeOfCard = "AA";
			if(i==2)
				clubCard.typeOfCard = "2C";
			if(i == 3)
				clubCard.typeOfCard = "3C";
			if(i==4)
				clubCard.typeOfCard = "4C";
			if(i == 5)
				clubCard.typeOfCard = "5C";
			if(i==6)
				clubCard.typeOfCard = "6C";
			if(i == 7)
				clubCard.typeOfCard = "7C";
			if(i==8)
				clubCard.typeOfCard = "8C";
			if(i==9)
				clubCard.typeOfCard = "9C";
			if(i==10)
				clubCard.typeOfCard = "10C";
			if(i==11)
				clubCard.typeOfCard = "JC";
			if(i==12)
				clubCard.typeOfCard = "QC";
			if(i==13)
				clubCard.typeOfCard = "KC";
		}

	}


	// Function to deal two cards and return them in ArrayList <Card>
	public ArrayList<Card> dealHand()
	{

		ArrayList<Card> hand = new ArrayList<>();
		// we have to deal two cards... so after dealing those two remove them from the deck

		Card firstCard = deck.get(0); // get the first card from the deck
		Card secondCard = deck.get(1); // get the second card  form the deck
		hand.add(firstCard);       // add the first card to hand
		hand.add(secondCard);  // add the second card to the hand
		deck.remove(1);      // remove the first card from the deck
		deck.remove(0);      // remove the second card from the deck

		return hand;   // return the hand

	}

	//Function to draw a single card and return it
	public Card drawOne()
	{
		Card card1 = deck.get(0);   // get the top card
		deck.remove(0);    // remove the top card

		return card1;

	}

	// Function to create a new deck of 52 cards and shuffle it
	public void shuffleDeck()
	{
		Collections.shuffle(deck);
	}
	// Function to return the number of card in this deck at any given time
	public int deckSize()
	{
		return deck.size();

	}
}
