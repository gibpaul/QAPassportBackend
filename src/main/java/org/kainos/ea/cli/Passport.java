package org.kainos.ea.cli;

import java.util.Date;

public class Passport {
    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Passport(int passportId, int applicantId, Date applicationDate) {
        this.passportId = passportId;
        this.applicantId = applicantId;
        this.applicationDate = applicationDate;
    }

    private int passportId;
    private int applicantId;
    private Date applicationDate;
}
