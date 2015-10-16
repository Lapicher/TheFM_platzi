package com.example.lapicher.thefm.ui.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lapicher.thefm.R;
import com.example.lapicher.thefm.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nataly on 17/08/2015.
 */
public class HypedArtistAdapter extends RecyclerView.Adapter<HypedArtistAdapter.HypedArtistViewHOlder>

{
    ArrayList<Artist> artists;
    Context contx;

    public HypedArtistAdapter(Context context) {
        this.contx=context;
        this.artists=new ArrayList<Artist>();
    }
    @Override
    public HypedArtistViewHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(contx)
                .inflate(R.layout.item_hyped_artists, parent, false);
        return new HypedArtistViewHOlder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHOlder holder, int position) {
        Artist currentArtist=artists.get(position);


        holder.setArtistName(currentArtist.getName());

        // OBTENER LAS ULRS DE LOS ARTISTAS Y MOSTRARLAS CON PICASSO.
        if (currentArtist.getUrlMediumImage()!=null)
            holder.setArtisImage(currentArtist.getUrlMediumImage());
            //holder.setArtistDefaultImage();
        else
            holder.setArtistDefaultImage();

    }

    @Override
    public int getItemCount() {
        return artists.size();
    }
    public void addAll(ArrayList<Artist> arts)
    {
        if (arts==null)
            throw new NullPointerException("The items cannot be null");
        this.artists.addAll(arts);
        notifyItemRangeInserted(getItemCount()-1,arts.size());
    }


    // CLASE INTERNA
    public class HypedArtistViewHOlder extends RecyclerView.ViewHolder {

        TextView artistName;
        ImageView artisImage;
        public HypedArtistViewHOlder(View itemview) {
            super(itemview);
            artistName=(TextView)itemView.findViewById(R.id.txt_name);
            artisImage=(ImageView)itemView.findViewById(R.id.img_artist);
        }
        public void setArtistName(String name)
        {
            artistName.setText(name);
        }

        // cuando tenemos una URL de imagen
        public void setArtisImage(String url){
            Picasso.with(contx)
                    .load(url)
                    .placeholder(R.drawable.place_holder)
                    .into(artisImage);
        }
        // cuando no tenemos una url de imagen
        public void setArtistDefaultImage()
        {
            Picasso.with(contx)
                    .load(R.drawable.place_holder)
                    .into(artisImage);
        }
    }

}
