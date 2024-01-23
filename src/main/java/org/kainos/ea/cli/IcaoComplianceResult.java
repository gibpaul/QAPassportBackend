package org.kainos.ea.cli;

public class IcaoComplianceResult {
    @SuppressWarnings("unused")
    private String complianceId;
    @SuppressWarnings("unused")
    private boolean pass;
    @SuppressWarnings("unused")
    private int score;

    public IcaoComplianceResult() {

    }

    public String getComplianceId() {
        return complianceId;
    }

    public boolean isPass() {
        return pass;
    }

    public int getScore() {
        return score;
    }
}
