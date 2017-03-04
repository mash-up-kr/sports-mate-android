package kr.mashup.sportsmate.app.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bigstark.cycler.CyclerActivity;

import butterknife.ButterKnife;
import kr.mashup.sportsmate.R;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class HomeActivity extends CyclerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        setUnbinder(ButterKnife.bind(this));
    }
}
