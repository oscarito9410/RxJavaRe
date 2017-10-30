package com.oscar.rxjavahelloworld.API;
import com.oscar.rxjavahelloworld.Model.NewResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by oemy9 on 26/10/2017.
 */

public class ControllerAPI  {

    private static final String TAG = "ControllerAPI";

    private Retrofit createRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(20, TimeUnit.SECONDS);
        httpClient.readTimeout(20,TimeUnit.SECONDS);
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()
                .baseUrl("http://version1.api.memegenerator.net/")
                .client(httpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private ApiService getService(){
        final Retrofit retrofit = createRetrofit();
        return retrofit.create(ApiService.class);
    }


    public Single<NewResponse> obtenerNuevos() {
       return getService().obtenerNuevos().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<NewResponse> buscar(String query){
      return   getService().busqueda(query,0,12).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

}
