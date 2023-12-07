package org.kainos.ea.cli;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String title;

    @Enumerated(EnumType.STRING)
    private ApplicantType type;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id")
    private Name name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "country_of_birth_code")
    private String countryOfBirthCode;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "alternative_number")
    private String alternativeNumber;

    @Column(name = "sms_notification")
    private boolean smsNotification;

    @Column(name = "email_notification")
    private boolean emailNotification;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "facial_image_id")
    private FacialImage facialImage;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "current_address_id")
    private Address currentAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_passports_id")
    private PreviousPassports previousPassports;

    public Applicant() {
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ApplicantType getType() {
        return type;
    }

    public void setType(ApplicantType type) {
        this.type = type;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCountryOfBirthCode() {
        return countryOfBirthCode;
    }

    public void setCountryOfBirthCode(String countryOfBirthCode) {
        this.countryOfBirthCode = countryOfBirthCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAlternativeNumber() {
        return alternativeNumber;
    }

    public void setAlternativeNumber(String alternativeNumber) {
        this.alternativeNumber = alternativeNumber;
    }

    public boolean isSmsNotification() {
        return smsNotification;
    }

    public void setSmsNotification(boolean smsNotification) {
        this.smsNotification = smsNotification;
    }

    public boolean isEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public FacialImage getFacialImage() {
        return facialImage;
    }

    public void setFacialImage(FacialImage facialImage) {
        this.facialImage = facialImage;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public PreviousPassports getPreviousPassports() {
        return previousPassports;
    }

    public void setPreviousPassports(PreviousPassports previousPassports) {
        this.previousPassports = previousPassports;
    }
}
