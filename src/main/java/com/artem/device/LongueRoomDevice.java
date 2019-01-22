package com.artem.device;


public class LongueRoomDevice extends Device {
    private boolean lcdDisplay;
    private boolean wiFi;
    private boolean bluetooth;

    public LongueRoomDevice() {
    }

    public LongueRoomDevice(String name, int powerSizekW, boolean powerON, boolean lcdDisplay, boolean wiFi, boolean bluetooth) {
        super(name, powerSizekW, powerON);
        this.lcdDisplay = lcdDisplay;
        this.wiFi = wiFi;
        this.bluetooth = bluetooth;
    }

    @Override
    public String toString() {
        return "\n" + "CLASS: " + getClass() + " " + "Name: " + getName() + " " + "PowerSize: " + getPowerSizekW() + " " + "PowerON: " + isPowerON() + " "
                + "SerialNumber: " + " " + getSerialNumber() + " " + "lcdDisplay: " + isLcdDisplay() + " " + "wiFi: " + isWiFi() + " " + "bluetooth: " + isBluetooth();
    }

    public boolean isLcdDisplay() {
        return lcdDisplay;
    }

    public boolean isWiFi() {
        return wiFi;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setLcdDisplay(boolean lcdDisplay) {
        this.lcdDisplay = lcdDisplay;
    }

    public void setWiFi(boolean wiFi) {
        this.wiFi = wiFi;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }
}

