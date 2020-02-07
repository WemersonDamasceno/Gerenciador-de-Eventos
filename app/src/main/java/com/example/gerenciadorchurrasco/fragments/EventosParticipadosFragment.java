package com.example.gerenciadorchurrasco.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.gerenciadorchurrasco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventosParticipadosFragment extends Fragment {


    public EventosParticipadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eventos_participados, container, false);
    }

}
