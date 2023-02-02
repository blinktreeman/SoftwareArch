package ru.bcomms.modelElements;

public class Angle3D {
    private double angleXAxe, angleYAxe, angleZAxe;

    public Angle3D() {
        this.angleXAxe = 0;
        this.angleYAxe = 0;
        this.angleZAxe = 0;
    }

    public Angle3D(double angleXAxe, double angleYAxe, double angleZAxe) {
        this.angleXAxe = angleXAxe;
        this.angleYAxe = angleYAxe;
        this.angleZAxe = angleZAxe;
    }

    public double getAngleXAxe() {
        return angleXAxe;
    }

    public void setAngleXAxe(double angleXAxe) {
        this.angleXAxe = angleXAxe;
    }

    public double getAngleYAxe() {
        return angleYAxe;
    }

    public void setAngleYAxe(double angleYAxe) {
        this.angleYAxe = angleYAxe;
    }

    public double getAngleZAxe() {
        return angleZAxe;
    }

    public void setAngleZAxe(double angleZAxe) {
        this.angleZAxe = angleZAxe;
    }
}
