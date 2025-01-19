// Define the package name as modernAppliance
package modernAppliance;

// Define an abstract class Appliance, used to represent electrical appliances
public abstract class Appliance {

    // The serial number of the electrical Appliance
    long itemNumber;
    // The brand of the electrical Appliance
    String brand;
    // The inventory quantity of the electrical Appliance
    int quantity;
    // The power of the electrical Appliance
    double wattage;
    // The color of the electrical Appliance
    String color;
    // The price of the electrical Appliance
    double price;


    // Method to get the item number
    public long getItemNumber() {
        return itemNumber;
    }


    // Method to set the item number
    public void setItemNumber(long itemNumber) {
        this.itemNumber = itemNumber;
    }


    // Method to get the brand
    public String getBrand() {
        return brand;
    }


    // Method to set the brand
    public void setBrand(String brand) {
        this.brand = brand;
    }


    // Method to get the quantity
    public int getQuantity() {
        return quantity;
    }


    // Method to set the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // Method to get the wattage
    public double getWattage() {
        return wattage;
    }


    // Method to set the wattage
    public void setWattage(double wattage) {
        this.wattage = wattage;
    }


    // Method to get the color
    public String getColor() {
        return color;
    }


    // Method to set the color
    public void setColor(String color) {
        this.color = color;
    }


    // Method to get the price
    public double getPrice() {
        return price;
    }


    // Method to set the price
    public void setPrice(double price) {
        this.price = price;
    }


    // No-argument constructor, used to create an electrical Appliance object
    public Appliance() {

    }


    // Parameterized constructor, used to create an electrical Appliance object and initialize its attributes
    public Appliance(long itemNumber, String brand, int quantity, double wattage, String color, double price) {
        super();
        this.itemNumber = itemNumber;
        this.brand = brand;
        this.quantity = quantity;
        this.wattage = wattage;
        this.color = color;
        this.price = price;
    }


    // Check if the electrical Appliance is available in stock
    public boolean isAvailable() {
        // If the quantity is greater than 0, it means there is stock
        return quantity > 0;
    }


    // Perform the checkout operation, which will reduce the inventory quantity
    public void checkout() {
        this.quantity--;
    }


    // Output the electrical Appliance information in string form for easy viewing
    @Override
    public String toString() {
        return "ItemNumber: " + itemNumber + "\n" + "Brand: " + brand  + "\n" + "Quantity: " + quantity + "\n" + "Wattage: " + wattage + "\n" + "Color: " + color  + "\n" + "Price: " + price ;
    }


    // Output the electrical Appliance information in the format required for file storage
    public String formatForFile() {
        return itemNumber + ";" + brand + ";" + quantity + ";" + wattage + ";" + color + ";" + price + ";";
    }


    // Abstract method, used to output the electrical Appliance information in a specific file format, and the specific implementation is completed by subclasses
    public abstract String FormatForFile();
}