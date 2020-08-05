package com.example.tola.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;

import com.example.tola.Adapter.PlanAdapter;
import com.example.tola.Data.PlanData;
import com.example.tola.Data.PostData;
import com.example.tola.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.tola.R.id.content;
import static com.example.tola.R.id.go_post;

public class PlanActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;

    private static final String TAG= "plan";

    private ArrayList<PlanData> arrayList;
    private PlanAdapter planAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private CalendarView calendarView;
   private int yyear=0,mmonth,ddayOfMonth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Log.e(TAG, "onCreate");


        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                yyear=year;
                mmonth=month;
                ddayOfMonth=dayOfMonth;

            }
        });

        bottomNavigationView = findViewById(R.id.Plan_bottom_navi);
        bottomNavigationView.setSelectedItemId(R.id.go_plan);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.go_plan:
                        myStartActivity(PlanActivity.class);
                        break;
                    case go_post:
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



        recyclerView=findViewById(R.id.rv_plan);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        arrayList=new ArrayList<>();

        planAdapter=new PlanAdapter(arrayList,PlanActivity.this);
        recyclerView.setAdapter(planAdapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         fab = findViewById(R.id.write_plan_button);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this, Write_plan_Activity.class);
                String date=Integer.toString(yyear)+"-"+Integer.toString(mmonth)+"-"+Integer.toString(ddayOfMonth);
                intent.putExtra("date",date);
                startActivityForResult(intent, 2);


            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {

                PlanData planData= (PlanData) data.getSerializableExtra("plan");
                String date=new String(Integer.toString(yyear)+"-"+Integer.toString(mmonth)+"-"+ddayOfMonth);
                Log.e("fdsf",""+yyear);

                arrayList.add(planData);
                planAdapter.notifyDataSetChanged();

            } else {   // RESULT_CANCEL

            }

        }
    }
    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();


    }


    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_tool,menu);
        return true;
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