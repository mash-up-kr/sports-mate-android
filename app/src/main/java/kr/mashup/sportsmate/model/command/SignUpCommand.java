package kr.mashup.sportsmate.model.command;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import kr.mashup.sportsmate.model.RegionModel;
import kr.mashup.sportsmate.model.SportsModel;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SignUpCommand {

    @SerializedName("email")
    private String email;


    @SerializedName("nickname")
    private String nickname;


    @SerializedName("password")
    private String password;


    @SerializedName("regions")
    private List<RegionModel> regions;


    @SerializedName("sports")
    private List<SportsModel> sports;


    public SignUpCommand(String email, String nickname, String password, List<RegionModel> regions, List<SportsModel> sports) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.regions = regions;
        this.sports = sports;
    }


    @Override
    public String toString() {
        return "SignUpCommand{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", regions=" + regions +
                ", sports=" + sports +
                '}';
    }
}
