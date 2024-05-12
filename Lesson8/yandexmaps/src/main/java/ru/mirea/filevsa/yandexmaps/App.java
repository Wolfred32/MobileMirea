package ru.mirea.filevsa.yandexmaps;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String MAPKIT_API_KEY = "803be158-35a4-45ea-a58a-9793a355cd7d";
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}