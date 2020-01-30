/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Binu
 */
public class MonitorServlet extends HttpServlet {

    private ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
    private final int POLLING_DELAY = 1;
    private boolean isPollingstarted;
    private int timeToWait = 0;
    
    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //super.init(config); //To change body of generated methods, choose Tools | Templates.
        System.out.println("... init was called ...");
        pollDB();
    }
    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Database MonitorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Database MonitorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void pollDB(){
       
        System.out.println(" polling started..." + isPollingstarted);
        if(isPollingstarted) return;
        Runnable task1 = () -> {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("", "", "");
                PreparedStatement pstmt=con.prepareStatement("SELECT QUIZSTARTTIME from Glms_Quiz_Channel where ISCLOSED <> 'Y'");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                oracle.sql.TIMESTAMP ts = (oracle.sql.TIMESTAMP)rs.getObject(1);
                long time = ts.dateValue().getTime();
                Date date = new Date();
                long cpuTime = date.getTime();
                if(cpuTime >= time) {
                    System.out.println(" There are some quiz...");
                    if(rs != null) rs.close();
                    if(pstmt != null) rs.close();
                    if(con != null) con.close();
                    File file = new File("mon.txt");
                    if(!file.exists()) file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    String data = new String(time + "");
                    fos.write(data.getBytes());
                    fos.close();
                    ses.shutdown();
                    waitForPlayersJoined();
                    break;
                }
            }
            if(rs != null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(con !=null) con.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        };
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 0, POLLING_DELAY, TimeUnit.MINUTES);
        System.out.println("*** polling started ***");
        isPollingstarted = true;
        
    }
    
    private void waitForPlayersJoined() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Runnable task1 = () -> {
             String line = null;
             try {
                  File file = new File("u.txt");
                  if(file.exists()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                   while((line = reader.readLine())!= null) {
                   }
               }
                
                if(timeToWait>=30) {
                    if(line == null) {
                        if(!ses.isShutdown()) {
                            ses.shutdown();
                        }
                    }
                }

                if(line != null) { 
                    System.out.println(" Some players have joined...");
                    ses.shutdown();
                }
                
                timeToWait++;
                System.out.println(" Time elapased ..." + timeToWait);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MonitorServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        };
        final ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 0, POLLING_DELAY, TimeUnit.MINUTES);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
