package com.example.rodolphe.translate_template.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rodolphe.translate_template.Adapter.RecyclerSimpleViewAdapter;
import com.example.rodolphe.translate_template.MainActivity;
import com.example.rodolphe.translate_template.R;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private Spinner languageSelect;
    private RecyclerView listEmoji;
    private RecyclerSimpleViewAdapter adapterEmoji;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.second_frag, container, false);

        //spinner
        languageSelect = (Spinner) v.findViewById(R.id.language);
        String[] items = new String[]{"Francais", "Anglais", "Espagnol"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner, items);
        languageSelect.setAdapter(adapter);

        //RecyclerView

        //Layout Manager
        GridLayoutManager gridLayoutManager
                = new GridLayoutManager(getActivity(), 3);

        listEmoji = (RecyclerView) v.findViewById(R.id.ListEmoji);

        listEmoji.setLayoutManager(gridLayoutManager);

        // fill the list items
        List<String> itemslist = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            // new item
            itemslist.add("test " + i);
        }

        //Aplly changement

        adapterEmoji = new RecyclerSimpleViewAdapter(itemslist, R.layout.grille_custom);
        listEmoji.setAdapter(adapterEmoji);



        return v;
    }

    public static SecondFragment newInstance(String text) {

        SecondFragment f = new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}