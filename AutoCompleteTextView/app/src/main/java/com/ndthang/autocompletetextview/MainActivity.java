package com.ndthang.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView auto_complete_textview;
    ListView listSong;
    List<String> songs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findItem();
        songs.add("LAVIAI - WXRDIE");
        songs.add("Chìm Sâu - RPT MCK");
        songs.add("Ghé Qua - Dick");
        songs.add("Lan Man - Ronboogz");
        songs.add("vaicaunoicokhiennguoithaydoi - GREY D");
        ArrayAdapter<String> adapterSong = new ArrayAdapter<>(this, R.layout.textview_complete, R.id.tv_song_name, songs);
        auto_complete_textview.setAdapter(adapterSong);
        listSong.setAdapter(adapterSong);

        itemListViewOnClick();
    }
    void itemListViewOnClick(){
        listSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nameSong= songs.get(i).toString();
                String thongBao= "Bắt đầu phát: " + nameSong;
                Toast.makeText(MainActivity.this,thongBao, Toast.LENGTH_SHORT).show();
            }
        });
    }
    void findItem() {
        auto_complete_textview = findViewById(R.id.auto_complete_textview);
        listSong = findViewById(R.id.list_song);
    }
}