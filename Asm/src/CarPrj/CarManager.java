package CarPrj;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TruongLX 2.12pm - 2.51pm 10/10/2024 reading files and creating
 * objects, along with the main program algorithms
 */
import CarPrj.BrandList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CarManager { //Main class

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Creating ArrayList ops of strings containing options of the program;
        ArrayList<String> ops = new ArrayList<>();
        //Using addAll() method from Collections
        Collections.addAll(ops,
                "List all brands",
                "Add a new brand",
                "Search a brand based on its ID",
                "Update a brand",
                "Save brands to the file, named brands.txt",
                "List all cars in ascending order of brand names",
                "List cars based on a part of an input brand name",
                "Add a car",
                "Remove a car based on its ID",
                "Update a car based on its ID",
                "Save cars to file",
                "Exit"
        );

        //Duong dan file CAR.txt
        String file_car = "C:\\Users\\PC\\OneDrive\\Desktop\\PRO192_Qan\\Assignment\\CarPrj\\src\\main\\java\\CarPrj\\Cars.txt";
        //Duong dan file BRAND.txt
        String file_brand = "C:\\Users\\PC\\OneDrive\\Desktop\\PRO192_Qan\\Assignment\\CarPrj\\src\\main\\java\\CarPrj\\Brands.txt";
        //empty brand arrayList
        BrandList brandList = new BrandList();
        //load brand list
        brandList.loadFromFile(file_brand);
        //create carList using brandList
        ArrayList<String> carList = new ArrayList<String>();
        CarList carlist = new CarList(brandList);
        //load cars from txt file
        carlist.loadFromFile(file_car);
        int choice = 0;
        Menu menu = new Menu();

        //Main program
        do {
            //this will print out menu and return choice
            choice = menu.int_getChoice(ops);

            switch (choice) {
                //add your function call here
                case 1: //List all brands
                    brandList.listBrands();
                    sc.nextLine();
                    break;
                    
                case 2: //Add new brand
                    brandList.addBrand();
                    sc.nextLine();
                    break;
                    
                case 3: //Search a brand based on its ID
                    String id;
                    System.out.printf("Nhap vao brandID: ");
                    id = sc.nextLine();
                    if(brandList.searchID(id) == -1)
                        System.out.println("Not Found");
                    else 
                        System.out.println(brandList.get(brandList.searchID(id)));
                    sc.nextLine();
                    break;
                    
                case 4: //Update brand
                    brandList.updateBrand();
                    sc.nextLine();
                    break;
                    
                case 5: //Save brand to file "Brands.TXT"
                    brandList.saveToFile(file_brand);
                    sc.nextLine();
                    break;
                    
                case 6: //List car in ascending order
                    carlist.listCars();
                    sc.nextLine();
                    break;
                    
                case 7: //List cars based on a part of an input brand name
                    carlist.printBasedBrandName();
                    sc.nextLine();
                    break;
                    
                case 8: //Add car
                    carlist.addCar();
                    sc.nextLine();
                    break;
                    
                case 9: //Remove car
                    carlist.removeCar();
                    sc.nextLine();
                    break;
                    
                case 10:    //Update car
                    carlist.updateCar();
                    sc.nextLine();
                    break;
                    
                case 11:    //save cars to file "Cars.TXT"
                    carlist.saveToFile(file_car);
                    sc.nextLine();
                    break;
                    
                // Kết Thúc Chương Trình-ákjdhkajsfkjasfkaf
                case 12:
                    System.exit(0);
                    break;
            }
        } while (choice > 0 && choice <= ops.size());
    }
}
