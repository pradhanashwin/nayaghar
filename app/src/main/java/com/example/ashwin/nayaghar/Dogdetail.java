package com.example.ashwin.nayaghar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Dogdetail extends AppCompatActivity {
    LoginDataBaseAdapter loginDataBaseAdapter;

    private static final int SELECTED_PICTURE = 1;
    private ImageView iv;
    private Spinner spinner1;
    String dogVac = "";

    public void RadioButtonClicked1(View view) {

//This variable will store whether the dog was vaccinated or not

// Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

// Check which radio button was clicked
        switch (view.getId()) {
            case R.id.d_vac1:
                if (checked)
                    dogVac = "Vaccinated";
                break;
            case R.id.d_vac2:
                if (checked)
                    dogVac = "Non Vaccinated";
                break;
        }
    }

    String dGender = "";

    public void RadioButtonClicked2(View view) {

//This variable will store whether the user was male or female

// Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

// Check which radio button was clicked
        switch (view.getId()) {
            case R.id.d_gen1:
                if (checked)
                    dGender = "Male";
                break;
            case R.id.d_gen2:
                if (checked)
                    dGender = "Female";
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogdetail);


        final AutoCompleteTextView d_name = (AutoCompleteTextView) findViewById(R.id.d_name);
        final AutoCompleteTextView d_age = (AutoCompleteTextView) findViewById(R.id.d_age);
        final RadioButton d_vac1 = (RadioButton) findViewById(R.id.d_vac1);

        String vaccination = d_vac1.getText().toString();

        final RadioButton d_vac2 = (RadioButton) findViewById(R.id.d_vac2);
        final RadioButton d_gen1 = (RadioButton) findViewById(R.id.d_gen1);
        String gender = d_gen1.getText().toString();
        final RadioButton d_gen2 = (RadioButton) findViewById(R.id.d_gen2);
        //    final Spinner breed= (Spinner) findViewById(R.id.spinner1);
        final AutoCompleteTextView d_description = (AutoCompleteTextView) findViewById(R.id.d_description);
        Button register = (Button) findViewById(R.id.register1);
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        final String breed = spinner.getSelectedItem().toString();
        //get reference
        iv = (ImageView) findViewById(R.id.imageView3);
        addListenerOnSpinnerItemSelection();


        register = (Button) findViewById(R.id.register1);
        assert register != null;
        register.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String Name = d_name.getText().toString();
                String age = d_age.getText().toString();
                String vac = dogVac;
                String gender = dGender;
                String Des = d_description.getText().toString();
                Spinner spinner = (Spinner) findViewById(R.id.spinner1);
                String breed = spinner.getSelectedItem().toString();

                String byteArray = "";
                if (image != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byteArray = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
                }

                loginDataBaseAdapter = new LoginDataBaseAdapter(Dogdetail.this);
                loginDataBaseAdapter = loginDataBaseAdapter.open();
                loginDataBaseAdapter.insertdog(byteArray, age, Name, vac, gender, breed, Des);
                Intent i = new Intent(Dogdetail.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });


    }


    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);


    }


    public void onImage(View view) {
        Intent i;
        i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, SELECTED_PICTURE);
    }

    Bitmap image = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SELECTED_PICTURE:
                if (resultCode == RESULT_OK) {
                    Uri imageUri = data.getData();
                    InputStream inputStream;
                    try {
                        inputStream = getContentResolver().openInputStream(imageUri);
                        //get bitmap from a stream
                        //show image to user


                        image = BitmapFactory.decodeStream(inputStream);
                        iv.setImageBitmap(image);

                        //if (null != imageUri) {

                        // Saving to Database...
                        //   if (saveImageInDB(imageUri)) {
                        //         showMessage("Image Saved in Database...");
                        // iv.setImageURI(imageUri);
                        //  }
                        // }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "unable to open the image", Toast.LENGTH_LONG).show();
                    }

                }

        }

    }


    public void insertImage(byte[] inputData) {

    }


    Boolean saveImageInDB(Uri selectedImageUri) {

        try {
            loginDataBaseAdapter.open();
            InputStream iStream = getContentResolver().openInputStream(selectedImageUri);
            byte[] inputData = Utils.getBytes(iStream);
            insertImage(inputData);

            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            Toast.makeText(this, "unable to open the image", Toast.LENGTH_LONG).show();
            //Log.e(TAG, "<saveImageInDB> Error : " + ioe.getLocalizedMessage());
            //loginDataBaseAdapter.close();
            return false;
        }

    }


}
