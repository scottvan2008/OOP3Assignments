package modernAppliance;

// Defines a class named Microwave that extends the Appliance class
public class Microwave extends Appliance {

    // Declares a variable to store the capacity of the Microwave
    double capacity;
    // Declares a variable to store the type of room where the Microwave is used
    char roomType;

    // Method to get the capacity of the Microwave
    public double getCapacity() {
        return capacity;
    }

    // Method to set the capacity of the Microwave
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    // Method to get the room type of the Microwave
    public char getRoomType() {
        return roomType;
    }

    // Method to set the room type of the Microwave
    public void setRoomType(char roomType) {
        this.roomType = roomType;
    }

    // Default constructor
    public Microwave() {
        // Automatically generated constructor body, more initialization logic can be added as needed
    }

    // Parameterized constructor that takes multiple parameters to initialize the object
    public Microwave(long itemNumber, String brand, int quantity, double wattage, String color, double price, double capacity, char roomType) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.capacity = capacity;
        this.roomType = roomType;
    }

    // Converts the object into a string representation, including information inherited from the superclass and newly added capacity and room type information
    public String toString() {
        String roomTypeFullDes = "";
        // Converts the room type code into a full description using a switch statement
        switch (this.roomType) {
            case 'K':
                roomTypeFullDes = "Kitchen";
                break;
            case 'W':
                roomTypeFullDes = "Work Site";
                break;
        }
        return super.toString() + "\n" + "Capacity: " + capacity + "\n" + "Room Type: " + roomTypeFullDes;
    }

    // Generates a string representation for file storage, including superclass information, capacity, and room type, separated by semicolons
    public String FormatForFile() {
        return super.formatForFile() + capacity + ";" + roomType + ";";
    }
}