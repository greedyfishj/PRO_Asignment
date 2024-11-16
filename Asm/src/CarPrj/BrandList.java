/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CarPrj;

import java.io.*;
import java.util.*;

/**
 *
 * @author Gfishj298 TruongLX 10/12/24 3 first methods committed
 */
public class BrandList extends ArrayList<Brand> {

    private String brandID, brandName, soundBrand;
    private double price;
    private int pos;
    Scanner sc = new Scanner(System.in);

    public BrandList() {
    }

    public boolean loadFromFile(String filename) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("File does not exist. Exiting the program");
            // Exit the program with a status code of 0 (indicates normal termination)
            System.exit(0);

        } else {
            //Open file in text format for reading line-by-line
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Split the line into parts (ID, name, sound system : price)
                    String[] parts = line.split(", ");

                    //After this split, we should have a string array of 3 strings: ID, name and sound:price
                    // Skip to the next line if format is invalid
                    if (parts.length < 3) {
                        System.out.println("Invalid format in line: " + line);
                        continue;
                    }
                    //Id is the [0] element in parts
                    String id = parts[0];
                    //Brand name in [1]
                    String name = parts[1];
                    //Changing the regex, from "," to ":"
                    String[] soundAndPrice = parts[2].split(": ");

                    //now we have another string array, which is sound and price
                    String soundSystem = soundAndPrice[0];
                    //There are chances the price is formatted wrong in the txt file, so we replace "," with "."
                    String priceString = soundAndPrice[1].replace(",", ".");

                    double price = 0;
                    try {
                        price = Double.parseDouble(priceString);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price in line: " + line);
                        continue;  // Skip to the next line if price is invalid
                    }

                    // Create a brand from input data(parts);
                    Brand brand = new Brand(id, name, soundSystem, price);
                    //Add the brand to this list;
                    this.add(brand);

                }
            } //error handling
            //IOException happens if problems like permission issues, file corruption, disk errors... happends
            catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        // Open the file for writing with BufferWritter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {

            //Iterate through each brand in the list with for each
            for (Brand brand : this) {
                // Format brand data as a string and write it to the file
                String brandData = brand.getBrandID() + ", " + brand.getBrandName() + ", "
                        + brand.getSoundBrand() + ": " + brand.getPrice();
                bw.write(brandData + "\n");  // Write the brand data followed by a new line
            }

        } catch (IOException e) {
            // Handle any I/O exceptions that may occur
            System.out.println("Error writing to the file: " + e.getMessage());
            return false;  // Return false if there's an error
        }

        // Step 3: Return true if the operation is successful
        return true;
    }

    public int searchID(String bID) {
        int N = this.size();  //Get the size of the brand list

        //Iterate through the list to search for the brand with the given ID using linear search
        for (int i = 0; i < N; i++) {
            Brand brand = this.get(i);  // Get the brand at index i

            //Check if the brand's ID matches the given bID
            if (brand.getBrandID().equals(bID)) {
                return i;  //Return the index i if a match is found
            }
        }
        //Return -1 if no brand with the given ID is found
        return -1;
    }

    public Brand getUserChoice() {
        Menu menu = new Menu();
        return (Brand) menu.ref_getChoice(this);
    }

    public void addBrand() {
        boolean checkBrandID = false;
        do {
            System.out.print("Nhập brand ID: ");
            brandID = sc.nextLine();
            for (int i = 0; i < this.size(); i++) {
                if (brandID.equals(this.get(i).getBrandID())) {
                    checkBrandID = true;
                    System.out.println("Brand ID này đã tồn tại. Vui lòng thử lại!");
                    break;
                } else {
                    checkBrandID = false;
                }
            }
        } while (checkBrandID == true);
        do {
            System.out.print("Nhập tên brand: ");
            brandName = sc.nextLine();
            if (brandName.equals("") != true) {
                break;
            }
            System.out.println("Brand name không thể trống. Vui lòng thử lại !");
        } while (true);
        do {
            System.out.print("Nhập sound brand: ");
            soundBrand = sc.nextLine();
            if (soundBrand.equals("") != true) {
                break;
            }
            System.out.println("Sound brand không thể trống. Vui lòng thử lại !");
        } while (true);
        do {
            System.out.print("Nhập price: ");
            try {
                price = Double.parseDouble(sc.nextLine());
                while (price <= 0) {
                    System.out.println("Price phải lớn hơn 0. Vui lòng thử lại !");
                    System.out.print("Nhập price: ");
                    price = Double.parseDouble(sc.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Price phải là 1 con số. Vui lòng thử lại !");
                price = 0;
            }
        } while (price == 0);
        this.add(new Brand(brandID, brandName, soundBrand, price));
        System.out.println("Brand đã thêm vào danh sách thành công!");
    }

    public void updateBrand() {
        do {
            System.out.printf("Nhap brand ID:");
            brandID = sc.nextLine();
            pos = searchID(brandID);
            if (pos < 0) {
                System.out.println("Không tìm thấy!");
            }
            else
                break;

        } while (true);
        do {
            System.out.println("Nhập brand name: ");
            brandName = sc.nextLine();
            if (brandName.equals("") != true) {
                break;
            }
            System.out.println("Brand name không được để trống.Vui lòng thử lại! ");
        } while (true);
        do {
            System.out.printf("Nhap soundBrand: ");
            soundBrand = sc.nextLine();
            if (soundBrand.equals("") != true) {
                break;
            }
            System.out.println("Sound brand không được để trống.Vui lòng thử lại!");
        } while (true);
        do {
            try {
                System.out.printf("Nhập price: ");
                price = Double.parseDouble(sc.nextLine());
                while (price <= 0) {
                    System.out.println("Price phải lớn hơn 0. Vui lòng thử lại !");
                    System.out.printf("Nhập price: ");
                    price = Double.parseDouble(sc.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Price phải là 1 con số. Vui lòng thử lại !");
                price = 0;
            }
        } while (price == 0);
        this.get(pos).setUpdatedBrand(brandName, soundBrand, price);
        System.out.println("Brand đã cập nhật thành công !");
    }

    public void listBrands() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }
}
