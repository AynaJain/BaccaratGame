import com.sun.javafx.charts.Legend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ServerTableGUI {
    private static BaccaratInfo displayInfo;
    private static int clientCount;
//    @FXML
//    private static Legend.LegendItem clients;
    public ListView showView;
    public ListView showView2;
    public Label clients;
    public double total_winnings;
    public void updateClientCount(int count) {
        clients.setText(Integer.toString(count));
    }

    public void exit_game(ActionEvent actionEvent) {

        System.exit(0);
    }

    // get the game info and set it to new instance of the baccarat game
    //used to display items in listview
    public static void getBacaInfoSet(BaccaratInfo info,int count)
    {
        displayInfo = info;
        clientCount = count;
    }
    public void show(ActionEvent actionEvent) throws IOException {

        //source :https://docs.oracle.com/javafx/2/ui_controls/list-view.htm
        String currBid = Double.toString(displayInfo.bidAmount);
        String amountWon = Double.toString(displayInfo.result);
        total_winnings += displayInfo.result;
        ObservableList<String> items = FXCollections.observableArrayList (
                "Bid Person: "+ displayInfo.bidOnPerson, "Bid Amount: "+ currBid,  "Who won: "+ displayInfo.wonPerson,
                "Amount won: " + total_winnings );
        showView.setItems(items);

    }

    public void show2(ActionEvent actionEvent) throws IOException{

        String currBid = Double.toString(displayInfo.bidAmount);
        String amountWon = Double.toString(displayInfo.result);
        total_winnings += displayInfo.result;
        ObservableList<String> items = FXCollections.observableArrayList (
                "Bid Person: "+ displayInfo.bidOnPerson, "Bid Amount: "+ currBid + "Who won: "+ displayInfo.wonPerson, "Amount won: " + total_winnings );
        showView2.setItems(items);
    }
}
