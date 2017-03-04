package kr.mashup.sportsmate.model.command;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class PushTokenCommand {

    @SerializedName("userId")
    private int userId;


    @SerializedName("pushToken")
    private String pushToken;


    public PushTokenCommand(int userId, String pushToken) {
        this.userId = userId;
        this.pushToken = pushToken;
    }

    @Override
    public String toString() {
        return "PushTokenCommand{" +
                "userId=" + userId +
                ", pushToken='" + pushToken + '\'' +
                '}';
    }
}
