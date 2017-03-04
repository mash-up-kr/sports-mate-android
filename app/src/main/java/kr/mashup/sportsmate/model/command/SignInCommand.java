package kr.mashup.sportsmate.model.command;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SignInCommand {

    @SerializedName("email")
    private String email;


    @SerializedName("password")
    private String password;

    public SignInCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignInCommand{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
