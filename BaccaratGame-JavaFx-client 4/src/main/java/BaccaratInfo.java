

import java.io.Serializable;
import java.util.ArrayList;

public class BaccaratInfo implements Serializable {

	public String ipAdd;
	public int portNumber;
	public String bidOnPerson;   // user input bid on person
	public double bidAmount;       // user input of bid amount
	public double result;
	public String wonPerson;
	public String cardType;
	public int pHandTotal;
	public int bHandTotal;
	public double totalWin;

	String roundWin;

	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;

	public void setPlayerHand(ArrayList<Card> playerHand)
	{
		this.playerHand = playerHand;
	}

	public void setBankerHand(ArrayList<Card> bankerHand)
	{
		this.bankerHand = bankerHand;
	}
	public ArrayList<Card> getPlayerHand()
	{
		return playerHand;
	}
	public ArrayList<Card> getBankerHand()
	{
		return bankerHand;
	}

	public void setPortNumber(int portNum) {

		portNumber = portNum;
	}
	public void setIpAddress(String ipAdd) {

		this.ipAdd = ipAdd;
	}

	public int getPortNumber() {
		return  portNumber;
	}
	public String getIpAddress() {
		return ipAdd;
	}

	public BaccaratInfo()
	{
		bidOnPerson = "";
		bidAmount = 0.0;
		result = 0.0;
		wonPerson = "";
		cardType="";
		roundWin = "";
		pHandTotal = 0 ;
		bHandTotal = 0;
		totalWin = 0.0 ;
	}



}

