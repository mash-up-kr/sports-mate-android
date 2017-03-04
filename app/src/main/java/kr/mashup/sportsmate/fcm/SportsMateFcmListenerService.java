package kr.mashup.sportsmate.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import kr.mashup.sportsmate.util.SMLog;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SportsMateFcmListenerService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage message){
        SMLog.v("message received");
        String type = (String) message.getData().get("type");
        String body = message.getData().get("body");
        String bodyMessage = message.getNotification().getBody();

        SMLog.v(String.format("type : %s, body : %s, message : %s", type, body, bodyMessage));
    }

}
