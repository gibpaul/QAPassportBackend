package org.kainos.ea.cli;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "submission_date_time")
    private LocalDateTime submissionDateTime;
    
    @Enumerated(EnumType.STRING)
    private ApplicationType type;

    @Column(name = "documents_required")
    private boolean documentsRequired;
    
    private String source;
    
    @Column(name = "processing_centre")
    private String processingCentre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    
    @Column(name = "applying_from_overseas")
    private boolean applyingFromOverseas;
    
    @Column(name = "csig_required")
    private boolean csigRequired;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_details_id")
    private PaymentDetails paymentDetails;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    
    @Column(name = "welsh_application")
    private boolean welshApplication;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private DocumentType documentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "dcs_threat_level")
    private DCSThreatLevel DCSThreatLevel;
    
    @Column(name = "urgent_or_compassionate")
    private boolean urgentOrCompassionate;
    
    @Enumerated(EnumType.STRING)
    private Medium medium;

    @Column(name = "able_to_sign")
    private boolean ableToSign;

    @Column(name = "unable_to_sign_reason")
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

    public void setSubmissionDateTime(LocalDateTime submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }

    public ApplicationType getType() {
        return type;
    }

    public void setType(ApplicationType type) {
        this.type = type;
    }

    public boolean isDocumentsRequired() {
        return documentsRequired;
    }

    public void setDocumentsRequired(boolean documentsRequired) {
        this.documentsRequired = documentsRequired;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getProcessingCentre() {
        return processingCentre;
    }

    public void setProcessingCentre(String processingCentre) {
        this.processingCentre = processingCentre;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isApplyingFromOverseas() {
        return applyingFromOverseas;
    }

    public void setApplyingFromOverseas(boolean applyingFromOverseas) {
        this.applyingFromOverseas = applyingFromOverseas;
    }

    public boolean isCsigRequired() {
        return csigRequired;
    }

    public void setCsigRequired(boolean csigRequired) {
        this.csigRequired = csigRequired;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public boolean isWelshApplication() {
        return welshApplication;
    }

    public void setWelshApplication(boolean welshApplication) {
        this.welshApplication = welshApplication;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DCSThreatLevel getDCSThreatLevel() {
        return DCSThreatLevel;
    }

    public void setDCSThreatLevel(DCSThreatLevel DCSThreatLevel) {
        this.DCSThreatLevel = DCSThreatLevel;
    }

    public boolean isUrgentOrCompassionate() {
        return urgentOrCompassionate;
    }

    public void setUrgentOrCompassionate(boolean urgentOrCompassionate) {
        this.urgentOrCompassionate = urgentOrCompassionate;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public boolean isAbleToSign() {
        return ableToSign;
    }

    public void setAbleToSign(boolean ableToSign) {
        this.ableToSign = ableToSign;
    }

    public String getUnableToSignReason() {
        return unableToSignReason;
    }

    public void setUnableToSignReason(String unableToSignReason) {
        this.unableToSignReason = unableToSignReason;
    }
}
