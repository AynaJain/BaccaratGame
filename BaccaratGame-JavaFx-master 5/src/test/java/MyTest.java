import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class MyTest {

 static BaccaratGame game1;
 static BaccaratGame game2;

	@BeforeAll
	static void setup() {
		game1 =  new BaccaratGame();
		game2 = new BaccaratGame();
	}
	// testing generate deck
	@Test
	void test1() {
		game1.dealer.generateDeck();
		ArrayList<Card> deck1 = game1.dealer.deck;

		assertEquals(52,deck1.size(),"incorrect deck size");
	}

	// testing dealHand
	@Test
	void test2()
	{
		ArrayList<Card> deck2 = game1.dealer.dealHand();
		assertEquals(2,deck2.size(),"incorrect deck size");
	}

	// testing dealHand 2
	@Test
	void test3()
	{
	// after first dealing .. deck size should be 50
		ArrayList<Card> deck3 = game1.dealer.deck;
		assertEquals(50,deck3.size(),"incorrect deck size");
	}

	// testing dealHand 3
	@Test
	void test4()
	{
		// after second dealing deck size should be 48
		ArrayList<Card> deck2 = game1.dealer.dealHand();
		ArrayList<Card> deck3 = game1.dealer.deck;
		assertEquals(48,deck3.size(),"incorrect deck size");
	}
	// testing drawOne 1
	@Test
	void test5()
	{   // size decrease by 1 after drawing a card from the deck
		ArrayList<Card> deck3 = game1.dealer.deck;
		game1.dealer.drawOne();
		assertEquals(47,deck3.size(),"incorrect deck size");
	}

	@Test
	void TestWhoWon1(){
		BaccaratGameLogic checkLogic = new BaccaratGameLogic();
		ArrayList<Card> player = new ArrayList<>();
		ArrayList<Card> banker = new ArrayList<>();
		Card PC1=new Card("Diamond", 9);
		Card PC2= new Card("Hearts", 12);
		Card BC1=new Card("Spade",5);
		Card BC2= new Card("Diamond",12);

		player.add(PC1);
		player.add(PC2);
		banker.add(BC1);
		banker.add(BC2);

		assertEquals("Player", checkLogic.whoWon(player, banker));
	}

	@Test
	void TestWhoWon2(){
		BaccaratGameLogic checkLogic = new BaccaratGameLogic();
		ArrayList<Card> player = new ArrayList<>();
		ArrayList<Card> banker = new ArrayList<>();
		Card PC1=new Card("Clubs", 1);
		Card PC2= new Card("Hearts", 10);
		Card BC1=new Card("Spades",9);
		Card BC2= new Card("Clubs",12);

		player.add(PC1);
		player.add(PC2);
		banker.add(BC1);
		banker.add(BC2);

		assertEquals("Banker", checkLogic.whoWon(player, banker));
	}

	@Test
	void TestHandTotal1(){
		BaccaratGameLogic checkLogic = new BaccaratGameLogic();
		ArrayList<Card> banker = new ArrayList<>();
		Card BC1=new Card("Spades",9);
		Card BC2= new Card("Clubs",12);
		banker.add(BC1);
		banker.add(BC2);
		assertEquals(9,checkLogic.handTotal(banker));

	}

	@Test
	void TestHandTotal2(){
		BaccaratGameLogic checkLogic = new BaccaratGameLogic();
		ArrayList<Card> player = new ArrayList<>();
		Card PC1=new Card("Spades",2);
		Card PC2= new Card("Clubs",5);
		player.add(PC1);
		player.add(PC2);
		assertEquals(7,checkLogic.handTotal(player));

	}

	@Test
	void TestEvaluatePlayerDraw1(){
		BaccaratGameLogic checkLogic = new BaccaratGameLogic();
		ArrayList<Card> player = new ArrayList<>();
		Card PC1=new Card("Spades",2);
		Card PC2= new Card("Clubs",5);
		player.add(PC1);
		player.add(PC2);
		assertEquals(false,checkLogic.evaluatePlayerDraw(player));
	}

	@Test
	void TestEvaluatePlayerDraw2(){
		BaccaratGameLogic checkLogic = new BaccaratGameLogic();
		ArrayList<Card> player = new ArrayList<>();
		Card PC1=new Card("Spades",11);
		Card PC2= new Card("Clubs",12);
		player.add(PC1);
		player.add(PC2);
		assertEquals(true,checkLogic.evaluatePlayerDraw(player));
	}

	@Test
	void TestEvaluateBankerDraw1(){
		BaccaratGameLogic checkLogic = new BaccaratGameLogic();
		ArrayList<Card> banker = new ArrayList<>();
		Card BC1=new Card("Spades",5);
		Card BC2= new Card("Clubs",12);
		Card PC3= new Card("Hearts", 2);
		banker.add(BC1);
		banker.add(BC2);
		assertEquals(false,checkLogic.evaluateBankerDraw(banker, PC3));

	}

	@Test
	void TestEvaluateBankerDraw2(){
		BaccaratGameLogic checkLogic = new BaccaratGameLogic();
		ArrayList<Card> banker = new ArrayList<>();
		Card BC1=new Card("Diamonds",1);
		Card BC2= new Card("Clubs",4);
		Card PC3= new Card("Spades", 7);
		banker.add(BC1);
		banker.add(BC2);
		assertEquals(true,checkLogic.evaluateBankerDraw(banker, PC3));

	}


	@Test
	void TestDeckSize2(){
		BaccaratDealer dealer = new BaccaratDealer();
		assertEquals(0, dealer.deckSize());
	}

	@Test
	void TestEvaluateWinnings1(){
		BaccaratGame game=new BaccaratGame();
		game.totalWinnings=5000;
		game.bidOnPerson="";
		game.bet=1000;
		Card PC1=new Card("Diamonds", 2);
		Card PC2= new Card("Clubs", 5);
		Card BC1=new Card("Spades",8 );
		Card BC2=new Card("Hearts",1 );
		game.playerHand.add(PC1);
		game.playerHand.add(PC2);
		game.bankerHand.add(BC1);
		game.bankerHand.add(BC2);

		assertEquals(1000, game.evaluateWinnings());

	}

	@Test
	void TestEvaluateWinnings2(){
		BaccaratGame game=new BaccaratGame();
		game.totalWinnings=9000;
		game.bidOnPerson="";
		game.bet=5000;
		Card PC1=new Card("Spades", 3);
		Card PC2= new Card("Hearts", 3);
		Card BC1=new Card("Clubs",1 );
		Card BC2=new Card("Diamonds",7 );
		game.playerHand.add(PC1);
		game.playerHand.add(PC2);
		game.bankerHand.add(BC1);
		game.bankerHand.add(BC2);

		assertEquals(5000, game.evaluateWinnings());

	}

	@Test
	void TestEvaluateWinnings3(){
		BaccaratGame game=new BaccaratGame();
		game.totalWinnings=7892;
		game.bidOnPerson="";
		game.bet=586;
		Card PC1=new Card("Spades", 3);
		Card PC2= new Card("Hearts", 3);
		Card BC1=new Card("Clubs",1 );
		Card BC2=new Card("Diamonds",7 );
		game.playerHand.add(PC1);
		game.playerHand.add(PC2);
		game.bankerHand.add(BC1);
		game.bankerHand.add(BC2);

		assertEquals(586, game.evaluateWinnings());
	}

	@Test
	void TestHandTotal()
	{
		BaccaratGame game=new BaccaratGame();
		BaccaratGameLogic checkLogic=new BaccaratGameLogic();
		Card PC1=new Card("Spades", 3);
		Card PC2= new Card("Hearts", 3);
		game.playerHand.add(PC1);
		game.playerHand.add(PC2);
		assertEquals(6, checkLogic.handTotal(game.playerHand));

	}

	@Test
	void TestHandTotal3()
	{
		BaccaratGame game=new BaccaratGame();
		BaccaratGameLogic checkLogic=new BaccaratGameLogic();
		Card PC1=new Card("Spades", 6);
		Card PC2= new Card("Hearts", 8);
		game.playerHand.add(PC1);
		game.playerHand.add(PC2);
		assertEquals(4, checkLogic.handTotal(game.playerHand));

	}


}
