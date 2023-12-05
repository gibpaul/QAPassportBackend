package org.kainos.ea.api;

import org.kainos.ea.cli.Passport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassportService {
    public List<Passport> getAllPassports() {
        List<Passport> passportList = new ArrayList<>();
        Passport passport1 = new Passport(1, 1, new Date());
        Passport passport2 = new Passport(2, 2, new Date());

        passportList.add(passport1);
        passportList.add(passport2);

        return passportList;
    }
}
