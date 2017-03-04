package kr.mashup.sportsmate.app.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bigstark.cycler.CyclerActivity;

import butterknife.ButterKnife;
import kr.mashup.sportsmate.R;
import kr.mashup.sportsmate.adapter.LocationAdapter;

/**
 * Created by Tak on 2017. 3. 5..
 */

public class BasketActivity extends CyclerActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket);
        setUnbinder(ButterKnife.bind(this));

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        String[] myDataset = {"1", "2", "3","4","5"};
        mAdapter = new LocationAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
