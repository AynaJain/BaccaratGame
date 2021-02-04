
import com.sun.prism.shader.Texture_ImagePattern_AlphaTest_Loader;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Server {
	
	int count = 1;
//	private Consumer<Serializable> callback;
	
	ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	TheServer server;
	int portNumber;
	
	public Server(int portNum){
		
//		callback = call;
		server = new TheServer();
		server.start();
		portNumber = portNum;

	}


	public class TheServer extends Thread{

		public void run() {
			
			try(ServerSocket mysocket = new ServerSocket(portNumber))
			{
		    System.out.println("Server is waiting for a client!");
		    System.out.println("Server's port num is " + portNumber);
		  
			
		    while(true) {
		    	if(count > 2)
				{
					System.out.println("No more than 2 clients allowed");
					return;
				}
				ClientThread c = new ClientThread(mysocket.accept(), count);
//				callback.accept("client has connected to server: " + "client #" + count);
				System.out.println("Client has connected to the server " + count);
//				ServerTableGUI ser = new ServerTableGUI();
//				ser.updateClientCount(count);
//				BaccaratInfo i = new BaccaratInfo();
//				i.clientCount = count;

				clients.add(c);
				c.start();
				
				count++;
				
			    }
			}
				catch(Exception e) {}
			}
		}
	
	
	class ClientThread extends Thread{
		Socket connection;
		int count;
		ObjectInputStream in;
		ObjectOutputStream out;
		
		ClientThread(Socket s, int count){
			this.connection = s;
			this.count = count;	
		}
		
		public void updateClients(String message) {
			for(int i = 0; i < clients.size(); i++) {
				ClientThread t = clients.get(i);
				try {
				 t.out.writeObject(message);
				}
				catch(Exception e) {}
			}
		}
		
		public void run(){
				
			try {
				in = new ObjectInputStream(connection.getInputStream());
				out = new ObjectOutputStream(connection.getOutputStream());
				connection.setTcpNoDelay(true);	
			}
			catch(Exception e) {
				System.out.println("Streams not open");
			}
			
			updateClients("new client on server: client #"+count);
				
			 while(true) {
				    try{
						BaccaratInfo receive = (BaccaratInfo)in.readObject();

						playNow(receive);  // play the game

				    	}
				    catch(Exception e) {
//				    	callback.accept("OOOOPPs...Something wrong with the socket from client: " + count + "....closing down!");

				    	clients.remove(this);
				    	break;
				    }
				}
			}

		public void playNow(BaccaratInfo bacaInfo) {
			BaccaratGame game = new BaccaratGame();   // now play the game
			// generate deck first
			game.dealer.generateDeck();
			// then shuffle the deck
			game.dealer.shuffleDeck();

			game.bet=bacaInfo.bidAmount;   // get bid amount from the user
			game.bidOnPerson=bacaInfo.bidOnPerson;   // get bid person from the user

			game.bankerHand=game.dealer.dealHand(); // deal hand to banker
			game.playerHand=game.dealer.dealHand();   // deal hand to player
//
			game.totalWinnings = bacaInfo.totalWin;

			bacaInfo.result =  game.evaluateWinnings();
			bacaInfo.totalWin = game.totalWinnings;;

			bacaInfo.setPlayerHand(game.playerHand);
			bacaInfo.setBankerHand(game.bankerHand);

			int playerHandTotal = BaccaratGameLogic.handTotal(game.playerHand);
			int bankerHandTotal = BaccaratGameLogic.handTotal(game.bankerHand);
			bacaInfo.pHandTotal = playerHandTotal;   // change the player hand total to pass it to client
			bacaInfo.bHandTotal = bankerHandTotal;    // chane the banker hand total to pass it to client

			bacaInfo.wonPerson = game.gameLogic.whoWon(game.playerHand, game.bankerHand);  // change the wonPersron

			System.out.println(bacaInfo.wonPerson);
			ServerTableGUI.getBacaInfoSet(bacaInfo,count);   // update the gui through application thread in servertablegui
			send(bacaInfo);
		}

		public void send(BaccaratInfo info){
			try{ out.writeObject(info);}
			catch(IOException e) {e.printStackTrace();}
		}//end of ru
		
	}//end of client thread

}
