package kr.mashup.sportsmate.model.command;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class CommentCommand {

    @SerializedName("post")
    private int postId;


    @SerializedName("author")
    private int authorId;


    @SerializedName("content")
    private String content;

}
