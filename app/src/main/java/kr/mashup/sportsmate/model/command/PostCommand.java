package kr.mashup.sportsmate.model.command;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class PostCommand {


    @SerializedName("author")
    private int authorId;


    @SerializedName("region")
    private int regionId;


    @SerializedName("sport")
    private int sportId;


    @SerializedName("content")
    private String content;


    @SerializedName("restrict_count")
    private int restrictCount;


    @SerializedName("place")
    private String place;


    @SerializedName("start_date")
    private Date startDate;


    @SerializedName("end_date")
    private Date endDate;


    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRestrictCount(int restrictCount) {
        this.restrictCount = restrictCount;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PostCommand{" +
                "authorId=" + authorId +
                ", regionId=" + regionId +
                ", sportId=" + sportId +
                ", content='" + content + '\'' +
                ", restrictCount=" + restrictCount +
                ", place='" + place + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
