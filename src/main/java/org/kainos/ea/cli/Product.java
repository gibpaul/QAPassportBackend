package org.kainos.ea.cli;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "braille_sticker")
    private boolean brailleSticker;

    @Column(name = "extra_large_passport")
    private boolean extraLargePassport;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_level")
    private ServiceLevel serviceLevel;

    public Product() {
        
    }
    
    public boolean isBrailleSticker() {
        return brailleSticker;
    }

    public void setBrailleSticker(boolean brailleSticker) {
        this.brailleSticker = brailleSticker;
    }

    public boolean isExtraLargePassport() {
        return extraLargePassport;
    }

    public void setExtraLargePassport(boolean extraLargePassport) {
        this.extraLargePassport = extraLargePassport;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(ServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
    }
}
