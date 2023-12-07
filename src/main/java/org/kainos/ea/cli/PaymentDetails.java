package org.kainos.ea.cli;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "payment_reference_number")
    private String paymentReferenceNumber;

    @Column(name = "passport_cost_in_pence")
    private int passportCostInPence;

    @Column(name = "amount_paid_in_pence")
    private int amountPaidInPence;

    @Column(name = "special_delivery_cost_in_pence")
    private int specialDeliveryCostInPence;

    @Column(name = "authorisation_code")
    private String authorisationCode;

    @Column(name = "masked_card_number")
    private String maskedCardNumber;

    @Column(name = "merchant_transaction_date_time")
    private LocalDateTime merchantTransactionDateTime;

    @Column(name = "transaction_date_time")
    private LocalDateTime transactionDateTime;

    @Column(name = "overseas_delivery_cost_in_pence")
    private Integer overseasDeliveryCostInPence;

    @Column(name = "extra_large_passport_cost_in_pence")
    private Integer extraLargePassportCostInPence;

    public PaymentDetails() {
        
    }
    
    public String getPaymentReferenceNumber() {
        return paymentReferenceNumber;
    }

    public void setPaymentReferenceNumber(String paymentReferenceNumber) {
        this.paymentReferenceNumber = paymentReferenceNumber;
    }

    public int getPassportCostInPence() {
        return passportCostInPence;
    }

    public void setPassportCostInPence(int passportCostInPence) {
        this.passportCostInPence = passportCostInPence;
    }

    public int getAmountPaidInPence() {
        return amountPaidInPence;
    }

    public void setAmountPaidInPence(int amountPaidInPence) {
        this.amountPaidInPence = amountPaidInPence;
    }

    public int getSpecialDeliveryCostInPence() {
        return specialDeliveryCostInPence;
    }

    public void setSpecialDeliveryCostInPence(int specialDeliveryCostInPence) {
        this.specialDeliveryCostInPence = specialDeliveryCostInPence;
    }

    public String getAuthorisationCode() {
        return authorisationCode;
    }

    public void setAuthorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    public LocalDateTime getMerchantTransactionDateTime() {
        return merchantTransactionDateTime;
    }

    public void setMerchantTransactionDateTime(LocalDateTime merchantTransactionDateTime) {
        this.merchantTransactionDateTime = merchantTransactionDateTime;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public Integer getOverseasDeliveryCostInPence() {
        return overseasDeliveryCostInPence;
    }

    public void setOverseasDeliveryCostInPence(Integer overseasDeliveryCostInPence) {
        this.overseasDeliveryCostInPence = overseasDeliveryCostInPence;
    }

    public Integer getExtraLargePassportCostInPence() {
        return extraLargePassportCostInPence;
    }

    public void setExtraLargePassportCostInPence(Integer extraLargePassportCostInPence) {
        this.extraLargePassportCostInPence = extraLargePassportCostInPence;
    }
}

