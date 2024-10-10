/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gfishj298
 * 2.12pm - 2.51pm
 * 10/10/2024
 */
import java.util.*;

public class CarManager { //Main class

    public static void main(String[] args) {

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
                "Save cars to file"
        );

        //Toi nay lam not readfile sau
        ArrayList<String> brandsList = new ArrayList<String>();
        //load brand list
        //create carList using brandList
        ArrayList<String> carList = new ArrayList<String>();
        //load cars from txt file

        int choice = 0;
        Menu menu = new Menu();

        //Main program
        do {
            //this will print out menu and return choice
            choice = menu.int_getChoice(ops);

            switch (choice) {
                //add your function call here
                case 1: //brandList.listBrands(); break;
                    //testing
                    System.out.println("Case 1 running");
                //case 2:
                //...
            }
        } while (choice > 0 && choice <= ops.size());
    }
}
