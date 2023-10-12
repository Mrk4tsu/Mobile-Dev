package com.ndthang.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        toastShow("Home");
                        break;
                    case R.id.action_favourite:
                        toastShow("Favourite");
                        break;
                    case R.id.action_account:
                        toastShow("Account");
                        break;
                }
                return true;
            }
        });
    }
    void toastShow(String mess){
        Toast.makeText(MainActivity.this, mess, Toast.LENGTH_LONG).show();
    }
}