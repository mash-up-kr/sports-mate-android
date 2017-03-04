package kr.mashup.sportsmate.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class CommentModel {

    @SerializedName("id")
    private String id;

    @SerializedName("author")
    private UserModel author;


    @SerializedName("post")
    private int postId;


    @SerializedName("content")
    private String content;


    @SerializedName("created_date")
    private Date createdDate;


    public String getId() {
        return id;
    }

    public UserModel getAuthor() {
        return author;
    }

    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }


    @Override
    public String toString() {
        return "CommentModel{" +
                "id='" + id + '\'' +
                ", author=" + author +
                ", postId=" + postId +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
