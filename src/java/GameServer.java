/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;

/**
 *
 * @author Unni Mana
 */
@ServerEndpoint(value = "/gameserver", configurator = HttpSessionConfigurator.class)
public class GameServer implements GameServerCallback{

    private final Map<String, Session>map = new ConcurrentHashMap<>();
 
    private List<Session>list = new ArrayList<>();
    /** HTTP session **/
    private HttpSession httpSession;
    
    private Session session;
    
    private DBManager dbManager = DBManager.getInstance();
    
    private static int count = 0;

    public GameServer() {
        System.out.println(" constructor was called...");
    }
    /**
     * 
     * @param httpSession 
     */
    public synchronized void  setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
        System.out.println(" HTTP Session 1" + httpSession);
        System.out.println(" count.. " + count);
//        if(count == 0)
//        dbManager.pollDB();
//        count++;
        
    }
    
  @OnMessage
  public void onMessage(String message, Session session) throws IOException, InterruptedException {
       System.out.println("Received: " + message);
       // session.getBasicRemote().sendText("This is the last server message");
       this.session = session;
       
  } 
          
  @OnOpen
  public void onOpen(Session session, EndpointConfig config) {
    System.out.println("Client connected");
    httpSession  = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
    this.session = session;
    list.add(session);
    dbManager.setGameServerCallback(this);
    File file = new File("u.txt");
    if(!file.exists()) {
        try {
            file.createNewFile();
            
        } catch (IOException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("joined".getBytes());
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    
        try {
            System.out.println("..Sending some response to client..");
            session.getBasicRemote().sendText("success");
        } catch (IOException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

  @OnClose
  public void onClose() {
    System.out.println("Connection closed");
  }

    @Override
    public void execute() {
        //for(Session s: list) {  
            //System.out.println(" ..... sending to all clients.....");
            if(session != null)  
                try {
                session.getBasicRemote().sendText("...Quiz Started..." + System.currentTimeMillis());
            } catch (IOException ex) {
                Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        // }
        
    }
  
  
}
