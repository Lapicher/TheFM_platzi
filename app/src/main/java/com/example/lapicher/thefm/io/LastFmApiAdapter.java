package com.example.lapicher.thefm.io;

import com.example.lapicher.thefm.io.deserializer.HypedArtistsDeserializer;
import com.example.lapicher.thefm.io.model.HypedArtistReponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by MLBF on 28/08/15.
 */
public class LastFmApiAdapter {

    private static LastFMApiService API_SERVICE;

    public static LastFMApiService getApiService()
    {
        // esto hace la magia.
        if(API_SERVICE==null)
        {
            RestAdapter adapter=new RestAdapter.Builder()
                    .setEndpoint(ApiConstantes.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFmApiGsonConverter())
                    .build();
            API_SERVICE=adapter.create(LastFMApiService.class);

        }
        return  API_SERVICE;
    }
    // metodo para cargar el objeto deserializado para retrofit
    private static GsonConverter buildLastFmApiGsonConverter()
    {
        Gson gsonConf=new GsonBuilder()
                .registerTypeAdapter(HypedArtistReponse.class,new HypedArtistsDeserializer())
                .create();
        return new GsonConverter(gsonConf);
    }

}
