package org.kainos.ea.cli;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nationalities")
public class Nationality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "dual_national")
    private boolean dualNational;

    public Nationality() {
        
    }

    private boolean isDualNational() {
        return dualNational;
    }

    private void setDualNational(boolean dualNational) {
        this.dualNational = dualNational;
    }
}
