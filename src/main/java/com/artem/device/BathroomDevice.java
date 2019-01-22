package com.artem.device;


public class BathroomDevice extends Device {
    private boolean waterproof;

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public BathroomDevice() {
    }

    public BathroomDevice(String name, int powerSizekW, boolean powerON, boolean waterproof) {
        super(name, powerSizekW, powerON);

        this.waterproof = waterproof;
    }

    @Override
    public String toString() {
        return "\n" + "CLASS: " + getClass() + " " + "Name: " + getName() + " " + "PowerSize: " + getPowerSizekW()
                + " " + "PowerON: " + isPowerON() + " " + "SerialNumber: " + " " + getSerialNumber() + " " + "waterproof: " + isWaterproof();
    }

    public boolean isWaterproof() {
        return waterproof;
    }
}

