package com.ndthang.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView auto_complete_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findItem();

        String[] songs = {
                "LAVIAI - WXRDIE",
                "Chìm Sâu - RPT MCK",
                "Ghé Qua - Dick",
                "Lan Man - Ronboogz",
                "vaicaunoicokhiennguoithaydoi - GREY D"
        };
        ArrayAdapter<String> adapterSong = new ArrayAdapter<>(this, R.layout.textview_complete, R.id.tv_song_name, songs);
        auto_complete_textview.setAdapter(adapterSong);
    }

    void findItem() {
        auto_complete_textview = findViewById(R.id.auto_complete_textview);
    }
}