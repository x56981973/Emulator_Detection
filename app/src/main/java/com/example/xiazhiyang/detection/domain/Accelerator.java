package com.example.xiazhiyang.detection.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Accelerator {
    private double x;

    private double y;

    private double z;

    @JsonIgnore
    private double accelerator;

    private long timestamp;

    public Accelerator() {
    }

    public Accelerator(double x, double y, double z, long timestamp) {
        this.timestamp = timestamp;
        this.x = x;
        this.y = y;
        this.z = z;
        this.accelerator = Math.sqrt(x*x+y*y+z*z);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getAccelerator() {
        return accelerator;
    }

    public void setAccelerator(double accelerator) {
        this.accelerator = accelerator;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
