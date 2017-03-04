package kr.mashup.sportsmate.rest.user;

import kr.mashup.sportsmate.model.UserModel;
import kr.mashup.sportsmate.model.command.SignInCommand;
import kr.mashup.sportsmate.model.command.SignUpCommand;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public interface UserService {

    @POST("user/register")
    Call<UserModel> register(@Body SignUpCommand command);


    @POST("user/login")
    Call<UserModel> login(@Body SignInCommand command);


    @GET("user/{userId}")
    Call<UserModel> getUser(@Path("userId") int userId);

}
