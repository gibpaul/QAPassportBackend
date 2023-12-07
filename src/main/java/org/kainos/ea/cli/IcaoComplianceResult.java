package org.kainos.ea.cli;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "icao_compliance_results")
public class IcaoComplianceResult {
    @Id
    @Column(name = "compliance_id")
    private String complianceId;

    private boolean pass;

    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facial_image_id")
    private FacialImage facialImage;

    public IcaoComplianceResult() {
        
    }

    public String getComplianceId() {
        return complianceId;
    }

    public void setComplianceId(String complianceId) {
        this.complianceId = complianceId;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
