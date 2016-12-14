package com.example.rodolphe.translate_template.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rodolphe.translate_template.MainActivity;
import com.example.rodolphe.translate_template.R;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    private Spinner languageSelect;
    private RecyclerView listEmoji;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.second_frag, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragSecond);
        tv.setText(getArguments().getString("msg"));

        //spinner
        languageSelect = (Spinner) v.findViewById(R.id.language);
        String[] items = new String[]{"US", "FR", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        languageSelect.setAdapter(adapter);

        //RecyclerView

        listEmoji = (RecyclerView) v.findViewById(R.id.ListEmoji);

        // fill the list items
        List<String> itemslist = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            // new item
            itemslist.add("test " + i);
        }

        //Aplly changement
        adapter = new RecyclerViewAdapter(itemslist, android.R.layout.simple_list_item_1);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


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