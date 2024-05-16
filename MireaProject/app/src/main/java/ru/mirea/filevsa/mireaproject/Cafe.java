package ru.mirea.filevsa.mireaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.filevsa.mireaproject.databinding.FragmentCafeBinding;

public class Cafe extends Fragment {
    private FragmentCafeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCafeBinding.inflate(inflater, container, false);

        setButtons();

        return binding.getRoot();
    }

    private void setButtons() {

        binding.butRamen.setOnClickListener(v -> startMapActivity(
                "Ra'men",
                "Цветной бул., 21, стр. 7",
                55.772151, 37.619540));
        binding.butHinkal.setOnClickListener(v -> startMapActivity(
                "Старик Хинкалыч",
                "ул. Волхонка, 9, стр. 1",
                55.747095, 37.607628));
        binding.butTokyo.setOnClickListener(v -> startMapActivity(
                "Токио-City",
                "ул. Миклухо-Маклая, 36А",
                55.640072, 37.533221));
        binding.butMac.setOnClickListener(v -> startMapActivity(
                "Вкусно — и точка",
                "ул. Покрышкина, 2",
                55.664164, 37.481279));
    }

    private void startMapActivity(String title, String description, double latitude, double longitude) {
        Intent intent = new Intent(getActivity(), CafeActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
    }
}