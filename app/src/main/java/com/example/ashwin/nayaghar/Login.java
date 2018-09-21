package com.example.ashwin.nayaghar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    LoginDataBaseAdapter loginDataBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logn);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        final AutoCompleteTextView editTextEmail = (AutoCompleteTextView) findViewById(R.id.email);
        final EditText editTextPassword = (EditText) findViewById(R.id.password);

        Button btnSignIn = (Button) findViewById(R.id.buttonSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String storedPassword = loginDataBaseAdapter
                        .getSinlgeEntry(userName);
                if (password.equals(storedPassword)) {
                    Toast.makeText(Login.this,
                            "Congrats: Login Successful", Toast.LENGTH_LONG)
                            .show();

                    Intent main = new Intent(Login.this, Dogdetail.class);
                    startActivity(main);
                } else {
                    Toast.makeText(Login.this,
                            "User Name or Password does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onClick3(View view) {
        Intent i;
        i = new Intent(this, Register.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }


}
