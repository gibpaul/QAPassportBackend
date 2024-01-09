package org.kainos.ea.cli;

public class Nationality {
    private int id;
    @SuppressWarnings("unused")
    private boolean dualNational;

    public Nationality() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDualNational() {
        return dualNational;
    }

}
