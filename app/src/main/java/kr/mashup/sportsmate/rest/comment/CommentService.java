package kr.mashup.sportsmate.rest.comment;

import java.util.List;

import kr.mashup.sportsmate.model.CommentModel;
import kr.mashup.sportsmate.model.command.CommentCommand;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public interface CommentService {

    @GET("post/{postId}/comment")
    Call<List<CommentModel>> getComments(@Path("postId") int postId);


    @POST("post/{postId}/comment")
    Call<CommentModel> comment(@Body CommentCommand command);
}
