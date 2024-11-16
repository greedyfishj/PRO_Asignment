/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarPrj;

import CarPrj.Brand;

/**
 *
 * @author DELL
 */
public class Car implements Comparable<Car> {

    String carID;
    public Brand brand;
    String color;
    String frameID;
    String engineID;

    public Car() {//constructor
        carID = "";
        color = "";
        frameID = "";
        engineID = "";
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {//constructor có đối số
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    //public get & set
    public String getcarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    // public setUpCar
    public void setUpdatedCar(Brand brand, String color, String frameID, String engineID) {
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    // public String toString();
    @Override
    public String toString() {
        return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
    }

//    // public String screenString();          
    public String screenString() {
        return brand.getBrandName() + "\n" + carID + ", " + color + ", " + frameID + ", " + engineID;
    }
    // Used in the operation opf listing cars in ascending order of brand names.

    @Override
    public int compareTo(Car c) {
        int d = this.getBrand().getBrandName().compareTo(c.getBrand().getBrandName());
        if (d != 0) {
            return d;
        } else {
            return d = this.getcarID().compareTo(c.getcarID());
        }
    }
}
