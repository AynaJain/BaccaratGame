import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerGUI extends Application implements Initializable {
    ListView<String> listItems;
    public TextField serverPort_id;
    public int portNum;
    public Button serverConnect_id;
    Server serverConnect;
    public static void main(String[] args) {
//		// TODO Auto-generated method stub
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        listItems = new ListView<String>();
        Parent root = FXMLLoader.load(getClass().getResource("server_GUI.fxml"));
        primaryStage.setTitle("Baccarat");
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void changeScene(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("serverTable_GUI.fxml"));
        Scene newScene = new Scene(newRoot);
        Stage newStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // connect to server on clicking connect
    public void server_connected(ActionEvent actionEvent) throws IOException {
        portNum=Integer.parseInt(serverPort_id.getText());
        System.out.println(portNum);
        changeScene(actionEvent);
        serverConnect= new Server(portNum);
    }



}
