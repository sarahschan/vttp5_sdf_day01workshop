import java.util.List;
import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;

public class MyApp {

    public static void main(String[] args) {
        // Print welcome and instructions list
        System.out.println("WELCOME TO YOUR SHOPPING CART");
        instructions();


        // Initialize Array List
        List<String> cartItems = new ArrayList<>();


        // Initialize console in order to read user input from terminal
        // User input will be stored in 'keyboardInput', 
        //  which is initialized as an empty String
        Console console = System.console();
        String keyboardInput = "";


        // While loop so program will run, until user inputs 'quit'
        while (true) {

            // keyboardInput is set to read whatever is typed on the console
            // Includes ">"" prompt for input. Change input to lowercase for uniformity check
            keyboardInput = console.readLine("> ");
            keyboardInput = keyboardInput.toLowerCase();

            if (keyboardInput.equals("list")) {
                // If there are items in cart, print each item in cartItems array
                if (cartItems.size() > 0) {
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.println((i+1) + ". " + cartItems.get(i));
                    }

                    // for (String item : cartItems) {
                    //     System.out.println(cartItems.indexOf(item) + ". " + item);
                    // }
                    // ^^this works in this particular example because we will check and
                    //      not allow duplicate items in the list (done in another location).
                    //      However, if we allowed for duplicate entries, the index would
                    //      always show the indexOf the first entry

                } else {
                    System.out.println("Your cart is empty");
                }

            } else if (keyboardInput.startsWith("add")) {
                // Replace any entries with commas to spaces
                keyboardInput = keyboardInput  .replace(',', ' ');

                // Use the scanner to use .next() function
                // Method .substring(4) goes to index(4) of the string, skipping "add " and
                //      starting at the first actual item on the list
                Scanner scan = new Scanner(keyboardInput.substring(4));
                String tempString = "";                                                     // Step 1
                while (scan.hasNext()) {                                                    // Step 2
                    tempString = scan.next();                                               // Step 3
                    if (cartItems.contains(tempString)) {                                   // Step 4
                        System.out.println("You have " + tempString + " in your cart");
                    } else {
                        cartItems.add(tempString);                                          // Step 5
                        System.out.println(tempString + " added to cart");
                    }
                    
                }
                scan.close();

                // Step 1: An empty string "tempString" is initialised as a temporary holding place
                //          for extracted words (aka items to put onto the cartItems ArrayList)
                //          to be stored
                // Step 2: While scan.hasNext() method checks if keyboardInput has items to process
                //          Method returns true and will run the {code}, until there are no more
                //          items and {code} will not run
                // Step 3: Within {code}, assign value of tempString to word found using scan.next()
                // Step 4: Check if value of tempString already exists in cartItems using cartItems.contains()
                // Step 5: If value does not already exist, add to cartItems using cartItems.add()


            } else if (keyboardInput.startsWith("delete")) {

                // Similar starting process as "add" input
                // Replace entries with commas to spaces
                // Open the scanner to use .next() function. Remember to use .substring to skip "delete "
                // Remember that the keyboardInput will be something like delete 2 or delete 2, 6
                //      Hence, removing delete will give us the so called "index" - indexes actually start from 0

                keyboardInput = keyboardInput.replace(',', ' ');
                Scanner scan = new Scanner(keyboardInput.substring(6));
                String deleteIndexString = "";

                while (scan.hasNext()) {                                                    
                    deleteIndexString = scan.next();
                    int deleteIndexInt = (Integer.parseInt(deleteIndexString) - 1);     // -1 because index start from 0                    
                    if (deleteIndexInt < 0 || deleteIndexInt >= cartItems.size()) {
                        System.out.println("Incorrect item index");
                    } else {
                        System.out.println(cartItems.get(deleteIndexInt) + " removed from cart");
                        cartItems.remove(deleteIndexInt);
                        // ^PRINT STATEMENT HAS TO COME FIRST OMG YOU KNOW WHY
                    }
                    
                }

                scan.close();
            

            } else if (keyboardInput.equals("quit")) {
                System.out.println("SHOPPING CART QUIT - GOODBYE");
                break;

            } else {
                System.out.println("Command not recognised, try again");
            }

        }

    }


    // Print instructions
    public static void instructions(){
        System.out.println("====================");
        System.out.println("INSTRUCTIONS");
        System.out.println("To view list: list");
        System.out.println("To add an item: add [item]");
        System.out.println("To delete an item: delete [item number]");
        System.out.println("To exit: quit");
        System.out.println("====================");
    }


}