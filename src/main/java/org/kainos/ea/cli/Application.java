package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class Application {
    private UUID id;
    @SuppressWarnings("unused")
    private LocalDateTime submissionDateTime;
    @SuppressWarnings("unused")
    private ApplicationType type;
    @SuppressWarnings("unused")
    private boolean documentsRequired;
    @SuppressWarnings("unused")
    private String source;
    @SuppressWarnings("unused")
    private String processingCentre;
    @SuppressWarnings("unused")
    private Applicant applicant;
    @SuppressWarnings("unused")
    private Product product;
    @SuppressWarnings("unused")
    private boolean applyingFromOverseas;
    @SuppressWarnings("unused")
    private boolean csigRequired;
    @SuppressWarnings("unused")
    private PaymentDetails paymentDetails;
    @SuppressWarnings("unused")
    private Delivery delivery;
    @SuppressWarnings("unused")
    private boolean welshApplication;
    @SuppressWarnings("unused")
    private DocumentType documentType;
    @JsonProperty("DCSThreatLevel")
    private DCSThreatLevel DCSThreatLevel;
    @SuppressWarnings("unused")
    private boolean urgentOrCompassionate;
    @SuppressWarnings("unused")
    private Medium medium;
    @SuppressWarnings("unused")
    private boolean ableToSign;
    @SuppressWarnings("unused")
    private String unableToSignReason;

    public Application() {
        
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getSubmissionDateTime() {
        return submissionDateTime;
    }

    public ApplicationType getType() {
        return type;
    }

    public boolean isDocumentsRequired() {
        return documentsRequired;
    }

    public String getSource() {
        return source;
    }

    public String getProcessingCentre() {
        return processingCentre;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isApplyingFromOverseas() {
        return applyingFromOverseas;
    }

    public boolean isCsigRequired() {
        return csigRequired;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public boolean isWelshApplication() {
        return welshApplication;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public DCSThreatLevel getDCSThreatLevel() {
        return DCSThreatLevel;
    }

    public boolean isUrgentOrCompassionate() {
        return urgentOrCompassionate;
    }

    public Medium getMedium() {
        return medium;
    }

    public boolean isAbleToSign() {
        return ableToSign;
    }

    public String getUnableToSignReason() {
        return unableToSignReason;
    }
}
