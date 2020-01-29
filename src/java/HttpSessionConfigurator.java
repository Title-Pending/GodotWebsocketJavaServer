/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 *
 * @author Unni Mana
 */
public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator {
    private HttpSession httpSession;
    @Override
    public void modifyHandshake(ServerEndpointConfig config, 
                                HandshakeRequest request, 
                                HandshakeResponse response) {
        
        HttpSession httpSession = (HttpSession)request.getHttpSession();
        System.out.println("*** HTTP Session " + httpSession);
        this.httpSession = httpSession;
    }

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        T endpoint = super.getEndpointInstance(endpointClass);
        if(endpoint instanceof GameServer) {
            GameServer gameServer = (GameServer)endpoint;
            gameServer.setHttpSession(httpSession);
        }    
        return super.getEndpointInstance(endpointClass); //To change body of generated methods, choose Tools | Templates.
    }
  
}
