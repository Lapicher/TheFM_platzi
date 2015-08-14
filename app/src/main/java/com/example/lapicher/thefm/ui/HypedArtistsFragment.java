package com.example.lapicher.thefm.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lapicher.thefm.R;

/**
 * Created by GKN on 13/08/2015.
 */
public class HypedArtistsFragment extends Fragment {

    public static final String LOG_TAG=HypedArtistsFragment.class.getName();

    private RecyclerView mHypedArtistList;
    public static final int NUM_COLUMNS=2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_hyped_artists,container,false);
        /*
            Encuentra en el fragmento el RecycledView
         */
        mHypedArtistList=(RecyclerView)root.findViewById(R.id.hyped_artists_list);

        return root;
    }
    private void setupArtistsList()
    {
        mHypedArtistList.setLayoutManager(new GridLayoutManager(getActivity(),NUM_COLUMNS));
    }
}
