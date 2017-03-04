package kr.mashup.sportsmate.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class PostModel {

    @SerializedName("id")
    private int id;


    @SerializedName("author")
    private UserModel author;


    @SerializedName("region")
    private RegionModel region;


    @SerializedName("sport")
    private SportsModel sport;


    @SerializedName("content")
    private String content;


    @SerializedName("restrict_count")
    private int restrictCount;


    @SerializedName("created_date")
    private Date createdDate;


    @SerializedName("place")
    private String place;


    @SerializedName("start_date")
    private Date startTime;


    @SerializedName("end_date")
    private Date endTime;


    public int getId() {
        return id;
    }

    public UserModel getAuthor() {
        return author;
    }

    public RegionModel getRegion() {
        return region;
    }

    public SportsModel getSport() {
        return sport;
    }

    public String getContent() {
        return content;
    }

    public int getRestrictCount() {
        return restrictCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getPlace() {
        return place;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", author=" + author +
                ", region=" + region +
                ", sport=" + sport +
                ", content='" + content + '\'' +
                ", restrictCount=" + restrictCount +
                ", createdDate=" + createdDate +
                ", place='" + place + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
