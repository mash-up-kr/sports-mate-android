package kr.mashup.sportsmate.app.splash;

import android.content.Intent;
import android.os.Bundle;

import com.bigstark.cycler.CyclerActivity;

import kr.mashup.sportsmate.R;
import kr.mashup.sportsmate.UserManager;
import kr.mashup.sportsmate.util.Defines;
import teaspoon.annotations.OnUi;

public class SplashActivity extends CyclerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        if (UserManager.getInstance().isSigned()) {
            startSignActivity();
        } else {
            startHomeActivity();
        }
    }


    @OnUi(delay = 1000)
    private void startSignActivity() {
        Intent intent = new Intent(Defines.INTENT_SIGN_IN_ACTIVITY);
        startActivity(intent);
    }

    @OnUi(delay = 1000)
    void startHomeActivity() {
        Intent intent = new Intent(Defines.INTENT_HOME_ACTIVITY);
        startActivity(intent);
    }
}
