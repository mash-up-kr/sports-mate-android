package kr.mashup.sportsmate;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

import java.util.HashMap;
import java.util.Map;

import teaspoon.TeaSpoon;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SportsMateApplication extends Application {


    private static SportsMateApplication instance;

    public static SportsMateApplication getInstance() {
        return instance;
    }



    private Map<Integer, Integer> resourceMap = new HashMap<>();

    private int screenWidth;
    private int screenHeight;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        TeaSpoon.initialize();
        Hawk.init(this).build();
    }

    private void initScreenSize() {
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
    }

    public int getDimensionPixelSize(int id) {
        int size = resourceMap.containsKey(id) ? resourceMap.get(id) : getResources().getDimensionPixelSize(id);
        resourceMap.put(id, size);
        return size;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
