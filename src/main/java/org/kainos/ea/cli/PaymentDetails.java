package org.kainos.ea.cli;

import java.time.LocalDateTime;

public class PaymentDetails {
    private int id;
    @SuppressWarnings("unused")
    private String paymentReferenceNumber;
    @SuppressWarnings("unused")
    private int passportCostInPence;
    @SuppressWarnings("unused")
    private int amountPaidInPence;
    @SuppressWarnings("unused")
    private int specialDeliveryCostInPence;
    @SuppressWarnings("unused")
    private String authorisationCode;
    @SuppressWarnings("unused")
    private String maskedCardNumber;
    @SuppressWarnings("unused")
    private LocalDateTime merchantTransactionDateTime;
    @SuppressWarnings("unused")
    private LocalDateTime transactionDateTime;
    @SuppressWarnings("unused")
    private Integer overseasDeliveryCostInPence;
    @SuppressWarnings("unused")
    private Integer extraLargePassportCostInPence;

    public PaymentDetails() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPaymentReferenceNumber() {
        return paymentReferenceNumber;
    }

    public int getPassportCostInPence() {
        return passportCostInPence;
    }

    public int getAmountPaidInPence() {
        return amountPaidInPence;
    }

    public int getSpecialDeliveryCostInPence() {
        return specialDeliveryCostInPence;
    }

    public String getAuthorisationCode() {
        return authorisationCode;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public LocalDateTime getMerchantTransactionDateTime() {
        return merchantTransactionDateTime;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public Integer getOverseasDeliveryCostInPence() {
        return overseasDeliveryCostInPence;
    }

    public Integer getExtraLargePassportCostInPence() {
        return extraLargePassportCostInPence;
    }

}

