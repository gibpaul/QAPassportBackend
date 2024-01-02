package org.kainos.ea.cli;

public class Name {
    private int id;
    @SuppressWarnings("unused")
    private String surname;
    @SuppressWarnings("unused")
    private String forenames;

    public Name() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getSurname() {
        return surname;
    }

    public String getForenames() {
        return forenames;
    }

}
