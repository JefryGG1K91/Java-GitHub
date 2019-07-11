/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketConnection;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author jgutierrez
 */
@ServerEndpoint(value = "/endpoint")
//@ClientEndpoint
public class WebSocketTest {

    public WebSocketTest() {

    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException, EncodeException {

        try {
//            session.getBasicRemote().sendText("this is the last message.");

            System.out.println("Recived: " + message);

//            session.getBasicRemote().sendText("This is the first server message");
            int sentMsg = 0;

            while (true) {

                Thread.sleep(5000);

                FileEntity fl = new FileEntity("1", "2", new Date(), (long) 3, "4");

                Gson gson = new Gson();
                
                session.getBasicRemote().sendObject(gson.toJson(fl));

                // session.getBasicRemote().sendText("Server count: " + sentMsg);
                sentMsg++;

            }

        } catch (IOException e) {
            Logger.getLogger(WebSocketTest.class.getName()).log(Level.SEVERE, null, e.getCause());
        }

    }

    @OnOpen
    public void onOpen(Session s) {
        System.out.println("socketConnection.WebSocketTest.onOpen()");
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("socketConnection.WebSocketTest.onError()" + t.getMessage());
        Logger.getLogger(WebSocketTest.class.getName()).log(Level.SEVERE, null, t.getMessage());
    }

    @OnClose
    public void onClose() {
        System.out.println("socketConnection.WebSocketTest.onClose()");
    }

}
