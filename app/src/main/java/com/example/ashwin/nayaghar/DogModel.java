package com.example.ashwin.nayaghar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.sql.Blob;

/**
 * Created by Ashwin on 2/5/2017.
 */
public class DogModel {
    String dogName;
   String dogPic;
    String dogAge;
    String dogVac ;
    String dogGender;
    String dogBreed ;
    String dogDescription;

    public DogModel(String dogName, String dogPic, String dogAge, String dogVac, String dogGender,
                    String dogBreed, String dogDescription) {
        this.dogName = dogName;
        this.dogPic = dogPic;
        this.dogAge = dogAge;
        this.dogVac = dogVac;
        this.dogGender = dogGender;
        this.dogBreed = dogBreed;
        this.dogDescription = dogDescription;
    }




    public String getDogName() {
        return dogName;
    }

    public String getDogPic() {return dogPic;  }

    public String getDogAge() {
        return dogAge;
    }

    public String getDogVac() {
        return dogVac;
    }

    public String getDogGender() { return dogGender; }

    public String getDogBreed() {
        return dogBreed;
    }

    public String getDogDescription() {
        return dogDescription;
    }
}
