package com.example.lapicher.thefm.io;

import retrofit.RestAdapter;

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
                    .build();
            API_SERVICE=adapter.create(LastFMApiService.class);

        }
        return  API_SERVICE;
    }

}
