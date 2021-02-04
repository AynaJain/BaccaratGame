//import javafx.event.ActionEvent;
//import javafx.scene.control.Button;
//import javafx.scene.image.ImageView;
//
//public class ClientPlayGUI {
//    public Button player;
//    public Button banker;
//    public Button tie;
//    public ImageView playerIMG1;
//    public ImageView playerIMG2;
//    public ImageView playerIMG3;
//    public ImageView bankerIMG1;
//    public ImageView bankerIMG2;
//    public ImageView bankerIMG3;
//
//    public void exit_game(ActionEvent actionEvent) {
//        System.exit(0);
//    }
//
//
//
//    public void player_action(ActionEvent actionEvent) {
//        player.setStyle("-fx-background-color: red");
//        banker.setStyle(null);
//        tie.setStyle(null);
//    }
//
//    public void banker_action(ActionEvent actionEvent) {
//        banker.setStyle("-fx-background-color: red");
//        player.setStyle(null);
//        tie.setStyle(null);
//    }
//
//    public void tie_action(ActionEvent actionEvent) {
//        tie.setStyle("-fx-background-color: red");
//        player.setStyle(null);
//        banker.setStyle(null);
//    }
//}

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
//import BaccaratInfo;
//import Client;

public class ClientPlayGUI {
    public ToggleButton player;
    public ToggleButton banker;
    public ToggleButton tie;
    public TextField bidAmount;
//    public Button playButton;
    public String choice;
    public int bidAmount2;
    public Button play_B;
    //    public static BaccaratInfo info  = new BaccaratInfo(0);
    public Client clientConnection;
    public ImageView playerIMG1;
    public ImageView playerIMG2;
    public ImageView playerIMG3;
    public ImageView bankerIMG1;
    public ImageView bankerIMG2;
    public ImageView bankerIMG3;
    public ArrayList<Card> bHand;
    public ArrayList<Card> pHand;
    private static BaccaratInfo displayInfo;
public double total_winnings =0;
    public Label roundWin;
    public Label totalWin;

    String bidOnPerson = "";
    public  int port;
    public String ip;
//    public Client connection;

    public void exit_game(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void player_action(ActionEvent actionEvent) {
        choice = "P";
        player.setStyle("-fx-background-color: red");
        banker.setStyle(null);
        tie.setStyle(null);

    }

    public void banker_action(ActionEvent actionEvent) {
        choice = "B";
        banker.setStyle("-fx-background-color: red");
        tie.setStyle(null);
        player.setStyle(null);

    }

    public void tie_action(ActionEvent actionEvent) {
        choice = "T";
        tie.setStyle("-fx-background-color: red");
        banker.setStyle(null);
        player.setStyle(null);

    }

    public void play(ActionEvent actionEvent) throws Exception {
        bidAmount2  = Integer.parseInt(bidAmount.getText());


        if(player.isSelected())
            bidOnPerson="Player";
        if(banker.isSelected())
            bidOnPerson = "Banker";
        if(tie.isSelected())
            bidOnPerson = "Tie";

        BaccaratInfo game = new BaccaratInfo();
        game.setIpAddress(ip);
        game.setPortNumber(port);
        game.bidAmount = bidAmount2;
        game.bidOnPerson = bidOnPerson;

        clientConnection.send(game);

    }

    public void getPrevInformation(int portNum, String ip_address, Client connect){
        port=portNum;
        ip=ip_address;
        clientConnection=connect;
    }


   public static void show_cards( BaccaratInfo info)
    {
    displayInfo = info;
    }

    public void show_cards(ActionEvent actionEvent) {

        bHand= displayInfo.getBankerHand();
        pHand = displayInfo.getPlayerHand();
        System.out.println("Player's Hand");

        if(pHand.size() > 2)
        {
            playerIMG1.setImage(new Image("CardPng/"+ pHand.get(0).getImageString()));
            playerIMG2.setImage(new Image("CardPng/"+ pHand.get(1).getImageString()));
            playerIMG3.setImage(new Image("CardPng/"+ pHand.get(2).getImageString()));
        }
        else if(pHand.size() == 2)
        {
            playerIMG1.setImage(new Image("CardPng/"+ pHand.get(0).getImageString()));
            playerIMG2.setImage(new Image("CardPng/"+ pHand.get(1).getImageString()));
        }
        System.out.println("Bankers's Hand");

        if(bHand.size() > 2)
        {
            bankerIMG1.setImage(new Image("CardPng/"+ bHand.get(0).getImageString()));
            bankerIMG2.setImage(new Image("CardPng/"+ bHand.get(1).getImageString()));
            bankerIMG3.setImage(new Image("CardPng/"+ bHand.get(2).getImageString()));
        }
       else if(bHand.size() == 2)
        {
            bankerIMG1.setImage(new Image("CardPng/"+ bHand.get(0).getImageString()));
            bankerIMG2.setImage(new Image("CardPng/"+ bHand.get(1).getImageString()));
        }

//       String roundResult = "Player Total: "+ displayInfo.pHandTotal+ ". "+ "Banker Total: " + displayInfo.bHandTotal + '\n' +
//               "You bet: " + displayInfo.bidOnPerson + " " + displayInfo.wonPerson + " Wins";
//            roundWin.setText(roundResult);
//
//        String totalWins = Double.toString(displayInfo.result);
//            totalWin.setText(totalWins);

        String roundResult = "Player Total: "+ displayInfo.pHandTotal+ ". "+ "Banker Total: " + displayInfo.bHandTotal + '\n' +
                "You bet: " + displayInfo.bidOnPerson + " " + displayInfo.wonPerson + " Wins";
        roundWin.setText(roundResult);
        total_winnings += displayInfo.result;   // clear the current bet and play again
        String totalWins = Double.toString(total_winnings);

        totalWin.setText(totalWins);

    }
}



