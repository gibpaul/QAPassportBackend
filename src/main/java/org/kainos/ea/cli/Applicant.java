package org.kainos.ea.cli;

import java.time.LocalDate;

public class Applicant {
    private int id;
    @SuppressWarnings("unused")
    private String title;
    @SuppressWarnings("unused")
    private ApplicantType type;
    @SuppressWarnings("unused")
    private Name name;
    @SuppressWarnings("unused")
    private Gender gender;
    @SuppressWarnings("unused")
    private LocalDate dateOfBirth;
    @SuppressWarnings("unused")
    private String placeOfBirth;
    @SuppressWarnings("unused")
    private String countryOfBirthCode;
    @SuppressWarnings("unused")
    private String email;
    @SuppressWarnings("unused")
    private String mobileNumber;
    @SuppressWarnings("unused")
    private String alternativeNumber;
    @SuppressWarnings("unused")
    private boolean smsNotification;
    @SuppressWarnings("unused")
    private boolean emailNotification;
    @SuppressWarnings("unused")
    private FacialImage facialImage;
    @SuppressWarnings("unused")
    private Address currentAddress;
    @SuppressWarnings("unused")
    private Nationality nationality;
    @SuppressWarnings("unused")
    private PreviousPassports previousPassports;

    public Applicant() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public ApplicantType getType() {
        return type;
    }

    public Name getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getCountryOfBirthCode() {
        return countryOfBirthCode;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAlternativeNumber() {
        return alternativeNumber;
    }

    public boolean isSmsNotification() {
        return smsNotification;
    }

    public boolean isEmailNotification() {
        return emailNotification;
    }

    public FacialImage getFacialImage() {
        return facialImage;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public PreviousPassports getPreviousPassports() {
        return previousPassports;
    }
}
