package com.example.Code_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e;
    TextView t1,t2;
    public static final int TEXT_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=findViewById(R.id.EnterMessage);
        t1=findViewById(R.id.text_header);
        t2=findViewById(R.id.message_reply);
    }
        public void onActivityResult(int requestCode,
        int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == TEXT_REQUEST) {
                if (resultCode == RESULT_OK) {
                    String reply =
                            data.getStringExtra(MainActivity2.EXTRA_REPLY);
                    t1.setVisibility(View.VISIBLE);
                    t2.setText(reply);
                    t2.setVisibility(View.VISIBLE);
                }
            }
        }


    public void EnterMessage(View view) {
        String data=et.getText().toString();
        if (data.isEmpty()){
            Toast.makeText(this, "Please Enter Message", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent I = new Intent(this, MainActivity2.class);
            I.putExtra("mydata", data);
            startActivityForResult(I, TEXT_REQUEST);
        }
    }
}