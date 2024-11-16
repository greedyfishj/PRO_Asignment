package CarPrj;

/*
 * Click nbfs://nbhost/Syste
mFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.Scanner;

public class Brand {

    private String brandID;
    private String brandName;
    private String soundBrand;
    private double price;

    public Brand() {//Contrucstor
        brandID = "";
        brandName = "";
        soundBrand = "";
        price = 0;
    }

    public Brand(String brandID, String brandName, String soundBrand, double price) {//Contrucstor
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    //get&set
    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
        //Scanner sn = new Scanner(System.in);
        //String a=sn.next();
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public void setUpdatedBrand(String brandName, String soundBrand, double price) {
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

// public toString
    @Override
    public String toString() {
        return brandID + "," + brandName + "," + soundBrand + ":" + price;
    }
}
