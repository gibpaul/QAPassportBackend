package org.kainos.ea.cli;

public class Delivery {
    private int id;
    @SuppressWarnings("unused")
    private Address passportDeliveryAddress;
    @SuppressWarnings("unused")
    private Address documentsDeliveryAddress;
    @SuppressWarnings("unused")
    private boolean requireSecureDocumentDelivery;

    public Delivery() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Address getPassportDeliveryAddress() {
        return passportDeliveryAddress;
    }

    public Address getDocumentsDeliveryAddress() {
        return documentsDeliveryAddress;
    }

    public boolean isRequireSecureDocumentDelivery() {
        return requireSecureDocumentDelivery;
    }

}
