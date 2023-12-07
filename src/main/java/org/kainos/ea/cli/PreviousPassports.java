package org.kainos.ea.cli;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "previous_passports")
public class PreviousPassports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_passport_id")
    private Passport applicationPassport;

    @ManyToMany
    @JoinTable(
        name = "previous_passports_passport",
        joinColumns = @JoinColumn(name = "previous_passports_id"),
        inverseJoinColumns = @JoinColumn(name = "passport_id")
    )
    private List<Passport> uncancelledPassports;

    public PreviousPassports() {
        
    }
    
    public Passport getApplicationPassport() {
        return applicationPassport;
    }

    public void setApplicationPassport(Passport applicationPassport) {
        this.applicationPassport = applicationPassport;
    }

    public List<Passport> getUncancelledPassports() {
        return uncancelledPassports;
    }

    public void setUncancelledPassports(List<Passport> uncancelledPassports) {
        this.uncancelledPassports = uncancelledPassports;
    }
}
