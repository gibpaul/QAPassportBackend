package org.kainos.ea.cli;

import java.util.List;

public class PreviousPassports {
    private int id;
    @SuppressWarnings("unused")
    private Passport applicationPassport;
    @SuppressWarnings("unused")
    private List<Passport> uncancelledPassports;

    public PreviousPassports() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Passport getApplicationPassport() {
        return applicationPassport;
    }

    public List<Passport> getUncancelledPassports() {
        return uncancelledPassports;
    }

}
