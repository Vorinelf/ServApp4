package com.artem.device;


public class KitchenDevice extends Device {
    private int maxTemperature;
    private int minTemperature;

    public KitchenDevice() {
    }

    public KitchenDevice(String name, int powerSize_kW, boolean powerON, int minTemperature, int maxTemperature) {
        super(name, powerSize_kW, powerON);
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;

    }

    @Override
    public String toString() {
        return "\n" + "CLASS: " + getClass() + " " + "Name: " + getName() + " " + "PowerSize: " + getPowerSizekW()
                + " " + "PowerON: " + isPowerON() + " " + "SerialNumber: " + " " + getSerialNumber() + " " + "minTemperature: " + getMinTemperature() + " " + "maxTemperature: "
                + getMaxTemperature();
    }

    void resultTemperature() {
        int resultT = maxTemperature - minTemperature;
        System.out.println(resultT);

    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }
}


















