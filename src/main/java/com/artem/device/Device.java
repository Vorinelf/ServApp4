package com.artem.device;

public abstract class Device {
    private String name;
    private int serialNumber;
    private static int countSerial = 0;
    private int powerSizekW;
    private boolean powerON;


    public Device(String name, int powerSizekW, boolean powerON) {
        this.name = name;
        this.powerSizekW = powerSizekW;
        this.powerON = powerON;
        serialNumb();
    }

    public Device() {
    }

    @Override
    public String toString() {
        return "\n" + "CLASS: " + getClass() + " " + "Name: " + getName() + " " + "PowerSize: " + getPowerSizekW() + " " + "PowerON: " + isPowerON() + " " + "SerialNumber: " + " " + getSerialNumber();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public static void setCountSerial(int countSerial) {
        Device.countSerial = countSerial;
    }

    public void setPowerSizekW(int powerSizekW) {
        this.powerSizekW = powerSizekW;
    }

    public void setPowerON(boolean powerON) {
        this.powerON = powerON;
    }

    public static int getCountSerial() {
        return countSerial;
    }

    void serialNumb() {
        this.serialNumber = countSerial++;
    }

    public String getName() {
        return name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getPowerSizekW() {
        return powerSizekW;
    }

    public boolean isPowerON() {
        return powerON;
    }


}

