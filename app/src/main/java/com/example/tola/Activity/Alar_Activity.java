package com.example.tola.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.tola.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Alar_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private static final String TAG= "ITPANGPANG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alar_);

        


        bottomNavigationView = findViewById(R.id.Plan_bottom_navi);
        bottomNavigationView.setSelectedItemId(R.id.go_message);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.go_plan:
                        myStartActivity(PlanActivity.class);
                        break;
                    case R.id.go_post:
                        myStartActivity(PostActivity.class);
                        break;
                    case R.id.go_profile:
                        myStartActivity(ProfileActivity.class);
                        break;
                    case R.id.go_message:
                        myStartActivity(Alar_Activity.class);
                        break;


                }
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}