package com.example.tola.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.tola.Adapter.PlanAdapter;
import com.example.tola.Adapter.PostAdapter;
import com.example.tola.Data.PlanData;
import com.example.tola.Data.PostData;
import com.example.tola.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fv_postWrite;
    private static final String TAG= "Post";

    private ArrayList<PostData> arrayList;
    private PostAdapter postAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Log.e(TAG, "onCreate");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView=findViewById(R.id.rv_post);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        arrayList=new ArrayList<>();

        postAdapter=new PostAdapter(arrayList,this);
        recyclerView.setAdapter(postAdapter);

        fv_postWrite = findViewById(R.id.write_post_button);


        bottomNavigationView = findViewById(R.id.Plan_bottom_navi);
        bottomNavigationView.setSelectedItemId(R.id.go_post);
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


        fv_postWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostActivity.this, Write_post_Activity.class);
                startActivityForResult(intent, 1);




            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                PostData postData= (PostData) data.getSerializableExtra("post");
                arrayList.add(postData);
                postAdapter.notifyDataSetChanged();

            } else {   // RESULT_CANCEL

            }

        }
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();

    }


    @Override
    protected void onResume() {
        Log.e(TAG, "onResume");
        super.onResume();

    }

    @Override
    protected void onPause() {
        Log.e(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

}