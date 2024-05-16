package ru.mirea.filevsa.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends Fragment {

    private EditText mmrField;
    private EditText heroField;
    private EditText posField;
    private EditText steamField;
    private String  USER_MMR = "USER_MMR";
    private String  USER_HERO = "USER_HERO";
    private String  USER_POS = "USER_POS";
    private String  USER_STEAM = "USER_STEAM";
    public Profile() {
    }

    public static Profile newInstance(String param1, String param2) {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonSave = view.findViewById(R.id.saveBtn);
        buttonSave.setOnClickListener(v -> saveDataButton(v));

        mmrField = view.findViewById(R.id.mmrField);
        heroField = view.findViewById(R.id.heroField);
        posField = view.findViewById(R.id.posField);
        steamField = view.findViewById(R.id.steamField);

        SharedPreferences sharedPref = getContext().getSharedPreferences("profile_data_dota", Context.MODE_PRIVATE);
        mmrField.setText(sharedPref.getString(USER_MMR, ""));
        heroField.setText(sharedPref.getString(USER_HERO, ""));
        posField.setText(sharedPref.getString(USER_POS, ""));
        steamField.setText(sharedPref.getString(USER_STEAM, ""));


    }


    public void saveDataButton(View view){
        SharedPreferences sharedPref = getContext().getSharedPreferences("profile_data", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(USER_MMR, mmrField.getText().toString());
        editor.putString(USER_HERO, heroField.getText().toString());
        editor.putString(USER_POS, posField.getText().toString());
        editor.putString(USER_STEAM, steamField.getText().toString());

        editor.apply();
    }
}