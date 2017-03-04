package kr.mashup.sportsmate.app.sign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigstark.cycler.CyclerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.mashup.sportsmate.R;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SignUpActivity extends CyclerActivity {
    @BindView(R.id.email) EditText userEmail;
    @BindView(R.id.nickname) EditText userNickname;
    @BindView(R.id.password) EditText userPassword;
    @BindView(R.id.sign_up_btn) Button signUpBtn;
    @BindView(R.id.already_sign_up) TextView alreadySignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        setUnbinder(ButterKnife.bind(this));

        signUpBtn.setOnClickListener(listener);
        alreadySignUp.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.sign_up_btn) {
                signUp();
            } else if(v.getId() == R.id.already_sign_up) {
                alreadySigned();
            }
        }
    };

    private void signUp() {
        String email = userEmail.getText().toString();
        String nickName = userNickname.getText().toString();
        String password = userPassword.getText().toString();

        View focusView = null;
        boolean cancel = false;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            userPassword.setError("The password is too short!!!");
            focusView = userPassword;
            cancel = true;
        }

        // Check for a valid nickname.
        if(TextUtils.isEmpty(nickName) && !isNicknameValid(nickName)) {
            userNickname.setError("The nickname is too short!!!");
            focusView = userNickname;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            userEmail.setError("This field is required!!!");
            focusView = userEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            userEmail.setError("This email address is invalid!!!");
            focusView = userEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user sign up attempt.
            signUpNext(email, nickName, password);
        }
    }

    private void signUpNext(String email, String nickName, String password) {
        Intent intent = new Intent(SignUpActivity.this, SignUpSecondActivity.class);
        intent.putExtra("userEmail", email);
        intent.putExtra("userNickname", nickName);
        intent.putExtra("userPassword", password);
        startActivity(intent);
    }

    private void alreadySigned() {
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isNicknameValid(String nickName) {
        return nickName.length() < 6;
    }
}
