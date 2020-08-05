package com.example.tola.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tola.Data.PostData;
import com.example.tola.R;

import java.io.InputStream;

public class Write_post_Activity extends AppCompatActivity {

    private static final String TAG= "WritePost";
    private ImageView imageView;
    private EditText title;
    private EditText content;

    private String path;
    private Uri uri;

    private String saveTitle;
    private String saveContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        Log.e(TAG, "onCreate");
        imageView=findViewById(R.id.iv_post_image);
        title=findViewById(R.id.et_post_title);
        content=findViewById(R.id.et_post_content);

        findViewById(R.id.lay_get_post_image).setOnClickListener(onClickListener);
        findViewById(R.id.bt_post_check).setOnClickListener(onClickListener);


    }

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.lay_get_post_image:
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(intent, 12);
                    break;

                case R.id.bt_post_check:


                    PostData postData=new PostData(title.getText().toString(),content.getText().toString(),uri.toString(),"나","2015");
                    Intent reintent = new Intent();
                    reintent.putExtra("post",postData);
                    setResult(RESULT_OK, reintent);
                    finish();





                    break;
            }


        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12) {
            if (resultCode == RESULT_OK) {
                try {
                    uri=data.getData();
                    path = data.getStringExtra(getRealPathFromURI(uri));
                    imageView.setImageURI(uri);

                } catch (Exception e) {

                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }

    private String getRealPathFromURI(Uri contentURI) {

        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);

        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();

        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }

        return result;
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

        title=findViewById(R.id.et_post_title);
        content=findViewById(R.id.et_post_content);

        saveTitle=title.getText().toString();
        saveContent=content.getText().toString();
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