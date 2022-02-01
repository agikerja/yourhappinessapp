package com.ta.yourhappinessproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ta.yourhappinessproject.Model.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    //definisi
    ApiInterface mApiInterface;
    EditText ieUsername, iePassword;
    Button btnLogin;
    TextView tbRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ieUsername = findViewById(R.id.ieUsername);
        iePassword = findViewById(R.id.iePassword);
        btnLogin = findViewById(R.id.btnLogin);
        tbRegister = findViewById(R.id.tbRegister);
        //inisiasi koneksi
        mApiInterface = ApiHelper.getClient().create(ApiInterface.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
        tbRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Login(){
        //panggil koneksi untuk request
        ApiInterface mApiInterface = ApiHelper.getClient().create(ApiInterface.class);
        Call<LoginModel> call = mApiInterface.login(
                ieUsername.getText().toString(),
                iePassword.getText().toString());
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                //response dari backend
                if(response.isSuccessful()){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    //tes
                }else{
                    Log.d("RETRO", "ON FAIL : " + response.message());
                }

            }
            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.d("RETRO", "ON FAIL : " + t.getMessage());
                Toast.makeText(getApplicationContext(), "Gagal update user", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
