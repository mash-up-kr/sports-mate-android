package kr.mashup.sportsmate.app.sign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bigstark.cycler.CyclerActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.mashup.sportsmate.R;
import kr.mashup.sportsmate.model.RegionModel;
import kr.mashup.sportsmate.model.SportsModel;
import kr.mashup.sportsmate.model.UserModel;
import kr.mashup.sportsmate.model.command.SignUpCommand;
import kr.mashup.sportsmate.rest.SportsMateClient;
import kr.mashup.sportsmate.rest.user.UserService;
import kr.mashup.sportsmate.util.SMLog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tak on 2017. 3. 4..
 */
public class SignUpSecondActivity extends CyclerActivity {
    @BindView(R.id.sign_up_end) Button signUpEnd;
    @BindView(R.id.region) TextView userResgion;
    @BindView(R.id.sports) TextView userSports;

    private SignUpCommand userInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_second);
        setUnbinder(ButterKnife.bind(this));

        init();

        signUpEnd.setOnClickListener(listener);
    }

    private void init() {
        Intent intent = getIntent();
        final String email = intent.getStringExtra("userEmail");
        final String nickname = intent.getStringExtra("userNickname");
        final String password = intent.getStringExtra("userPassword");

        String region = userResgion.getText().toString();
        RegionModel regionModel = new RegionModel(0, region);
        String sports = userSports.getText().toString();
        SportsModel sportsModel = new SportsModel(0, sports);

        final List<RegionModel> regionList = new ArrayList<>();
        regionList.add(regionModel);
        final List<SportsModel> sportList = new ArrayList<>();
        sportList.add(sportsModel);

        userInfo = new SignUpCommand(email, nickname, password, regionList, sportList);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            UserService userService = SportsMateClient.getService(UserService.class);

            Call<UserModel> authUserCall = userService.register(userInfo);
            authUserCall.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    SMLog.v(response.body().toString());
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {

                }
            });
        }
    };

}
