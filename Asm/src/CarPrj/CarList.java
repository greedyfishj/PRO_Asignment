/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarPrj;

//Khai bao cac thu vien can thiet
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Cuan Last changed: 0:07 - 16/10
 * Fix bugs and General check - Duy 17/10
 */
public class CarList extends ArrayList<Car> {

    BrandList brandList;

    Car car = new Car();
    Brand brand = new Brand();
    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);

    public CarList() {
    }

    public CarList(BrandList bList) {
        brandList = bList;
    }

    @Override
    public String toString() {
        return car.getcarID() + ", " + brand.getBrandID() + ", " + car.getColor() + ", " + car.getFrameID() + ", " + car.getEngineID();
    }

    public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {  //Kiểm tra if file ko tồn tại --> return false
            return false;
        } else {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while (true) {
                    //Đọc file theo từng dòng
                    line = br.readLine();
                    if (line == null) { //tạm dừng đọc khi con trỏ trỏ đến cuối file
                        break;
                    }

                    //chia chuỗi theo format <ID, brand ID, color, frame ID, engine ID>
                    String t[] = line.split(", ");//dựa vào (", ") để phân tách các phần tử

                    //ex:  C01, B7-2018, red, F12345, E12345
                    //t[] = t[0], t[1], t[2], t[3], t[4]
                    String carID = t[0];
                    String brandID = t[1];
                    String color = t[2];
                    String frameID = t[3];
                    String engineID = t[4];

                    int pos = brandList.searchID(brandID);
                    Brand b = brandList.get(pos);

                    //add new Car 
                    this.add(new Car(carID, b, color, frameID, engineID));
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        try {
            // mở file để Write. ...FileWriter(filename, true) - true ở đây là để hiểu rằng file đã tồn tại
            // mở file để ghi tiếp tục vào dữ liệu mình có trong file,--- nếu ko có true thì nó sẽ xóa all 
            //dữ liệu trong file và ghi lại từ đầu
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Car c : this) {
                bw.write(c.toString());
                bw.newLine();
            }
            //đóng file
            bw.close();
            fw.close();
            System.out.println("Saved");
            System.out.println("");
        } catch (IOException e) {
            // Handle any I/O exceptions that may occur
            System.out.println("Error writing to the file: " + e.getMessage());
            return false;  // Return false if there's an error
        }
        return true;
    }

    public int searchID(String carID) {
        int n = this.size();
        for (int i = 0; i < n; i++) {
            //tìm index chứa carID trùng với dữ liệu nhập vào
            if (this.get(i).carID.equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        int n = this.size();
        for (int i = 0; i < n; i++) {
            //Check if FrameID của phần tử thứ i có trùng với fID nhập vào k
            if (this.get(i).frameID.equals(fID)) {
                //Trả về vị trí frameID trùng
                return i;
            }
        }
        //Trả về -1 khi ko tìm đc phần tử giống
        return -1;
    }

    public int searchEngine(String eID) {
        int n = this.size();
        for (int i = 0; i < n; i++) {
            //Check if engineID của phần tử thứ i có trùng với eID nhập vào k
            if (this.get(i).engineID.equals(eID)) {
                //Trả về vị trí engineID trùng
                return i;
            }
        }
        //Trả về -1 khi ko tìm đc phần tử giống
        return -1;
    }

    public void addCar() {
        String carID;
        int n = this.size();
        boolean check_carID = false;
        do {
            System.out.printf("Nhap vao carID: ");
            carID = sc.nextLine();
            //Kiểm tra xem carID có trùng với dữ liệu đã có k
            for (int i = 0; i < n; i++) {
                if (this.get(i).carID.equals(carID)) {
                    check_carID = true;
                    System.out.println("carID must be not duplicated");
                    break;
                } else {
                    check_carID = false;
                }
            }
        } while (check_carID == true);
        //tao menu
        Brand b = (Brand) menu.ref_getChoice(brandList);

        String color = "";
        System.out.printf("Nhap vao color: ");
        color = sc.nextLine();
        //kiểm tra sao cho dữ liệu nhập vào KHÔNG ĐC ĐỂ TRỐNG
        while (color.equals("")) {
            System.out.println("Color can not be blank!!!!");
            System.out.printf("Nhap lai color: ");
            color = sc.nextLine();
        }

        String frameID = "";
        String s1 = "F\\d{5}";//F - kí tự đầu ; \\d - chữ số; {5} - số lượng cso
        boolean check_frameID = false;
        do {
            System.out.printf("Nhap vao frameID: ");
            frameID = sc.nextLine();
            //Kiểm tra xem frameID nhập vào có đúng format F00000 hay k
            while (frameID.equals("") || frameID.matches(s1) == false) {
                System.out.println("frameID ko hop le");
                System.out.printf("Nhap lai frameID: ");
                frameID = sc.nextLine();
            }
            for (int i = 0; i < n; i++) {
                //check if frameID trùng lặp
                if (this.get(i).frameID.equals(frameID)) {
                    check_frameID = true;
                    System.out.println("frameID must be not duplicated");
                    break;
                } else {
                    check_frameID = false;
                }
            }
        } while (check_frameID == true);

        String engineID = "";
        String s2 = "E\\d{5}";  ////E - kí tự đầu ; \\d - chữ số; {5} - số lượng cso
        boolean check_engineID = false;
        do {
            System.out.printf("Nhap vao engineID: ");
            engineID = sc.nextLine();
            //check xem input có đúng format E00000
            while (engineID.equals("") || engineID.matches(s2) == false) {
                System.out.println("engineID ko hop le");
                System.out.printf("Nhap lai engineID: ");
                engineID = sc.nextLine();
            }
            for (int i = 0; i < n; i++) {
                //Check dữ liệu trùng lặp
                if (this.get(i).engineID.equals(engineID)) {
                    check_engineID = true;
                    System.out.println("engineID must be not duplicated");
                    break;
                } else {
                    check_engineID = false;
                }
            }
        } while (check_engineID == true);
        //Add new car
        this.add(new Car(carID, b, color, frameID, engineID));
        System.out.println("New car was added!!!");

    }

    public void printBasedBrandName() {
        String aPartOfBrandName = "";
        //check dữ liệu có để trống k
        while (aPartOfBrandName.equals("")) {
            System.out.printf("Enter a part of brand Name: ");
            aPartOfBrandName = sc.nextLine();
        }
        int n = this.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Car c = this.get(i);
            if (c.brand.getBrandName().contains(aPartOfBrandName) == true) {
                System.out.println(c.screenString());
                count++;
            }

        }
        if (count == 0) {
            System.out.println("No car is detected");
        }
    }

    public boolean removeCar() {
        System.out.printf("Nhap vao car ID can remove: ");
        String removedID;
        removedID = sc.nextLine();
        int pos = searchID(removedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            this.remove(pos);
            System.out.println("Removed!!!!");
            System.out.println("");
        }
        return true;
    }

    public boolean updateCar() {
        String updatedID;
        System.out.printf("Nhap vao car ID can update: ");
        updatedID = sc.nextLine();
        int n = this.size();
        int pos = searchID(updatedID);
        if (pos < 0) {
            System.out.println("Not found!");
            return false;
        } else {
            Brand b = (Brand) menu.ref_getChoice(brandList);

            String color = "";
            System.out.printf("Nhap vao color: ");
            color = sc.nextLine();
            //check du lieu trong
            while (color.equals("")) {
                System.out.println("Color can not be blank!!!!");
                System.out.printf("Nhap lai color: ");
                color = sc.nextLine();
            }

            String frameID = "";
            String s1 = "F\\d{5}";//F - kí tự đầu ; \\d - chữ số; {5} - số lượng cso
            boolean check_frameID = false;
            do {
                System.out.printf("Nhap vao frameID: ");
                frameID = sc.nextLine();
                //check neu frame id dung format F00000
                while (frameID.equals("") || frameID.matches(s1) == false) {
                    System.out.println("frameID ko hop le");
                    System.out.printf("Nhap lai frameID: ");
                    frameID = sc.nextLine();
                }
                //check xem frameID co trùng lặp?
                for (int i = 0; i < n; i++) {
                    if (this.get(i).frameID.equals(frameID)) {
                        check_frameID = true;
                        System.out.println("frameID must be not duplicated");
                        break;
                    } else {
                        check_frameID = false;
                    }
                }
            } while (check_frameID == true);

            String engineID = "";
            String s2 = "E\\d{5}";//E - kí tự đầu ; \\d - chữ số; {5} - số lượng cso
            boolean check_engineID = false;
            do {
                System.out.printf("Nhap vao engineID: ");
                engineID = sc.nextLine();
                //Check engineID có đúng format E00000
                while (engineID.equals("") || engineID.matches(s2) == false) {
                    System.out.println("engineID ko hop le");
                    System.out.printf("Nhap lai engineID: ");
                    engineID = sc.nextLine();
                }
                //Check engineID có bị lặp?
                for (int i = 0; i < n; i++) {
                    if (this.get(i).engineID.equals(engineID)) {
                        check_engineID = true;
                        System.out.println("engineID must be not duplicated");
                        break;
                    } else {
                        check_engineID = false;
                    }
                }
            } while (check_engineID == true);
            //update car
            this.get(pos).setUpdatedCar(b, color, frameID, engineID);
            System.out.println("Updated successfully");
        }
        return true;
    }

    public void listCars() {
        Collections.sort(this);//list theo ascending order của Brand names
        int n = this.size();
        for (int i = 0; i < n; i++) {
            Car c = this.get(i);
            System.out.println(c.screenString());
        }
    }
}
