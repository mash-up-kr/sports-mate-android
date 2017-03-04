package kr.mashup.sportsmate.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import kr.mashup.sportsmate.util.GsonLoader;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bigstark on 2017. 3. 4..
 */

public class SportsMateClient {

    public static final String BASE_URL = "";


    private volatile static SportsMateClient instance;

    /**
     * Get cached api service.
     *
     * @param service is class type of api service
     * @return API service.
     */
    public static <T> T getService(Class<T> service) {
        if (instance == null) {
            synchronized (SportsMateClient.class) {
                if (instance == null) {
                    instance = new SportsMateClient();
                }
            }
        }

        return instance.getOrCreate(service);
    }


    private Retrofit retrofit;
    private Map<Object, Object> serviceHashMap = new HashMap<>();


    SportsMateClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(GsonLoader.getInstance().getGson()))
                .build();
    }


    // getLesson api service from hashmap.
    // if not exist, create from retrofit object and cache to hashmap
    <T> T getOrCreate(Class<T> service) {
        T apiService = (T) serviceHashMap.get(service);
        if (apiService != null) {
            return apiService;
        }

        apiService = retrofit.create(service);
        serviceHashMap.put(service, apiService);
        return apiService;
    }

}
