import io.rocketchat.common.data.model.ErrorObject;
import io.rocketchat.livechat.LiveChatAPI;
import io.rocketchat.livechat.callback.AuthListener;
import io.rocketchat.livechat.callback.ConnectListener;
import io.rocketchat.livechat.model.GuestObject;

/**
 * Created by sachin on 7/6/17.
 */

public class Main implements ConnectListener {

    private LiveChatAPI liveChat;
    private static String serverurl="wss://livechattest.rocket.chat/websocket";

    public void call(){
        liveChat=new LiveChatAPI(serverurl);
        liveChat.setReconnectionStrategy(null); //null means no reconnection after disconnect.
        liveChat.connect(this);
    }

    public static void main(String [] args){
        new Main().call();
    }

    @Override
    public void onConnect(String sessionID) {
        System.out.println("Connected to server");
    }

    @Override
    public void onDisconnect(boolean closedByServer) {
        System.out.println("Disconnected from server");
    }

    @Override
    public void onConnectError(Exception websocketException) {
        System.out.println("Connection error with server");
    }


//    @Override
//    public void onConnect(String sessionID) {
//        System.out.println("Connected to server");
//        liveChat.registerGuest("kunal","kunal@gmail.com",null,this);
//    }
//
//    @Override
//    public void onDisconnect(boolean closedByServer) {
//        System.out.println("Disconnected from server");
//    }
//
//    @Override
//    public void onConnectError(Exception websocketException) {
//        System.out.println("Got connect error with the server");
//    }
//
//    @Override
//    public void onRegister(GuestObject object, ErrorObject error) {
//        if (error==null) {
//            System.out.println("registration success");
//            liveChat.login(object.getToken(), this);
//        }else{
//            System.out.println("error occurred "+error);
//        }
//    }
//
//    @Override
//    public void onLogin(GuestObject object, ErrorObject error) {
//        if (error==null) {
//            System.out.println("login is successful");
//            room = liveChat.createRoom(object.getUserID(), object.getToken());
//            room.sendMessage("Hi there");
//        }else{
//            System.out.println("error occurred "+error);
//        }
//    }


}


/**
 * RocketChat server dummy user : {"userName":"guest-3829","roomId":"1hrjr4sruo9q1","userId":"9kAri3uXquAnkMeb4","visitorToken":"-57c7cb8f9c53963712368351705f4d9b","authToken":"qTcmnjIrfQB55bTd9GYhuGOOU63WY0-_afbCe8hyX_r"}
 */

/**
 * Localhost dummy user: {"userName":"guest-18","roomId":"u7xcgonkr7sh","userId":"rQ2EHbhjryZnqbZxC","visitorToken":"707d47ae407b3790465f61d28ee4c63d","authToken":"VYIvfsfIdBaOy8hdWLNmzsW0yVsKK4213edmoe52133"}
 */

