package kr.mashup.sportsmate.app.sign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bigstark.cycler.CyclerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.mashup.sportsmate.R;
import kr.mashup.sportsmate.SportsMateApplication;
import kr.mashup.sportsmate.app.home.HomeActivity;
import kr.mashup.sportsmate.model.UserModel;
import kr.mashup.sportsmate.model.command.SignInCommand;
import kr.mashup.sportsmate.rest.SportsMateClient;
import kr.mashup.sportsmate.rest.user.UserService;
import kr.mashup.sportsmate.util.SMLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SignInActivity extends CyclerActivity {
    @BindView(R.id.email) EditText userEmail;
    @BindView(R.id.password) EditText userPassword;
    @BindView(R.id.sign_in_btn) Button signInBtn;
    @BindView(R.id.sign_up_btn) Button signUpBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        setUnbinder(ButterKnife.bind(this));

        signInBtn.setOnClickListener(listener);
        signUpBtn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.sign_in_btn) {
                signIn();
            } else if(v.getId() == R.id.sign_up_btn) {
                signUp();
            }
        }
    };

    private void signIn() {
        startActivity(new Intent(SignInActivity.this, HomeActivity.class));
//        String email = userEmail.getText().toString();
//        String password = userPassword.getText().toString();
//
//        View focusView = null;
//        boolean cancel = false;
//
//        // Check for a valid password, if the user entered one.
//        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
//            userPassword.setError("The password is too short!!!");
//            focusView = userPassword;
//            cancel = true;
//        }
//
//        // Check for a valid email address.
//        if (TextUtils.isEmpty(email)) {
//            userEmail.setError("This field is required!!!");
//            focusView = userEmail;
//            cancel = true;
//        } else if (!isEmailValid(email)) {
//            userEmail.setError("This email address is invalid!!!");
//            focusView = userEmail;
//            cancel = true;
//        }
//
//        if (cancel) {
//            // There was an error; don't attempt login and focus the first
//            // form field with an error.
//            focusView.requestFocus();
//        } else {
//            // Show a progress spinner, and kick off a background task to
//            // perform the user login attempt.
//            attemptLogin(email, password);
//        }
    }

    private void signUp() {
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    private void attemptLogin(String email, String password) {
        SignInCommand userLoginInfo = new SignInCommand(email, password);

        UserService userService = SportsMateClient.getService(UserService.class);

        Call<UserModel> loginUserCall = userService.login(userLoginInfo);
        loginUserCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                SMLog.v(response.body().toString());

                if(response.code() == 200) {
//                    response.body().getId();

                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }
}