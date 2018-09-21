package com.example.ashwin.nayaghar;

/**
 * Created by Ashwin on 2/5/2017.
 */
public class AdoptionModel {
    String dogName;
    String dogPic;
    String dogAge;
    String dogVac ;
    String dogGender;
    String dogBreed ;
    String dogDescription ;

    public String getDogName() {
        return dogName;
    }

    public String getDogPic() {
        return dogPic;
    }

    public String getDogAge() {
        return dogAge;
    }

    public String getDogVac() {
        return dogVac;
    }

    public String getDogGender() {
        return dogGender;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public String getDogDescription() {
        return dogDescription;
    }

    public AdoptionModel(String dogName, String dogPic, String dogAge, String dogVac, String dogGender,
                         String dogBreed, String dogDescription) {
        this.dogName = dogName;
        this.dogPic = dogPic;
        this.dogAge = dogAge;
        this.dogVac = dogVac;
        this.dogGender = dogGender;
        this.dogBreed = dogBreed;
        this.dogDescription = dogDescription;



    }





}
