package kr.mashup.sportsmate.app.sign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.bigstark.cycler.CyclerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.mashup.sportsmate.R;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SignInActivity extends CyclerActivity {
    @BindView(R.id.sign_up_btn) Button signUpBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        setUnbinder(ButterKnife.bind(this));

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}