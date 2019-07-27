package com.phone_auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button submitBtn;
    private EditText phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitBtn = findViewById(R.id.submit);
        phoneText = findViewById(R.id.phone_text);
        buttonSubmitListener();
    }

    private void buttonSubmitListener(){
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO : Cek string edittext kosong atau tidak
                if(!phoneText.getText().toString().isEmpty()){
                    if(phoneText.getText().toString().charAt(0) == '0'){
                        String temp = "+62" + phoneText.getText().toString().substring(1);

                        // TODO : Passing phone number ke OTP Activity
                        Bundle bundle = new Bundle();
                        Intent intent = new Intent(MainActivity.this, OtpActivity.class);
                        bundle.putString("phone", temp);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Masukkan nomor telpon", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
