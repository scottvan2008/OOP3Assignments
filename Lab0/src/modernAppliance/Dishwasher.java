// Define the package name as modernAppliance
package modernAppliance;

// Define a class named Dishwasher that extends the Appliance class
public class Dishwasher extends Appliance {

    // The sound rating of the Dishwasher
    String soundRating;
    // The feature of the Dishwasher
    String feature;


    // Method to get the sound rating
    public String getSoundRating() {
        return soundRating;
    }


    // Method to set the sound rating
    public void setSoundRating(String soundRating) {
        this.soundRating = soundRating;
    }


    // Method to get the feature
    public String getFeature() {
        return feature;
    }


    // Method to set the feature
    public void setFeature(String feature) {
        this.feature = feature;
    }


    // Method to get the sound description, which gives a full description based on the sound rating
    public String toString() {
        String soundFullDes = "";
        switch (this.soundRating) {
            // If the rating is Qt, the description is Quietest
            case "Qt":
                soundFullDes = "Quietest";
                break;
            // If the rating is Qr, the description is Quieter
            case "Qr":
                soundFullDes = "Quieter";
                break;
            // If the rating is Qu, the description is Quiet
            case "Qu":
                soundFullDes = "Quiet";
                break;
            // If the rating is M, the description is Moderate
            case "M":
                soundFullDes = "Moderate";
                break;
        }
        // Call the toString method of the parent class and add the feature and sound description information of this class
        return super.toString() + "\n" + "Feature: " + feature + "\n" + "SoundRating: " + soundFullDes;
    }


    // Output the Dishwasher information in the format required for file storage, including the information of the parent class and the features and sound rating of this class
    public String FormatForFile() {
        return super.formatForFile() + feature + ";" + soundRating + ";";
    }


    // No-argument constructor, which may need to be completed according to specific requirements
    public Dishwasher() {
    }


    // Parameterized constructor, used to create a Dishwasher object and initialize its attributes, including the attributes of the parent class and the unique attributes of this class
    public Dishwasher(long itemNumber, String brand, int quantity, double wattage, String color, double price, String feature, String soundRating) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.feature = feature;
        this.soundRating = soundRating;
    }
}