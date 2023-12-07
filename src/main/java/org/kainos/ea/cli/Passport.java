package org.kainos.ea.cli;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "expiry_year")
    private int expiryYear;

    @Column(name = "expiry_month")
    private int expiryMonth;

    @Column(name = "expiry_day")
    private int expiryDay;

    @Column(name = "issued_year")
    private int issuedYear;

    @Column(name = "issued_month")
    private int issuedMonth;

    @Column(name = "issued_day")
    private int issuedDay;

    public Passport() {
        
    }
    
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryDay() {
        return expiryDay;
    }

    public void setExpiryDay(int expiryDay) {
        this.expiryDay = expiryDay;
    }

    public int getIssuedYear() {
        return issuedYear;
    }

    public void setIssuedYear(int issuedYear) {
        this.issuedYear = issuedYear;
    }

    public int getIssuedMonth() {
        return issuedMonth;
    }

    public void setIssuedMonth(int issuedMonth) {
        this.issuedMonth = issuedMonth;
    }

    public int getIssuedDay() {
        return issuedDay;
    }

    public void setIssuedDay(int issuedDay) {
        this.issuedDay = issuedDay;
    }
}

