package com.example.bailt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentContainerView fragmentContainerView;
    Fragment_Group fragment_group;
    Fragment_User fragment_user;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment_group = new Fragment_Group();
        fragment_user = new Fragment_User();
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.frag_con_view,fragment_user).commit();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.mnu_gr:
                        fm.beginTransaction().replace(R.id.frag_con_view,fragment_group).commit();
                        break;
                    default:
                        fm.beginTransaction().replace(R.id.frag_con_view,fragment_user).commit();
                        break;

                }
                return false;
            }
        });
    }
}