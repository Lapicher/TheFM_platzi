package com.example.lapicher.thefm.io;

/**
 * Created by Nataly on 19/08/2015.
 */
public class ApiConstantes {
    public static final String URL_BASE="http://ws.audioscrobbler.com";
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
