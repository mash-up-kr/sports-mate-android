package kr.mashup.sportsmate.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * Created by bigstark on 2016. 10. 12..
 *
 * GsonLoader just does serialize and deserialize.
 *
 * But Gson object is difficult to collect null object, it occurs memory leak.
 * So, Gson object must be singleton object.
 */

public class GsonLoader {

    private volatile static GsonLoader instance;

    public static GsonLoader getInstance() {
        if (instance == null) {
            synchronized (GsonLoader.class) {
                if (instance == null) {
                    instance = new GsonLoader();
                }
            }
        }

        return instance;
    }

    public static String toJson(Object src) {
        return getInstance().getGson().toJson(src);
    }


    public static <T> T fromJson(String json, Class<T> classType) {
        return getInstance().getGson().fromJson(json, classType);
    }


    public static <T> T fromJson(String json, Type type) {
        return getInstance().getGson().fromJson(json, type);
    }


    private Gson gson;

    GsonLoader() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .setLenient()
                .create();
    }

    public Gson getGson() {
        return gson;
    }
}
