package com.example.tola.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.tola.Adapter.FamilyAdapter;
import com.example.tola.Adapter.PlanAdapter;
import com.example.tola.Data.FamilyData;
import com.example.tola.Data.PlanData;
import com.example.tola.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG= "ITPANGPANG";
    BottomNavigationView bottomNavigationView;

    private ArrayList<FamilyData> arrayList;
    private FamilyAdapter familyAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        recyclerView=findViewById(R.id.rv_family);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        arrayList=new ArrayList<>();

        familyAdapter=new FamilyAdapter(arrayList);
        recyclerView.setAdapter(familyAdapter);






        findViewById(R.id.bt_plus_family).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_plus_family:
                    FamilyData df=new FamilyData("아빠","fdf",R.drawable.cat);
                    arrayList.add(df);
                    familyAdapter.notifyDataSetChanged();
                    break;

            }
        }
    };


    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();
        bottomNavigationView = findViewById(R.id.Plan_bottom_navi);
        bottomNavigationView.setSelectedItemId(R.id.go_profile);
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
}