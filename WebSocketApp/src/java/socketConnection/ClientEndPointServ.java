package socketConnection;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.lifecycle.ClientWindow;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author jgutierrez
 */
@ClientEndpoint
public class ClientEndPointServ {

    private final String uir = "ws://127.0.0.1:8080/WebSocketApp/client";
    private Session session;

    public ClientEndPointServ() {

        try {

            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(ClientEndPointServ.class, new URI(uir));

        } catch (IOException | URISyntaxException | DeploymentException e) {
            e.printStackTrace();
        }

    }

    @OnMessage
    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
            System.out.println("socketConnection.ClientEndPointServ.onOpen() " + message);

        } catch (IOException ex) {

        }
    }

    @OnOpen
    public void onOpen(Session session) {
        try {
            session.getBasicRemote().sendText("Listening...");
            System.out.println("socketConnection.ClientEndPointServ.onOpen()");
        } catch (IOException ex) {
            Logger.getLogger(ClientEndPointServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
