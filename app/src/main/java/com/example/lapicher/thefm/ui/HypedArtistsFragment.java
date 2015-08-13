package com.example.lapicher.thefm.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lapicher.thefm.R;

/**
 * Created by GKN on 13/08/2015.
 */
public class HypedArtistsFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //View root=inflater.inflate(R.layout.fragment_hyped_artists,container,false);
        View root = inflater.inflate(R.layout.fragment_hyped_artists,container,false);

        return root;
    }
}
