package kr.mashup.sportsmate.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.orhanobut.hawk.Hawk;

import kr.mashup.sportsmate.util.Defines;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SportsMateInstanceIDListenerService extends FirebaseInstanceIdService {


    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is also called
     * when the InstanceID token is initially generated, so this is where
     * you retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Hawk.put(Defines.HAWK_KEY_PUSH_TOKEN, token);
    }

}
