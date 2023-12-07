package org.kainos.ea.cli;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_delivery_address_id")
    private Address passportDeliveryAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documents_delivery_address_id")
    private Address documentsDeliveryAddress;

    @Column(name = "require_secure_document_delivery")
    private boolean requireSecureDocumentDelivery;

    public Delivery() {
        
    }
    
    public Address getPassportDeliveryAddress() {
        return passportDeliveryAddress;
    }

    public void setPassportDeliveryAddress(Address passportDeliveryAddress) {
        this.passportDeliveryAddress = passportDeliveryAddress;
    }

    public Address getDocumentsDeliveryAddress() {
        return documentsDeliveryAddress;
    }

    public void setDocumentsDeliveryAddress(Address documentsDeliveryAddress) {
        this.documentsDeliveryAddress = documentsDeliveryAddress;
    }

    public boolean isRequireSecureDocumentDelivery() {
        return requireSecureDocumentDelivery;
    }

    public void setRequireSecureDocumentDelivery(boolean requireSecureDocumentDelivery) {
        this.requireSecureDocumentDelivery = requireSecureDocumentDelivery;
    }
}
