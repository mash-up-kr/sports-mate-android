package kr.mashup.sportsmate;

import com.orhanobut.hawk.Hawk;

import kr.mashup.sportsmate.model.UserModel;
import kr.mashup.sportsmate.util.Defines;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class UserManager {

    private volatile static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }

        return instance;
    }


    public boolean isSigned() {
        return Hawk.contains(Defines.HAWK_KEY_USER);
    }


    public void setMe(UserModel user) {
        Hawk.put(Defines.HAWK_KEY_USER, user);
    }



    public UserModel getMe() {
        return Hawk.get(Defines.HAWK_KEY_USER);
    }


    public String getPushToken() {
        return Hawk.get(Defines.HAWK_KEY_PUSH_TOKEN);
    }

}
