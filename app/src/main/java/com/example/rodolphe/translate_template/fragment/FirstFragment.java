package com.example.rodolphe.translate_template.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rodolphe.translate_template.R;

public class FirstFragment extends Fragment {

    private Spinner languageSelector;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_frag, container, false);

        //spinner
        languageSelector = (Spinner) v.findViewById(R.id.languageFirst);
        String[] items = new String[]{"Francais", "Anglais", "Espagnol"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner, items);
        languageSelector.setAdapter(adapter);

        return v;
    }

    public static FirstFragment newInstance(String text) {

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}