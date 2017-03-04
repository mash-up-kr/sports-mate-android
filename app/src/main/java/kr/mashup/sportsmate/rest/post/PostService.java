package kr.mashup.sportsmate.rest.post;

import java.util.List;

import kr.mashup.sportsmate.model.PostModel;
import kr.mashup.sportsmate.model.command.PostCommand;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public interface PostService {

    @POST("post")
    Call<PostModel> post(@Body PostCommand command);


    @GET("post")
    Call<List<PostModel>> getPosts(@Query("sportId") int sportId);

}
