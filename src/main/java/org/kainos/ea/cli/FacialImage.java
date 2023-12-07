package org.kainos.ea.cli;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facial_images")
public class FacialImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "icao_compliant")
    private boolean icaoCompliant;

    @Column(name = "icao_check_overridden")
    private boolean icaoCheckOverridden;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IcaoComplianceResult> icaoComplianceResults;

    private double yaw;

    private double roll;

    private double pitch;

    @Column(name = "right_eye_y")
    private int rightEyeY;

    @Column(name = "right_eye_x")
    private int rightEyeX;

    @Column(name = "left_eye_y")
    private int leftEyeY;

    @Column(name = "left_eye_x")
    private int leftEyeX;

    @Column(name = "image_type")
    private String imageType;

    @Column(name = "base_64_contents")
    private String base64Contents;

    private int height;

    private int width;

    @Column(name = "colour_space")
    private String colourSpace;

    @Column(name = "image_dpi")
    private int imageDpi;

    @Column(name = "image_source")
    private String imageSource;

    public FacialImage() {
        
    }

    public boolean isIcaoCompliant() {
        return icaoCompliant;
    }

    public void setIcaoCompliant(boolean icaoCompliant) {
        this.icaoCompliant = icaoCompliant;
    }

    public boolean isIcaoCheckOverridden() {
        return icaoCheckOverridden;
    }

    public void setIcaoCheckOverridden(boolean icaoCheckOverridden) {
        this.icaoCheckOverridden = icaoCheckOverridden;
    }

    public List<IcaoComplianceResult> getIcaoComplianceResults() {
        return icaoComplianceResults;
    }

    public void setIcaoComplianceResults(List<IcaoComplianceResult> icaoComplianceResults) {
        this.icaoComplianceResults = icaoComplianceResults;
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public int getRightEyeY() {
        return rightEyeY;
    }

    public void setRightEyeY(int rightEyeY) {
        this.rightEyeY = rightEyeY;
    }

    public int getRightEyeX() {
        return rightEyeX;
    }

    public void setRightEyeX(int rightEyeX) {
        this.rightEyeX = rightEyeX;
    }

    public int getLeftEyeY() {
        return leftEyeY;
    }

    public void setLeftEyeY(int leftEyeY) {
        this.leftEyeY = leftEyeY;
    }

    public int getLeftEyeX() {
        return leftEyeX;
    }

    public void setLeftEyeX(int leftEyeX) {
        this.leftEyeX = leftEyeX;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getBase64Contents() {
        return base64Contents;
    }

    public void setBase64Contents(String base64Contents) {
        this.base64Contents = base64Contents;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getColourSpace() {
        return colourSpace;
    }

    public void setColourSpace(String colourSpace) {
        this.colourSpace = colourSpace;
    }

    public int getImageDpi() {
        return imageDpi;
    }

    public void setImageDpi(int imageDpi) {
        this.imageDpi = imageDpi;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
}
