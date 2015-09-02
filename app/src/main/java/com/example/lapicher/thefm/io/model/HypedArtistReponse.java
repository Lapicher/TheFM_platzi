package com.example.lapicher.thefm.io.model;

import com.example.lapicher.thefm.domain.Artist;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by MLBF on 27/08/15.
 */
public class HypedArtistReponse {
    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResults results;

    public ArrayList<Artist> getArtists()
    {
        return  results.artists;
    }
    private class HypedArtistsResults {

        @SerializedName(JsonKeys.ARTISTS_ARRAY)
        ArrayList<Artist> artists;
    }
}
