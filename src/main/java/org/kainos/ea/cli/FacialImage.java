package org.kainos.ea.cli;

import java.util.List;

public class FacialImage {
    private int id;
    @SuppressWarnings("unused")
    private boolean icaoCompliant;
    @SuppressWarnings("unused")
    private boolean icaoCheckOverridden;
    @SuppressWarnings("unused")
    private List<IcaoComplianceResult> icaoComplianceResults;
    @SuppressWarnings("unused")
    private double yaw;
    @SuppressWarnings("unused")
    private double roll;
    @SuppressWarnings("unused")
    private double pitch;
    @SuppressWarnings("unused")
    private int rightEyeY;
    @SuppressWarnings("unused")
    private int rightEyeX;
    @SuppressWarnings("unused")
    private int leftEyeY;
    @SuppressWarnings("unused")
    private int leftEyeX;
    @SuppressWarnings("unused")
    private String imageType;
    @SuppressWarnings("unused")
    private String base64Contents;
    @SuppressWarnings("unused")
    private int height;
    @SuppressWarnings("unused")
    private int width;
    @SuppressWarnings("unused")
    private String colourSpace;
    @SuppressWarnings("unused")
    private int imageDpi;
    @SuppressWarnings("unused")
    private String imageSource;

    public FacialImage() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIcaoCompliant() {
        return icaoCompliant;
    }

    public boolean isIcaoCheckOverridden() {
        return icaoCheckOverridden;
    }

    public List<IcaoComplianceResult> getIcaoComplianceResults() {
        return icaoComplianceResults;
    }

    public double getYaw() {
        return yaw;
    }

    public double getRoll() {
        return roll;
    }

    public double getPitch() {
        return pitch;
    }

    public int getRightEyeY() {
        return rightEyeY;
    }

    public int getRightEyeX() {
        return rightEyeX;
    }

    public int getLeftEyeY() {
        return leftEyeY;
    }

    public int getLeftEyeX() {
        return leftEyeX;
    }

    public String getImageType() {
        return imageType;
    }

    public String getBase64Contents() {
        return base64Contents;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getColourSpace() {
        return colourSpace;
    }

    public int getImageDpi() {
        return imageDpi;
    }

    public String getImageSource() {
        return imageSource;
    }

}
