import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientGUI extends Application implements Initializable {

    public BaccaratInfo info;
    public int portNum;
    public TextField ip_address;
    public TextField port_id;
    public String get_server_ip;
    Client newClientConnect;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("client_GUI.fxml"));
        primaryStage.setTitle("Baccarat Client Side");
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void scenePlay(ActionEvent event) throws IOException {
        FXMLLoader newRoot = new FXMLLoader(getClass().getResource("clientPlay_GUI.fxml"));
        Parent root = newRoot.load();

        ClientPlayGUI clientControl=newRoot.getController();
        clientControl.getPrevInformation(portNum, get_server_ip, newClientConnect);
        Scene newScene = new Scene(root);
        Stage newStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        newStage.setScene(newScene);
        newStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void client_connected(ActionEvent actionEvent) throws Exception {
        info = new BaccaratInfo();
        portNum = Integer.parseInt(port_id.getText());
        System.out.println(portNum);
        get_server_ip= ip_address.getText();
        info.setPortNumber(portNum);
        info.setIpAddress(get_server_ip);
        newClientConnect = new Client(info);
        newClientConnect.start();
        scenePlay(actionEvent);
    }
}
