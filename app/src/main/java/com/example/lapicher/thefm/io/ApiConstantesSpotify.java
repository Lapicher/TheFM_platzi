package com.example.lapicher.thefm.io;

/**
 * Created by MLBF on 27/08/15.
 */
public class ApiConstantesSpotify {
    public static final String URL_BASE="https://api.spotify.com";
    public static final String API_KEY="";
    public static final String PATH_VERSION="/2.0";
    public static final String VALUE_HYPED_ARTIST_METOD="char.gethypedartist";
    public static final String PARAM_METOD="method";
    public static final String PARAM_FORMAT="format";
    public static final String PARAM_API_KEY="api_key";

    public static final String VALUE_JSON="json";

    public static final String URL_HYPED_ARTIST="?"+PARAM_API_KEY+"="+API_KEY+"&"+PARAM_METOD+"="+VALUE_HYPED_ARTIST_METOD+
            "&"+PARAM_FORMAT+"="+VALUE_JSON;
}
