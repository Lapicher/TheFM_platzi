package com.example.lapicher.thefm.io.deserializer;

import android.widget.ListView;

import com.example.lapicher.thefm.domain.Artist;
import com.example.lapicher.thefm.io.model.HypedArtistReponse;
import com.example.lapicher.thefm.io.model.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Nataly on 03/09/15.
 */
public class HypedArtistsDeserializer implements JsonDeserializer<HypedArtistReponse>{

    @Override
    public HypedArtistReponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();

        //lee el objecto json y lo parsea o nos los regresa en un objeto de tipo HypedArtistResponse. Manualmente.
        HypedArtistReponse reponse=gson.fromJson(json,HypedArtistReponse.class);

        // Obtener el objecto artists
        JsonObject artistResponseData=json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULTS);

        // Obtener el array de artists
        JsonArray artistsArray= artistResponseData.getAsJsonArray(JsonKeys.ARTISTS_ARRAY);

        //Convertir el jsonArray de artists a objetos de la clase Artist
        reponse.setArtists(extractArtistFromJsonArray(artistsArray));

        // regresar respuesta
        return  reponse;
    }
    private ArrayList<Artist> extractArtistFromJsonArray(JsonArray array)
    {
        ArrayList<Artist> artists=new ArrayList<Artist>();
        for (int i = 0; i <array.size(); i++) {
            JsonObject artistData=array.get(i).getAsJsonObject();

            Artist currentArtist=new Artist();
            // extrae el nombre del artista del json.
            String name=artistData.get(JsonKeys.ARTIST_NAME).getAsString();

            // extraer las imagenes en un arreglo del artista. Small,Large,ExtraLarge. os tamaños diferentes de imagenes.
            JsonArray imagesArray=artistData.getAsJsonArray(JsonKeys.Artist_image);
            String[] images=extractArtistsImagesFromJsonArray(imagesArray);

            // Artista con toda la informacion seteada.
            currentArtist.setName(name);
            currentArtist.setUrlMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            // agregamos el artista a la lista de artistas para regresarla
            artists.add(currentArtist);
        }
        return  artists;
    }
    private String[] extractArtistsImagesFromJsonArray(JsonArray imagesArray)
    {
        String[] images =new String[2];
        for (int i = 0; i < imagesArray.size(); i++) {
            // obtenemos la informacion de la imagen.
            JsonObject imagenData=imagesArray.get(i).getAsJsonObject();
            String size=imagenData.get(JsonKeys.IMAGE_SIZE).getAsString();

            String url=imagenData.get(JsonKeys.IMAGE_URL).getAsString();


            if (url.isEmpty())
                url=null;
            else
                // se remplaza las diagonales invertidas por medio de la expresion regular para que funcione.
                url=url.replaceAll("\\/","/");

            if (size.matches(JsonKeys.IMAGE_MEDIUM))
            {
                images[0]=url;
            }
            else if (size.matches(JsonKeys.IMAGE_LARGE))
            {
                images[1]=url;
            }
        }
        return images;
    }
}
