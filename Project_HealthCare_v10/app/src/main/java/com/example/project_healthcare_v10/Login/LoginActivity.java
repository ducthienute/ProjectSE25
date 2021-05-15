package com.example.project_healthcare_v10.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_healthcare_v10.Main.MainBar.MainActivity;
import com.example.project_healthcare_v10.R;


public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private EditText etxtUsername, etxtPassword;
    private Button btnLogin, btnSignup;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initPresenter();
        initView();
        initAction();

        //loginSuccess();
    }

    // INIT
    private void initPresenter() {
        presenter = new LoginPresenter();
        presenter.setView(this);
    }

    private void initView() {
        etxtUsername = (EditText) findViewById(R.id.editTextUsername);
        etxtPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnSignup = (Button) findViewById(R.id.buttonSignup);
    }

    private void initAction() {
        btnLogin.setOnClickListener(v -> presenter.handleLogin(etxtUsername.getText().toString(), etxtPassword.getText().toString()));
        btnSignup.setOnClickListener(v -> { });
    }

    // OVERRIDE
    @Override
    public void loginSuccess() {
        //Chuyển sang Activity Main bằng cách thoát activity này
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void loginFailure(String error) {
        etxtPassword.setText("");
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
}