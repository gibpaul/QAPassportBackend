package org.kainos.ea.daos;

import org.kainos.ea.cli.*;
import org.kainos.ea.db.DatabaseConnector;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationDAO {
    public int createApplication(Application application) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int result;
        Logger logger = Logger.getLogger(ApplicationDAO.class.getName());

        try {
            c = DatabaseConnector.getConnection();
            assert c != null;
            c.setAutoCommit(false);

            Address passportDeliveryAddress = application.getDelivery().getPassportDeliveryAddress();
            insertAddress(c, passportDeliveryAddress);

            Address documentsDeliveryAddress = application.getDelivery().getDocumentsDeliveryAddress();
            insertAddress(c, documentsDeliveryAddress);

            String sqlDelivery = "INSERT INTO deliveries (passport_delivery_address_id, documents_delivery_address_id, require_secure_document_delivery) VALUES (?, ?, ?)";
            ps = c.prepareStatement(sqlDelivery, Statement.RETURN_GENERATED_KEYS);

            Delivery delivery = application.getDelivery();
            ps.setObject(1, delivery.getPassportDeliveryAddress().getId());
            ps.setObject(2, delivery.getDocumentsDeliveryAddress().getId());
            ps.setBoolean(3, delivery.isRequireSecureDocumentDelivery());

            ps.executeUpdate();
            ResultSet rsDelivery = ps.getGeneratedKeys();
            if (rsDelivery.next()) {
                int deliveryId = rsDelivery.getInt(1);
                delivery.setId(deliveryId);
            }
            rsDelivery.close();
            ps.close();

            String sqlPaymentDetails = "INSERT INTO payment_details (payment_reference_number, passport_cost_in_pence, amount_paid_in_pence, special_delivery_cost_in_pence, authorisation_code, masked_card_number, merchant_transaction_date_time, transaction_date_time, overseas_delivery_cost_in_pence, extra_large_passport_cost_in_pence) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = c.prepareStatement(sqlPaymentDetails, Statement.RETURN_GENERATED_KEYS);

            PaymentDetails paymentDetails = application.getPaymentDetails();
            ps.setString(1, paymentDetails.getPaymentReferenceNumber());
            ps.setInt(2, paymentDetails.getPassportCostInPence());
            ps.setInt(3, paymentDetails.getAmountPaidInPence());
            ps.setInt(4, paymentDetails.getSpecialDeliveryCostInPence());
            ps.setString(5, paymentDetails.getAuthorisationCode());
            ps.setString(6, paymentDetails.getMaskedCardNumber());
            ps.setTimestamp(7, Timestamp.valueOf(paymentDetails.getMerchantTransactionDateTime()));
            ps.setTimestamp(8, Timestamp.valueOf(paymentDetails.getTransactionDateTime()));
            ps.setObject(9, paymentDetails.getOverseasDeliveryCostInPence());
            ps.setObject(10, paymentDetails.getExtraLargePassportCostInPence());

            ps.executeUpdate();
            ResultSet rsPaymentDetails = ps.getGeneratedKeys();
            if (rsPaymentDetails.next()) {
                int paymentDetailsId = rsPaymentDetails.getInt(1);
                paymentDetails.setId(paymentDetailsId);
            }
            rsPaymentDetails.close();
            ps.close();

            String sqlProduct = "INSERT INTO products (braille_sticker, extra_large_passport, service_level) VALUES (?, ?, ?)";
            ps = c.prepareStatement(sqlProduct, Statement.RETURN_GENERATED_KEYS);

            Product product = application.getProduct();
            ps.setBoolean(1, product.isBrailleSticker());
            ps.setBoolean(2, product.isExtraLargePassport());
            ps.setString(3, product.getServiceLevel().toString());

            ps.executeUpdate();
            ResultSet rsProduct = ps.getGeneratedKeys();
            if (rsProduct.next()) {
                int productId = rsProduct.getInt(1);
                product.setId(productId);
            }
            rsProduct.close();
            ps.close();

            Passport applicationPassport = application.getApplicant().getPreviousPassports().getApplicationPassport();
            insertPassport(c, applicationPassport);

            String sqlPreviousPassports = "INSERT INTO previous_passports (application_passport_id) VALUES (?)";
            ps = c.prepareStatement(sqlPreviousPassports, Statement.RETURN_GENERATED_KEYS);

            PreviousPassports previousPassports = application.getApplicant().getPreviousPassports();
            ps.setObject(1, previousPassports.getApplicationPassport().getId());

            ps.executeUpdate();
            ResultSet rsPreviousPassports = ps.getGeneratedKeys();
            if (rsPreviousPassports.next()) {
                int previousPassportsId = rsPreviousPassports.getInt(1);
                previousPassports.setId(previousPassportsId);
            }
            rsPreviousPassports.close();
            ps.close();

            for (Passport passport : previousPassports.getUncancelledPassports()) {
                insertPassport(c, passport);

                String sqlPreviousPassportsPassport = "INSERT INTO previous_passports_passport (previous_passports_id, passport_id) VALUES (?, ?)";
                ps = c.prepareStatement(sqlPreviousPassportsPassport);

                ps.setObject(1, previousPassports.getId());
                ps.setObject(2, passport.getId());

                ps.executeUpdate();
                ps.close();
            }

            String sqlNationality = "INSERT INTO nationalities (dual_national) VALUES (?)";
            ps = c.prepareStatement(sqlNationality, Statement.RETURN_GENERATED_KEYS);

            Nationality nationality = application.getApplicant().getNationality();
            ps.setBoolean(1, nationality.isDualNational());

            ps.executeUpdate();
            ResultSet rsNationality = ps.getGeneratedKeys();
            if (rsNationality.next()) {
                int nationalityId = rsNationality.getInt(1);
                nationality.setId(nationalityId);
            }
            rsNationality.close();
            ps.close();

            Address address = application.getApplicant().getCurrentAddress();
            insertAddress(c, address);

            String sqlFacialImage = "INSERT INTO facial_images (icao_compliant, icao_check_overridden, yaw, roll, pitch, right_eye_y, right_eye_x, left_eye_y, left_eye_x, image_type, base_64_contents, height, width, colour_space, image_dpi, image_source) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = c.prepareStatement(sqlFacialImage, Statement.RETURN_GENERATED_KEYS);

            FacialImage facialImage = application.getApplicant().getFacialImage();
            ps.setBoolean(1, facialImage.isIcaoCompliant());
            ps.setBoolean(2, facialImage.isIcaoCheckOverridden());
            ps.setDouble(3, facialImage.getYaw());
            ps.setDouble(4, facialImage.getRoll());
            ps.setDouble(5, facialImage.getPitch());
            ps.setInt(6, facialImage.getRightEyeY());
            ps.setInt(7, facialImage.getRightEyeX());
            ps.setInt(8, facialImage.getLeftEyeY());
            ps.setInt(9, facialImage.getLeftEyeX());
            ps.setString(10, facialImage.getImageType());
            ps.setString(11, facialImage.getBase64Contents());
            ps.setInt(12, facialImage.getHeight());
            ps.setInt(13, facialImage.getWidth());
            ps.setString(14, facialImage.getColourSpace());
            ps.setInt(15, facialImage.getImageDpi());
            ps.setString(16, facialImage.getImageSource());

            ps.executeUpdate();
            ResultSet rsFacialImage = ps.getGeneratedKeys();
            if (rsFacialImage.next()) {
                int facialImageId = rsFacialImage.getInt(1);
                facialImage.setId(facialImageId);
            }
            rsFacialImage.close();
            ps.close();

            String sqlIcaoComplianceResults = "INSERT INTO icao_compliance_results (facial_image_id, compliance_id, pass, score) VALUES (?, ?, ?, ?)";
            ps = c.prepareStatement(sqlIcaoComplianceResults);

            for (IcaoComplianceResult icaoComplianceResult : facialImage.getIcaoComplianceResults()) {
                ps.setInt(1, facialImage.getId());
                ps.setString(2, icaoComplianceResult.getComplianceId());
                ps.setBoolean(3, icaoComplianceResult.isPass());
                ps.setInt(4, icaoComplianceResult.getScore());
                ps.executeUpdate();
            }

            ps.close();

            String sqlName = "INSERT INTO names (surname, forenames) VALUES (?, ?)";
            ps = c.prepareStatement(sqlName, Statement.RETURN_GENERATED_KEYS);

            Name name = application.getApplicant().getName();
            ps.setString(1, name.getSurname());
            ps.setString(2, name.getForenames());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int nameId = rs.getInt(1);
                name.setId(nameId);
            }
            rs.close();
            ps.close();

            String sqlApplicant = "INSERT INTO applicants (title, type, name_id, gender, date_of_birth, place_of_birth, country_of_birth_code, email, mobile_number, alternative_number, sms_notification, email_notification, facial_image_id, current_address_id, nationality_id, previous_passports_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = c.prepareStatement(sqlApplicant, Statement.RETURN_GENERATED_KEYS);

            Applicant applicant = application.getApplicant();
            ps.setString(1, applicant.getTitle());
            ps.setString(2, applicant.getType().toString());
            ps.setObject(3, applicant.getName().getId());
            ps.setString(4, applicant.getGender().toString());
            ps.setDate(5, Date.valueOf(applicant.getDateOfBirth()));
            ps.setString(6, applicant.getPlaceOfBirth());
            ps.setString(7, applicant.getCountryOfBirthCode());
            ps.setString(8, applicant.getEmail());
            ps.setString(9, applicant.getMobileNumber());
            ps.setString(10, applicant.getAlternativeNumber());
            ps.setBoolean(11, applicant.isSmsNotification());
            ps.setBoolean(12, applicant.isEmailNotification());
            ps.setObject(13, applicant.getFacialImage().getId());
            ps.setObject(14, applicant.getCurrentAddress().getId());
            ps.setObject(15, applicant.getNationality().getId());
            ps.setObject(16, applicant.getPreviousPassports().getId());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int applicantId = rs.getInt(1);
                applicant.setId(applicantId);
            }
            rs.close();
            ps.close();

            String sqlApplication = "INSERT INTO applications (id, submission_date_time, type, documents_required, source, processing_centre, applicant_id, product_id, applying_from_overseas, csig_required, payment_details_id, delivery_id, welsh_application, document_type, dcs_threat_level, urgent_or_compassionate, medium, able_to_sign, unable_to_sign_reason) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = c.prepareStatement(sqlApplication);

            ps.setObject(1, application.getId());
            ps.setTimestamp(2, Timestamp.valueOf(application.getSubmissionDateTime()));
            ps.setString(3, application.getType().toString());
            ps.setBoolean(4, application.isDocumentsRequired());
            ps.setString(5, application.getSource());
            ps.setString(6, application.getProcessingCentre());
            ps.setObject(7, application.getApplicant().getId());
            ps.setObject(8, application.getProduct().getId());
            ps.setBoolean(9, application.isApplyingFromOverseas());
            ps.setBoolean(10, application.isCsigRequired());
            ps.setObject(11, application.getPaymentDetails().getId());
            ps.setObject(12, application.getDelivery().getId());
            ps.setBoolean(13, application.isWelshApplication());
            ps.setString(14, application.getDocumentType().toString());
            ps.setString(15, application.getDCSThreatLevel().toString());
            ps.setBoolean(16, application.isUrgentOrCompassionate());
            ps.setString(17, application.getMedium().toString());
            ps.setBoolean(18, application.isAbleToSign());
            ps.setString(19, application.getUnableToSignReason());

            result = ps.executeUpdate();
            c.commit();
        } catch (SQLException e) {
            if (c != null) {
                try {
                    c.rollback();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }

        return result;
    }

    private void insertPassport(Connection c, Passport passport) throws SQLException {
        String sqlPassport = "INSERT INTO passports (passport_number, expiry_year, expiry_month, expiry_day, issued_year, issued_month, issued_day) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id";
        PreparedStatement ps = c.prepareStatement(sqlPassport);

        ps.setString(1, passport.getPassportNumber());
        ps.setInt(2, passport.getExpiryYear());
        ps.setInt(3, passport.getExpiryMonth());
        ps.setInt(4, passport.getExpiryDay());
        ps.setInt(5, passport.getIssuedYear());
        ps.setInt(6, passport.getIssuedMonth());
        ps.setInt(7, passport.getIssuedDay());

        ResultSet rsPassport = ps.executeQuery();
        if (rsPassport.next()) {
            int passportId = rsPassport.getInt(1);
            passport.setId(passportId);
        }
        rsPassport.close();
        ps.close();
    }

    private void insertAddress(Connection c, Address address) throws SQLException {
        String sqlAddress = "INSERT INTO addresses (line_1, line_2, town_or_city, country_code, postcode) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = c.prepareStatement(sqlAddress, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, address.getLine1());
        ps.setString(2, address.getLine2());
        ps.setString(3, address.getTownOrCity());
        ps.setString(4, address.getCountryCode());
        ps.setString(5, address.getPostcode());

        ps.executeUpdate();
        ResultSet rsAddress = ps.getGeneratedKeys();
        if (rsAddress.next()) {
            int addressId = rsAddress.getInt(1);
            address.setId(addressId);
        }
        rsAddress.close();
        ps.close();
    }
}

