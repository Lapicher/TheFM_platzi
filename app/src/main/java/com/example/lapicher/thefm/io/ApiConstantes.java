package com.example.lapicher.thefm.io;

/**
 * Created by Nataly on 19/08/2015.
 */
public class ApiConstantes {
    public static final String URL_BASE="http://ws.audioscrobbler.com";
    public static final String API_KEY="123ae7ccee87798c55c82b64c792a083";
    public static final String PATH_VERSION="/2.0";   // chart.getTopArtists //chart.getHypedArtists
    public static final String VALUE_HYPED_ARTIST_METOD="chart.getTopArtists";
    public static final String PARAM_METOD="method";
    public static final String PARAM_FORMAT="format";
    public static final String PARAM_API_KEY="api_key";

    public static final String VALUE_JSON="json";

    public static final String URL_HYPED_ARTIST=PATH_VERSION+"?"+PARAM_API_KEY+"="+API_KEY+"&"+PARAM_METOD+"="+VALUE_HYPED_ARTIST_METOD+
            "&"+PARAM_FORMAT+"="+VALUE_JSON;
}
