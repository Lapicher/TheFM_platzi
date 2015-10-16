package com.example.lapicher.thefm.domain;

import com.example.lapicher.thefm.io.model.*;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nataly on 14/08/2015.
 */
public class Artist{

    @SerializedName(JsonKeys.ARTIST_NAME)
    String name;

    String urlMediumImage;
    String urlLargeImage;


    public Artist(String name) {
        this.name = name;
    }

    public Artist() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }
}
