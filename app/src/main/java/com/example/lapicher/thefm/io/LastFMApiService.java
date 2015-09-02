package com.example.lapicher.thefm.io;

import com.example.lapicher.thefm.io.model.HypedArtistReponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Nataly on 19/08/2015.
 */
public interface LastFMApiService {
    @GET(ApiConstantes.URL_HYPED_ARTIST)
    void getHypedArtist(Callback<HypedArtistReponse> serverResponse);
}
