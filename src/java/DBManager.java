/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.websocket.Session;
import model.GlmsQuizChannel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Unni Mana
 */
public class DBManager {
    private static DBManager dbManager;
    private ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
    private final int POLLING_DELAY = 1;
    private Session webSocketSession;
    private static boolean isPollingstarted = false;
   // private EntityManager em = QueryManager.getEntityManager();
    private static Connection con;
    private GameServerCallback gameServerCallback;
    
    private DBManager(){       
    }
    
    /**
     * set web socket session 
     * @param session 
     */
    public void setWebSocketSession(final Session session) {
        this.webSocketSession = session;
    } 
    
    /**
     * polls database periodically
     */
    public void pollDB(){
        if(dbManager == null) {
            throw new IllegalArgumentException("DB Manager is null...");
        }
        System.out.println(" polling started..." + isPollingstarted);
        if(isPollingstarted) return;
        
//        try{
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//                con = DriverManager.getConnection("jdbc:oracle:thin:@119.65.160.14:1521:xe", "edunavi", "edunavi1234@$@");
//                System.out.println(" con " + con);
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
        
        Runnable task1 = () -> {
            try {

  Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@119.65.160.14:1521:xe", "edunavi", "edunavi1234@$@");
                PreparedStatement pstmt=con.prepareStatement("SELECT QUIZSTARTTIME from Glms_Quiz_Channel where ISCLOSED <> 'Y'");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                oracle.sql.TIMESTAMP ts = (oracle.sql.TIMESTAMP)rs.getObject(1);
                long time = ts.dateValue().getTime();
                Date date = new Date();
                long cpuTime = date.getTime();
                if(cpuTime >= time) {
                    gameServerCallback.execute();
                    break;
                }
            }
            if(rs != null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(con !=null) con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

//System.out.println(" firing callback...");
            gameServerCallback.execute();
        };
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 0, POLLING_DELAY, TimeUnit.MINUTES);
        System.out.println("*** polling started ***");
        isPollingstarted = true;
    }
    
    
    
    public static DBManager getInstance(){
        if(dbManager == null) {
            dbManager = new DBManager();
//            try {
//                Class.forName("oracle.jdbc.driver.OracleDriver");
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        return dbManager;
    }
    
    /**
     * 
     * @param gameServerCallback 
     */
    public void setGameServerCallback(GameServerCallback gameServerCallback) {
        this.gameServerCallback = gameServerCallback;
    }
    
}
