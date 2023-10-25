package com.ndthang.nguyenducthang_63135414_cnttclc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    AutoCompleteTextView autoCountry;
    ArrayList dsCountry;
    ListView baihat;
    ArrayList dsbaihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        findcontrols();
        dsbaihat = new ArrayList<String>();
        dsbaihat.add("Tien quan ca");
        dsbaihat.add("Cuon theo lan gio");
        dsbaihat.add("Lop chung minh");
        dsbaihat.add("Lop chung minh");
        dsbaihat.add("Lop chung minh");
        dsbaihat.add("Lop chung minh");
        dsbaihat.add("Lop chung minh");
        ArrayAdapter<String> adapterCountry;
        adapterCountry = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,dsbaihat);
        autoCountry.setAdapter(adapterCountry);


        ArrayAdapter<String> adapterBH;
        adapterBH = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,dsbaihat);
        baihat.setAdapter(adapterBH);

        baihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemChon= dsbaihat.get(i).toString();
                String thongBao= "Ban chon bai:" + itemChon;
                Toast.makeText(ListViewActivity.this,thongBao,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void findcontrols(){
        autoCountry=findViewById(R.id.autoCompleteTextView);
        baihat=findViewById(R.id.listbaihat);
    }
}