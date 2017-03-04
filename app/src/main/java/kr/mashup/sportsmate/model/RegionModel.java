package kr.mashup.sportsmate.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class RegionModel {

    @SerializedName("id")
    private int id;


    @SerializedName("address")
    private String address;

    public RegionModel(int id, String address) {
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "RegionModel{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
