package hccis.entity;

import info.hccis.util.CisUtility;

/**
 * Class to represent a vehicle.
 *
 * @author Noel Spurrell
 * @since 20221211
 */
public class Vehicle {
    private double price;
    private int mileage;
    private String transmissionCode;
    private boolean hasSunroof;

    public Vehicle() {
        //default constructor
    }

    public Vehicle(double value, int mileage, boolean hasSunroof, String transmissionCode) {
        //custom constructor
        this.price = value;
        this.mileage = mileage;
        this.transmissionCode = transmissionCode;
        this.hasSunroof = hasSunroof;
    }

    public void getInformation() {

        price = CisUtility.getInputDouble("Vehicle price:");

        mileage = CisUtility.getInputInt("Mileage on Vehicle:");

        transmissionCode = CisUtility.getInputString("Transmission (A-automatic / M-manual):");
        while (!transmissionCode.equalsIgnoreCase("A") && !transmissionCode.equalsIgnoreCase("M")) {
            transmissionCode = CisUtility.getInputString("Invalid transmission code, please enter A or M:");
        }

        hasSunroof = CisUtility.getInputBoolean("Sunroof (Y/N):");

    }

    /**
     * Calculates the vehicle value
     *
     * @author Noel Spurrell
     * @since 20201118
     */
    public double calculateValue() {
        double value = price;

        //value related to mileage
        if (mileage <= 59999) {
            value -= price * 0.3;
        }
        if (mileage >= 60000 && mileage <= 99999) {
            value -= price * 0.35;
        }
        if (mileage >= 100000 && mileage <= 199999) {
            value -= price * 0.4;
        }
        if (mileage >= 200000) {
            value -= price * 0.5;
        }

        //value related to transmission
        switch (transmissionCode.toUpperCase()) {
            case "A" -> value += price * 0.05;
            case "M" -> value -= price * 0.05;
        }

        //value related to sunroof
        if (hasSunroof) {
            value += price * 0.1;
        }

        return value;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getTransmissionCode() {
        return transmissionCode;
    }

    public void setTransmissionCode(String transmissionCode) {
        this.transmissionCode = transmissionCode;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public void display() {
        System.out.println(toString());
    }

    public String toString() {
        return "Your vehicle is now valued at: " + CisUtility.toCurrency(calculateValue()) + "\n\nEnter another vehicles information?";
    }

}
