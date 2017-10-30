package com.oscar.rxjavahelloworld.API;
import com.oscar.rxjavahelloworld.Model.NewResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by oemy9 on 26/10/2017.
 */

public interface ApiService {
    @GET("Generators_Select_ByNew")
    Single<NewResponse> obtenerNuevos();
    @GET("Instances_Search")
    Observable<NewResponse> busqueda(@Query("q")String query, @Query("pageIndex")int pageIndex, @Query("pageSize")int pageSize);
}
