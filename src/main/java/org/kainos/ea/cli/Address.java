package org.kainos.ea.cli;

public class Address {
    private int id;
    @SuppressWarnings("unused")
    private String line1;
    @SuppressWarnings("unused")
    private String line2;
    @SuppressWarnings("unused")
    private String townOrCity;
    @SuppressWarnings("unused")
    private String countryCode;
    @SuppressWarnings("unused")
    private String postcode;

    public Address() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getTownOrCity() {
        return townOrCity;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPostcode() {
        return postcode;
    }

}

