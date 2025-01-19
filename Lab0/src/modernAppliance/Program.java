/**
 * Java implementation of a program related to modern appliances.
 * This class serves as the main entry point for the application, which handles operations on modern appliances.
 * It includes functionality to read appliance data from a file, process user input through a menu,
 * and perform various operations like checking out appliances, searching by brand, displaying by type,
 * generating random appliance lists, and saving data back to a file.
 *
 * @author Sijerina Nepal
 * @author Maria Xavier
 * @author Wenhan Liu
 * @author Scott Yinan Fan
 */

package modernAppliance;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Program {

    /**
     * The main method of the Program, which is the starting point of execution.
     * It initializes the program by reading appliance data from a file and then presents a menu
     * to the user to perform different operations on the appliance data.
     * The file contains appliance information in a specific format, which is processed and stored in a list.
     * The menu provides options for checking out appliances, finding appliances by brand, displaying
     * appliances by type, generating a random appliance list, and saving data before exiting.
     *
     * @param args command line arguments
     * @throws IOException if there is an error during file operations, such as reading from or writing to a file.
     */
    public static void main(String[] args) throws IOException {
        // Initializes the file path where the appliance data is stored.
        String path = "res/appliances.txt";
        // A list to store all Appliance objects read from the file.
        List<Appliance> containerList = new ArrayList<>();
        // Reads all lines from the file into a list of strings.
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (String temp : lines) {
            // Splits each line by semicolon to extract individual fields of an Appliance.
            String[] fields = temp.split(";");
            // Extracts the item number from the split fields.
            String itemNumber = fields[0];
            // Converts the item number from string to long.
            long ItemNumber = Long.parseLong(fields[0]);
            // Extracts the brand from the split fields.
            String brand = fields[1];
            // Converts the quantity from string to integer.
            int quantity = Integer.parseInt(fields[2]);
            // Converts the wattage from string to double.
            double wattage = Double.parseDouble(fields[3]);
            // Extracts the color from the split fields.
            String color = fields[4];
            // Converts the price from string to double.
            double price = Double.parseDouble(fields[5]);

            // Creates different types of Appliance objects based on the item number prefix.
            switch (itemNumber.substring(0, 1)) {
                case "1":
                    // Creates a Refrigerator object with specific parameters, including item number, brand, quantity, wattage, color, price, cubic feet, energy efficiency, and temperature range.
                    Refrigerator r = new Refrigerator(ItemNumber, brand, quantity, wattage, color, price, Integer.parseInt(fields[6]), Double.parseDouble(fields[7]), Double.parseDouble(fields[8]));
                    containerList.add(r);
                    break;
                case "2":
                    // Creates a Vacuum object with specific parameters, including item number, brand, quantity, wattage, color, price, battery type, and battery voltage.
                    Vacuum v = new Vacuum(ItemNumber, brand, quantity, wattage, color, price, fields[6], Integer.parseInt(fields[7]));
                    containerList.add(v);
                    break;
                case "3":
                    // Creates a Microwave object with specific parameters, including item number, brand, quantity, wattage, color, price, wattage output, and room type.
                    Microwave m = new Microwave(ItemNumber, brand, quantity, wattage, color, price, Double.parseDouble(fields[6]), fields[7].charAt(0));
                    containerList.add(m);
                    break;
                case "4":
                case "5":
                    // Creates a Dishwasher object with specific parameters, including item number, brand, quantity, wattage, color, price, cycle type, and sound rating.
                    Dishwasher d = new Dishwasher(ItemNumber, brand, quantity, wattage, color, price, fields[6], fields[7]);
                    containerList.add(d);
                    break;
            }
        }

        // Holds the user's option selected from the menu.
        String UserOption = "";
        while (!UserOption.equals("5")) {
            // Displays the main menu options to the user.
            System.out.println("Welcome to Modern Appliances!");
            System.out.println("How may we assist you?");
            System.out.println("1 – Check out Appliance");
            System.out.println("2 – Find appliances by brand");
            System.out.println("3 – Display appliances by type");
            System.out.println("4 – Produce random Appliance list");
            System.out.println("5 – Save & exit");
            System.out.println("Enter option:");
            Scanner keyboardInput = new Scanner(System.in);
            UserOption = keyboardInput.nextLine();
            switch (UserOption) {
                // Option for checking out an Appliance.
                case "1":
                    // Prompts the user to enter the item number of the Appliance they wish to check out.
                    System.out.println("Enter the item number of an Appliance:");
                    keyboardInput = new Scanner(System.in);
                    String UserInput = keyboardInput.nextLine();
                    long ItemNumber = Long.parseLong(UserInput);
                    // Stores the result of the search for the Appliance with the entered item number.
                    Appliance search_result = null;
                    for (Appliance a : containerList) {
                        // Searches for the Appliance by its item number.
                        if (a.getItemNumber() == Long.parseLong(UserInput)) {
                            search_result = a;
                            break;
                        }
                    }

                    if (search_result == null) {
                        // Informs the user if no Appliance with the provided item number is found.
                        System.out.println("No appliances found with that item number.");
                    } else {
                        // Checks if the Appliance is available for checkout.
                        boolean availability = search_result.isAvailable();
                        if (availability) {
                            // Checks out the Appliance if it is available.
                            search_result.checkout();
                            System.out.println("Appliance " + ItemNumber + " has been checked out.");
                        } else {
                            // Informs the user if the Appliance is not available for checkout.
                            System.out.println("The Appliance is not available to be checked out.");
                        }
                    }
                    break;
                // Option for finding appliances by brand.
                case "2":
                    // Prompts the user to enter the brand name they want to search for.
                    System.out.println("Enter brand to search for:");
                    keyboardInput = new Scanner(System.in);
                    String brandName = keyboardInput.nextLine();
                    // A list to store all appliances that match the entered brand name.
                    List<Appliance> brandCollection = new ArrayList<>();
                    for (Appliance a : containerList) {
                        // Adds appliances with the matching brand name to the brand collection.
                        if (a.getBrand().equals(brandName)) {
                            brandCollection.add(a);
                        }
                    }

                    if (brandCollection.size() == 0) {
                        // Informs the user if no appliances of the entered brand were found.
                        System.out.println("No appliances found with that brand.");
                    } else {
                        // Displays the appliances that match the entered brand.
                        System.out.println("Matching Appliances:");
                        for (Appliance a : brandCollection) {
                            System.out.println(a);
                            System.out.println("\n");
                        }
                        // Clears the brand collection.
                        brandCollection.clear();
                    }
                    break;
                // Option for displaying appliances by type.
                case "3":
                    // Displays the sub-menu for displaying appliances by type.
                    System.out.println("Appliance Types\n1 – Refrigerators\n2 – Vacuums\n3 – Microwaves\n4 – Dishwashers\nEnter type of Appliance:");
                    keyboardInput = new Scanner(System.in);
                    String UserOption2 = keyboardInput.nextLine();
                    // A list to store the appliances found when searching by type.
                    List<Appliance> searchResult2 = new ArrayList<>();
                    switch (UserOption2) {
                        // Sub-option for Refrigerators.
                        case "1":
                            // Prompts the user to enter the number of doors of the Refrigerator.
                            System.out.println("Enter number of doors: 2 (double door), 3 (three doors) or 4 (four doors):");
                            keyboardInput = new Scanner(System.in);
                            String RefrigeratorOption = keyboardInput.nextLine();
                            for (Appliance a : containerList) {
                                // Adds refrigerators with the matching number of doors to the search result.
                                if (a instanceof Refrigerator && ((Refrigerator) a).getNumOfDoors() == Integer.parseInt(RefrigeratorOption)) {
                                    searchResult2.add((Refrigerator) a);
                                }
                            }

                            if (searchResult2.size() == 0) {
                                // Informs the user if no matching refrigerators were found.
                                System.out.println("No appliances found.");
                            } else {
                                // Displays the matching refrigerators.
                                System.out.println("Matching refrigerators:");
                                for (Appliance r : searchResult2) {
                                    System.out.println(r);
                                    System.out.println("\n");
                                }
                                // Clears the search result.
                                searchResult2.clear();
                            }
                            break;
                        // Sub-option for Vacuums.
                        case "2":
                            // Prompts the user to enter the battery voltage of the Vacuum.
                            System.out.println("Enter battery voltage value. 18 V (low) or 24 V (high)");
                            keyboardInput = new Scanner(System.in);
                            String VacuumsOption = keyboardInput.nextLine();
                            for (Appliance a : containerList) {
                                // Adds vacuums with the matching battery voltage to the search result.
                                if (a instanceof Vacuum && ((Vacuum) a).getBatteryVoltage() == Integer.parseInt(VacuumsOption)) {
                                    searchResult2.add((Vacuum) a);
                                }
                            }

                            if (searchResult2.size() == 0) {
                                // Informs the user if no matching vacuums were found.
                                System.out.println("No appliances found.");
                            } else {
                                // Displays the matching vacuums.
                                System.out.println("Matching vacuums:");
                                for (Appliance v : searchResult2) {
                                    System.out.println(v);
                                    System.out.println("\n");
                                }
                                // Clears the search result.
                                searchResult2.clear();
                            }
                            break;
                        // Sub-option for Microwaves.
                        case "3":
                            // Prompts the user to enter the room type for the Microwave.
                            System.out.println("Room where the Microwave will be installed: K (kitchen) or W (work site):");
                            keyboardInput = new Scanner(System.in);
                            String microwaveOption = keyboardInput.nextLine();
                            for (Appliance a : containerList) {
                                // Adds microwaves with the matching room type to the search result.
                                if (a instanceof Microwave && ((Microwave) a).getRoomType() == Character.toUpperCase(microwaveOption.charAt(0))) {
                                    searchResult2.add((Microwave) a);
                                }
                            }

                            if (searchResult2.size() == 0) {
                                // Informs the user if no matching microwaves were found.
                                System.out.println("No appliances found.");
                            } else {
                                // Displays the matching microwaves.
                                for (Appliance m : searchResult2) {
                                    System.out.println(m);
                                    System.out.println("\n");
                                }
                                // Clears the search result.
                                searchResult2.clear();
                            }
                            break;
                        // Sub-option for Dishwashers.
                        case "4":
                            // Prompts the user to enter the sound rating of the Dishwasher.
                            System.out.println("Enter the sound rating of the Dishwasher: Qt (Quietest), Qr (Quieter), Qu(Quiet) or M (Moderate):");
                            keyboardInput = new Scanner(System.in);
                            String DWOption = keyboardInput.nextLine();
                            for (Appliance a : containerList) {
                                // Adds dishwashers with the matching sound rating to the search result.
                                if (a instanceof Dishwasher && ((Dishwasher) a).getSoundRating().equals(DWOption)) {
                                    searchResult2.add((Dishwasher) a);
                                }
                            }
                            if (searchResult2.size() == 0) {
                                // Informs the user if no matching dishwashers were found.
                                System.out.println("No appliances found.");
                            } else {
                                // Displays the matching dishwashers.
                                for (Appliance d : searchResult2) {
                                    System.out.println(d);
                                    System.out.println("\n");
                                }
                                // Clears the search result.
                                searchResult2.clear();
                            }
                            break;
                    }
                    break;
                // Option for generating a random Appliance list.
                case "4":
                    // Prompts the user to enter the number of appliances they want to display.
                    System.out.println("Enter number of appliances:");
                    keyboardInput = new Scanner(System.in);
                    String userInput = keyboardInput.nextLine();
                    int NumOfAppliance = Integer.parseInt(userInput);
                    int counter = 0;
                    // Creates a random number generator.
                    Random temp = new Random();
                    while (counter < NumOfAppliance) {
                        // Generates random indexes to pick random appliances from the container list.
                        int randomIndex = temp.nextInt(containerList.size());
                        System.out.println(containerList.get(randomIndex));
                        System.out.println("\n");
                        counter++;
                    }
                    break;
                // Option for saving the data and exiting the program.
                case "5":
                    // A list to hold formatted strings of appliance data to write back to the file.
                    List<String> writeList = new ArrayList<>();
                    for (Appliance a : containerList) {
                        // Formats the Appliance information for writing to the file.
                        String eachLines = a.FormatForFile();
                        writeList.add(eachLines);
                    }
                    // The path of the file to write the data back to.
                    Path filePath = Paths.get(path);
                    // Writes the formatted appliance information back to the file.
                    Files.write(filePath, writeList);
                    System.out.println("Bye!");
                    break;
            }
        }
    }
}