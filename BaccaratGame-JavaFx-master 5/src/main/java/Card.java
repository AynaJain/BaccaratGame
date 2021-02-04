
import java.io.Serializable;

public class Card implements Serializable {
	String suite;
	int value;
	String typeOfCard;
	Card(String theSuite, int theValue)
	{
		this.value = theValue;
		this.suite = theSuite;
	}
	// for displaying photos of cards
	public String getImageString() {
		return typeOfCard + ".png";
	}
	public int getValue(){
		return value;
	}

}
