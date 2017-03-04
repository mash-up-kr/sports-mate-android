package kr.mashup.sportsmate.util;

import android.util.Log;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SMLog {

    public static final String TAG = "SPORTS_MATE_LOG";

    public static void v(String message) {
        Log.v(TAG, message);
    }


    public static void e(String message) {
        Log.e(TAG, message);
    }

}
