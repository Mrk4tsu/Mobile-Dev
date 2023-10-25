package com.ndthang.customizelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ndthang.customizelistview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListAdapter listAdapter;
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {
                R.mipmap.pasta,
                R.mipmap.maggi,
                R.mipmap.cake,
                R.mipmap.pancake,
                R.mipmap.pizza,
                R.mipmap.burger,
                R.mipmap.fries
        };
        int[] ingredientList =
                {
                        R.string.pastaIngredients,
                        R.string.maggiIngredients,
                        R.string.cakeIngredients,
                        R.string.pancakeIngredients,
                        R.string.pizzaIngredients,
                        R.string.burgerIngredients,
                        R.string.friesIngredients
                };
        int[] descList = {
                R.string.pastaDesc,
                R.string.maggieDesc,
                R.string.cakeDesc,
                R.string.pancakeDesc,
                R.string.pizzaDesc,
                R.string.burgerDesc,
                R.string.friesDesc,
        };
        String[] nameList = {"Pasta", "Maggi", "Cake", "Pancake", "Pizza", "Burgers", "Fries"};
        String[] timeList = {"30 mins", "2 mins", "45 mins", "10 mins", "60 mins", "45 mins", "30 mins"};

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}