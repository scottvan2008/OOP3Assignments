package modernAppliance;

// Defines a class named Vacuum that extends the Appliance class
public class Vacuum extends Appliance {

    String grade;
    int batteryVoltage;


    // Gets the value of the grade property
    public String getGrade() {
        return grade;
    }

    // Sets the value of the grade property
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Gets the value of the batteryVoltage property
    public int getBatteryVoltage() {
        return batteryVoltage;
    }

    // Sets the value of the batteryVoltage property
    public void setBatteryVoltage(int batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    // No-argument constructor
    public Vacuum() {
        // You can add initialization logic here, currently it's an auto-generated constructor
    }

    // Parameterized constructor, receives various parameters to initialize the Vacuum object
    public Vacuum(long itemNumber, String brand, int quantity, double wattage, String color, double price, String grade, int batteryVoltage) {
        super(itemNumber, brand, quantity, wattage, color, price);
        // Assigns a value to the grade property
        this.grade = grade;
        // Assigns a value to the batteryVoltage property
        this.batteryVoltage = batteryVoltage;
    }

    // Converts the batteryVoltage value to a more descriptive string based on its value and returns it
    public String toString() {
        String voltageFullDes = "";
        // Assigns different descriptions to voltageFullDes based on different battery voltage values
        switch (this.batteryVoltage) {
            case 18:
                voltageFullDes = "Low";
                break;
            case 24:
                voltageFullDes = "High";
                break;
        }
        // Calls the toString method of the parent class and adds the description information of grade and batteryVoltage
        return super.toString() + "\nGrade: " + grade +"\nBattery voltage: " + voltageFullDes;
    }

    // Formats the object's information into a string suitable for storing in a file, separated by semicolons
    public String FormatForFile() {
        // Calls the formatForFile method of the parent class and adds information about grade and batteryVoltage
        return super.formatForFile() + grade + ";" + batteryVoltage + ";";
    }
}