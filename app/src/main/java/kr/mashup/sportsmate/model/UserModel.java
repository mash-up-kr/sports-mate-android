package kr.mashup.sportsmate.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class UserModel {

    @SerializedName("id")
    private int id;


    @SerializedName("nickname")
    private String nickname;


    @SerializedName("email")
    private String email;


    @SerializedName("regions")
    private List<RegionModel> regions;


    @SerializedName("sports")
    private List<SportsModel> sports;


    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public List<RegionModel> getRegions() {
        return regions;
    }

    public List<SportsModel> getSports() {
        return sports;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", regions=" + regions +
                ", sports=" + sports +
                '}';
    }
}
