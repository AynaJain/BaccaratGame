
import javafx.event.ActionEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread{

    Socket socketClient;

	ObjectOutputStream out;
	ObjectInputStream in;
	int portNum;
	String serverIP;
	BaccaratInfo info;
//   private Consumer<Serializable> callback;  ////?????????/??

	public Client(BaccaratInfo info) throws Exception{

//		callback = call;
		portNum = info.portNumber;
		serverIP = info.ipAdd;
	}

		public void run() {

		try {
			socketClient= new Socket(serverIP,portNum);
	    	out = new ObjectOutputStream(socketClient.getOutputStream());
	    	in = new ObjectInputStream(socketClient.getInputStream());
	    	socketClient.setTcpNoDelay(true);
		}
		catch(Exception e) {}

		while(true) {

			try {
				BaccaratInfo receive = (BaccaratInfo)in.readObject();
				System.out.println(receive.getPortNumber());
				ClientPlayGUI.show_cards( receive);  // show cards and update GUI accordingly

			}
			catch(Exception e) {}
		}

    }

	public void send(BaccaratInfo info) {

		try {
			out.writeObject(info);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
