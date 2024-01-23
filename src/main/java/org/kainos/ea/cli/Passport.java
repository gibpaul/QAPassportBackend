package org.kainos.ea.cli;

public class Passport {
    private int id;
    @SuppressWarnings("unused")
    private String passportNumber;
    @SuppressWarnings("unused")
    private int expiryYear;
    @SuppressWarnings("unused")
    private int expiryMonth;
    @SuppressWarnings("unused")
    private int expiryDay;
    @SuppressWarnings("unused")
    private int issuedYear;
    @SuppressWarnings("unused")
    private int issuedMonth;
    @SuppressWarnings("unused")
    private int issuedDay;

    public Passport() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPassportNumber() {
        return passportNumber;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public int getExpiryDay() {
        return expiryDay;
    }

    public int getIssuedYear() {
        return issuedYear;
    }

    public int getIssuedMonth() {
        return issuedMonth;
    }

    public int getIssuedDay() {
        return issuedDay;
    }

}

