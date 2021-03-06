package com.example.lapicher.thefm.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.example.lapicher.thefm.R;
import com.example.lapicher.thefm.domain.Artist;
import com.example.lapicher.thefm.io.LastFmApiAdapter;
import com.example.lapicher.thefm.io.model.HypedArtistReponse;
import com.example.lapicher.thefm.ui.Adapter.HypedArtistAdapter;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by GKN on 13/08/2015.
 */
public class HypedArtistsFragment extends Fragment implements Callback<HypedArtistReponse> {

    public static final String LOG_TAG=HypedArtistsFragment.class.getName();
    public static final int NUM_COLUMNS=2;

    private RecyclerView mHypedArtistList;
    private HypedArtistAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new HypedArtistAdapter(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();

        LastFmApiAdapter.getApiService()
                .getHypedArtist(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_hyped_artists,container,false);
        /*
            Encuentra en el fragmento el RecycledView
         */
        mHypedArtistList=(RecyclerView)root.findViewById(R.id.hyped_artists_list);

        setupArtistsList();

        //setDummyContent(); Datos dummy ya no seran necesarios.

        return root;
    }
    private void setupArtistsList()
    {
        mHypedArtistList.setLayoutManager(new GridLayoutManager(getActivity(),NUM_COLUMNS));
        mHypedArtistList.setAdapter(adapter);
        // se aplica un espaciado entre cada Card del RecycledView.
        mHypedArtistList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
    }
    private void setDummyContent()
    {
        ArrayList<Artist> artists=new ArrayList<>();
        for (int i=0;i<10;i++)
        {
            artists.add(new Artist("Artist "+i));
        }
        adapter.addAll(artists);
    }

    @Override
    public void success(HypedArtistReponse hypedArtistReponse, Response response)
    {
        adapter.addAll(hypedArtistReponse.getArtists());
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}
