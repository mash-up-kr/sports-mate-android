package kr.mashup.sportsmate.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SportsModel {

    @SerializedName("id")
    private int id;


    @SerializedName("name")
    private String name;

    public SportsModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SportsModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
