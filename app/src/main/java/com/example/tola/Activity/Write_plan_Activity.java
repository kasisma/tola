package com.example.tola.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.tola.Data.PlanData;
import com.example.tola.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Write_plan_Activity extends AppCompatActivity {

    private static final String TAG= "Write Plan";
    int h=0,mi=0;
    private CheckBox checkBox;
    private Calendar c;

    private TextView title;
    private TextView content;
    private TextView date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_plan_);
        Log.e(TAG, "onCreate");
        findViewById(R.id.tv_plan_date).setOnClickListener(onClickListener);
        findViewById(R.id.btn_plan_check).setOnClickListener(onClickListener);
        title=findViewById(R.id.et_plan_title);
        content=findViewById(R.id.et_plan_content);
        this.c=Calendar.getInstance();
        displayData();

        checkBox=findViewById(R.id.cv_time_set);
        checkBox.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicter();
            }
        });

        Intent intent =getIntent();
        String dates=intent.getStringExtra("date");
        date=findViewById(R.id.tv_plan_date);

        date.setText(dates);

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_plan_date:
                    Dialog_DatePicker();
                    break;
                case R.id.cv_time_set:
                    showTimePicter();
                    break;
                case R.id.btn_plan_check:
                    PlanData planData=new PlanData(title.getText().toString(),content.getText().toString(),date.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtra("plan",planData);
                    setResult(RESULT_OK, intent);
                    finish();
                    break;
            }
        }
    };

    public void showTimePicter(){
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h=hourOfDay;
                mi=minute;
                setAlarm();
            }
        },21,12,true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();
    }

    private void displayData(){
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        ((TextView)findViewById(R.id.tv_plan_date)).setText(format.format( this.c.getTime()));
        Log.e("f",""+this.c.getTime());
    }

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();
    }

    private void setAlarm(){

        this.c.set(Calendar.HOUR_OF_DAY,this.h);
        this.c.set(Calendar.MINUTE,this.mi);
        this.c.set(Calendar.SECOND,0);

        if(this.c.before(Calendar.getInstance())){
            Toast.makeText(this, "알람시간이 이전일순 없습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this,AlarReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
        Toast.makeText(this, "알람:"+format.format(c.getTime()), Toast.LENGTH_SHORT).show();

    }

    private void Dialog_DatePicker() {
         c = Calendar.getInstance();
        int cyear = c.get(Calendar.YEAR);
        int cmonth = c.get(Calendar.MONTH);
        int cday = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String _dateStr = year+"년 "+(monthOfYear + 1) + "월 " + dayOfMonth + "일";
                date=findViewById(R.id.tv_plan_date);
                date.setText(Integer.toString(year)+"-"+Integer.toString(monthOfYear+1)+"-"+Integer.toString(dayOfMonth));

            }
        };
        DatePickerDialog alert = new DatePickerDialog(this, mDateSetListener, cyear, cmonth, cday);
        alert.show();
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