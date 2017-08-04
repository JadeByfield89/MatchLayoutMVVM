package com.permoveo.matchlayoutmvvm.data;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by byfieldj on 8/4/17.
 */

public interface MatchService {

    @GET("matchSample.json")
    Observable<MatchResponse> fetchMatches();
}
