package com.ndthang.nguyenducthang_63135414_cnttclc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.ndthang.nguyenducthang_63135414_cnttclc2.databinding.ActivityCustomizeListViewBinding;

import java.util.ArrayList;

public class CustomizeListView extends AppCompatActivity {
    ActivityCustomizeListViewBinding binding;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListAdapter listAdapter;
    ListData listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_customize_list_view);
        binding = ActivityCustomizeListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {
                R.mipmap.vietnam,
                R.mipmap.southkorea,
                R.mipmap.japan,
                R.mipmap.brazil,
                R.mipmap.china,
                R.mipmap.russia,
                R.mipmap.canada,
        };
        int[] ingredientList =
                {
                        R.string.pastaIngredients,
                        R.string.koreaCapital,
                        R.string.japanCapital,
                        R.string.brazilCapital,
                        R.string.chinaCapital,
                        R.string.russiaCapital,
                        R.string.canadaCapital
                };
        int[] descList = {
                R.string.pastaDesc,
                R.string.koreaDesc,
                R.string.japanDesc,
                R.string.brazilDesc,
                R.string.chinaDesc,
                R.string.russiaDesc,
                R.string.canadaDesc,
        };
        String[] nameList = {"Việt Nam", "Hàn Quốc", "Nhật Bản", "Brazil", "Trung Quốc", "Nga", "Canada"};
        String[] timeList = {"Đ.N.Á", "Đông Á", "Đông Á", "Nam Mỹ", "Đông Á", "Bắc Á - Âu", "Bắc Mỹ"};

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(CustomizeListView.this, dataArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CustomizeListView.this, DetailActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}