package com.example.ashwin.nayaghar;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    LoginDataBaseAdapter loginDataBaseAdapter;

    Button btnCreateAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        final AutoCompleteTextView Pname= (AutoCompleteTextView) findViewById(R.id.register_name);
        final AutoCompleteTextView Paddress= (AutoCompleteTextView) findViewById(R.id.register_address);
        final AutoCompleteTextView email= (AutoCompleteTextView) findViewById(R.id.register_email);
        final AutoCompleteTextView editTextPassword = (AutoCompleteTextView) findViewById(R.id.register_password);
        final AutoCompleteTextView rpassword= (AutoCompleteTextView) findViewById(R.id.register_rpassword);
        final AutoCompleteTextView Pcontact= (AutoCompleteTextView) findViewById(R.id.register_contact);

        btnCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String userName = email.getText().toString();
                String password = editTextPassword .getText().toString();
                String confirmPassword = rpassword.getText().toString();

                String name=Pname.getText().toString();
                String contact=Pcontact.getText().toString();
                String address=Paddress.getText().toString();


                if (userName.equals("") || password.equals("")
                        || confirmPassword.equals("")) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                final AutoCompleteTextView register_email = (AutoCompleteTextView) findViewById(R.id.register_email);
                String username = register_email.getText().toString();
                String checkname = loginDataBaseAdapter.checkemail(userName);
                if (username.equals(checkname)) {
                    Toast.makeText(Register.this, "USERNAME ALREADY TAKEN!! TRY NEW ONE", Toast.LENGTH_LONG).show();

                }
                else {
                    if (!password.equals(confirmPassword)) {
                        Toast.makeText(getApplicationContext(),
                                "Password does not match", Toast.LENGTH_LONG)
                                .show();
                        return;
                    } else {

                        loginDataBaseAdapter.insertEntry(name, address, userName, password, contact);
                        Toast.makeText(getApplicationContext(),
                                "Account Successfully Created ", Toast.LENGTH_LONG)
                                .show();
                        Intent i = new Intent(Register.this,
                                Login.class);
                        startActivity(i);
                        finish();

                    }
                }
            }

        });


    }

  /*  public void ddbutton(View view) {
        final AutoCompleteTextView pass1= (AutoCompleteTextView) findViewById(R.id.register_password);
        final AutoCompleteTextView pass2= (AutoCompleteTextView) findViewById(R.id.register_rpassword);
        String register_password=pass1.getText().toString();
        String register_rpassword=pass2.getText().toString();
        if(!register_password.equals(register_rpassword)){
            Toast pass=Toast.makeText(Register.this,"Password Don't match",Toast.LENGTH_LONG);
        pass.show();
        }
        else {
        Intent i;
        i = new Intent(this, Dogdetail.class);
        startActivity(i);}
    }*/

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }

}
