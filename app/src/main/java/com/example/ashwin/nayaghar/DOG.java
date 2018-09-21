package com.example.ashwin.nayaghar;

/**
 * Created by Ashwin on 2/1/2017.
 */
public class DOG {
    private int DID;
    private byte[] PHOTO;
    private String DNAME;
    private String Vaccination;
    private int AGE;
    private String GENDER;
    private String BREED;
    private String DESCRIPTION;


    public DOG(int DID, byte[] PHOTO, String DNAME, String vaccination, int AGE, String GENDER, String BREED, String DESCRIPTION) {
        this.DID = DID;
        this.PHOTO = PHOTO;
        this.DNAME = DNAME;
        Vaccination = vaccination;
        this.AGE = AGE;
        this.GENDER = GENDER;
        this.BREED = BREED;
        this.DESCRIPTION = DESCRIPTION;
    }


    public int getDID() {
        return DID;
    }

    public void setDID(int DID) {
        this.DID = DID;
    }

    public byte[] getPHOTO() {
        return PHOTO;
    }

    public void setPHOTO(byte[] PHOTO) {
        this.PHOTO = PHOTO;
    }

    public String getDNAME() {
        return DNAME;
    }

    public void setDNAME(String DNAME) {
        this.DNAME = DNAME;
    }

    public String getVaccination() {
        return Vaccination;
    }

    public void setVaccination(String vaccination) {
        Vaccination = vaccination;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getBREED() {
        return BREED;
    }

    public void setBREED(String BREED) {
        this.BREED = BREED;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
