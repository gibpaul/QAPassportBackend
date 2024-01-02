package org.kainos.ea.cli;

public class Product {
    private int id;
    @SuppressWarnings("unused")
    private boolean brailleSticker;
    @SuppressWarnings("unused")
    private boolean extraLargePassport;
    @SuppressWarnings("unused")
    private ServiceLevel serviceLevel;

    public Product() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isBrailleSticker() {
        return brailleSticker;
    }

    public boolean isExtraLargePassport() {
        return extraLargePassport;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

}
