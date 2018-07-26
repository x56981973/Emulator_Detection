package com.example.xiazhiyang.detection.domain;

public class Point {
    private double x;

    private double y;

    private double pressure;

    private long timestamp;

    public Point() {
    }

    public Point(double x, double y, double pressure, long timestamp) {
        this.x = x;
        this.y = y;
        this.pressure = pressure;
        this.timestamp = timestamp;
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

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
