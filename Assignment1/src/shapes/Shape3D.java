package shapes;

import appDomain.AppDriver;
import utilities.VolumeAndBaseCompare;

// This abstract class represents a 3D shape and implements the Comparable interface.
// It provides common properties and methods for all 3D shapes, such as height, base length,
// volume, and base area calculations. It also supports sorting based on different criteria.
public abstract class Shape3D implements Comparable<Shape3D> {

    // The height of the 3D shape.
    public double height;

    // The base length of the 3D shape (e.g., side length of a polygonal base).
    public double base_length;

    /**
     * Default constructor for Shape3D.
     * Initializes the shape with default values for height and base length.
     */
    public Shape3D() {
        // Default constructor does not initialize height and base_length explicitly.
    }

    /**
     * Compares this 3D shape with another based on the sorting type specified in AppDriver.
     * 
     * If the sort type is 'h' (height), it compares the heights of the two shapes.
     * Otherwise, it uses the VolumeAndBaseCompare class to compare based on volume or base area.
     *
     * @param that The other 3D shape to compare with.
     * @return A negative integer, zero, or a positive integer as this shape is less than,
     *         equal to, or greater than the specified shape.
     */
    public int compareTo(Shape3D that) {
        if (AppDriver.sortType == 'h') {
            return Double.compare(this.getHeight(), that.getHeight());  // Compare by height.
        } else {
            VolumeAndBaseCompare vb = new VolumeAndBaseCompare();
            return vb.compare(this, that);  // Use custom comparator for volume or base area.
        }
    }

    /**
     * Getter method to retrieve the height of the 3D shape.
     *
     * @return The height of the 3D shape.
     */
    public double getHeight() {
        return height;  // Returns the height of the shape.
    }

    /**
     * Setter method to set the height of the 3D shape.
     *
     * @param height The new height value to set.
     */
    public void setHeight(double height) {
        this.height = height;  // Sets the height of the shape.
    }

    /**
     * Getter method to retrieve the base length of the 3D shape.
     *
     * @return The base length of the 3D shape.
     */
    public double getBase_length() {
        return base_length;  // Returns the base length of the shape.
    }

    /**
     * Setter method to set the base length of the 3D shape.
     *
     * @param base_length The new base length value to set.
     */
    public void setBase_length(double base_length) {
        this.base_length = base_length;  // Sets the base length of the shape.
    }

    /**
     * Parameterized constructor for Shape3D.
     *
     * @param height The height of the 3D shape.
     * @param base_length The base length of the 3D shape.
     */
    public Shape3D(double height, double base_length) {
        super();  // Calls the default constructor of Object class.
        this.height = height;  // Initializes the height.
        this.base_length = base_length;  // Initializes the base length.
    }

    /**
     * Abstract method to calculate the volume of the 3D shape.
     * This method must be implemented by any concrete subclass.
     *
     * @return The volume of the 3D shape.
     */
    public abstract double getVolume();

    /**
     * Abstract method to calculate the base area of the 3D shape.
     * This method must be implemented by any concrete subclass.
     *
     * @return The base area of the 3D shape.
     */
    public abstract double getBaseArea();

    /**
     * Generates a string representation of the 3D shape based on the sorting type.
     * 
     * - If the sort type is 'h', it displays the height.
     * - If the sort type is 'v', it displays the volume.
     * - If the sort type is 'a', it displays the base area.
     * - For invalid sort types, it returns an error message.
     *
     * @return A string describing the shape's property based on the sort type.
     */
    public String print() {
        switch (AppDriver.sortType) {
            case 'h':
                return getClass().getSimpleName() + " has a height of " + getHeight();
            case 'v':
                return getClass().getSimpleName() + " has a volume of " + getVolume();
            case 'a':
                return getClass().getSimpleName() + " has a base area of " + getBaseArea();
            default:
                return "Invalid sort type: -t or -T followed by v (volume), h (height) or a (base area) with no spaces";
        }
    }
}