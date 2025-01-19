package modernAppliance;

// Define a Refrigerator class that inherits from the Appliance class
public class Refrigerator extends Appliance {

    int numOfDoors;
    double height;
    double width;

    // Get the number of doors
    public int getNumOfDoors() {
        return numOfDoors;
    }

    // Set the number of doors
    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    // Get the height of the Refrigerator
    public double getHeight() {
        return height;
    }

    // Set the height of the Refrigerator
    public void setHeight(double height) {
        this.height = height;
    }

    // Get the width of the Refrigerator
    public double getWidth() {
        return width;
    }

    // Set the width of the Refrigerator
    public void setWidth(double width) {
        this.width = width;
    }

    // No-argument constructor
    public Refrigerator() {
        // This is the stub of the automatically generated constructor, and specific implementation logic can be added as needed
    }

    // Parameterized constructor to initialize various properties of the Refrigerator object
    public Refrigerator(long itemNumber, String brand, int quantity, double wattage, String color, double price, int numOfDoors, double height, double width) {
        super(itemNumber, brand, quantity, wattage, color, price);
        // Assign the passed number of doors to the number of doors property of the Refrigerator object
        this.numOfDoors = numOfDoors;
        // Assign the passed height to the height property of the Refrigerator object
        this.height = height;
        // Assign the passed width to the width property of the Refrigerator object
        this.width = width;
    }

    // Get the description information of the Refrigerator doors and combine it with the description information of the parent class
    public String toString() {
        String doorsFullDes = "";
        switch (this.numOfDoors) {
            case 2:
                doorsFullDes = "Double Doors";
                break;
            case 3:
                doorsFullDes = "Three Doors";
                break;
            case 4:
                doorsFullDes = "Four Doors";
                break;
        }
        return super.toString() + "\nNumber of Doors: " + doorsFullDes + "\nHeight: " + height + "\nWidth: " + width;
    }

    // Concatenate the information of the Refrigerator object in a specific format, used for file storage or transmission, etc.
    public String FormatForFile() {
        return super.formatForFile() + numOfDoors + ";" + height + ";" + width + ";";
    }
}