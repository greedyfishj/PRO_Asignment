package CarPrj;


import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Gfishj298
 */
public class Menu {

    Scanner sc = new Scanner(System.in);

    //This <E> before the return type (int) tells the compiler that E is a generic type for this method.
    //generic means it can contains many data types like String, Integer, Character.... like a vector, but with reference ones only
    public <E> int int_getChoice(ArrayList<E> options) {
        int response = 0;
        int N = options.size();
        System.out.println("");
        //keep asking for choice input
        while (true) {
            try {
                // Display options
                for (int i = 0; i < N; i++) {
                    System.out.println((i + 1) + "- " + options.get(i));
                }

                System.out.print("Please choose an option 1.." + N + ": ");
                response = sc.nextInt();
                sc.nextLine(); // consume the newline character

                // Check if response is within the valid range
                if (response < 1 || response > N) {
                    System.out.println("Invalid choice. Please select a number between 1 and " + N + ".");
                } else {
                    break;  // Exit the loop when input is valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();  // Clear the invalid input
            }
        }
        return response;
    }

//this method is to get user choice as an object in the list:
    public <E> E ref_getChoice(ArrayList<E> options) {
        int response = 0;
        int N = options.size();
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > N);
        return options.get(response - 1);
    }

}
