package shapes;

// This abstract class represents a generic 3D shape and implements the Comparable interface.
// It provides common properties and methods for all 3D shapes, such as height, volume, and base area calculations.
public abstract class Shape implements Comparable<Shape> {

    // The height of the shape, a common property for all 3D shapes.
    protected double height;

    /**
     * Constructor to initialize the height of the shape.
     *
     * @param height The height of the shape.
     */
    public Shape(double height) {
        this.height = height;  // Sets the height of the shape.
    }

    /**
     * Getter method to retrieve the height of the shape.
     *
     * @return The height of the shape.
     */
    public double getHeight() {
        return height;  // Returns the height of the shape.
    }

    /**
     * Abstract method to calculate the volume of the shape.
     * This method must be implemented by any concrete subclass.
     *
     * @return The volume of the shape.
     */
    public abstract double calcVolume();

    /**
     * Abstract method to calculate the base area of the shape.
     * This method must be implemented by any concrete subclass.
     *
     * @return The base area of the shape.
     */
    public abstract double calcBaseArea();

    /**
     * Compares this shape with another shape based on their heights.
     * Implements the compareTo method from the Comparable interface.
     *
     * @param other The other shape to compare with.
     * @return A negative integer, zero, or a positive integer as this shape's height
     *         is less than, equal to, or greater than the specified shape's height.
     */
    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.height, other.height);  // Compares heights using Double.compare.
    }

    /**
     * Returns a string representation of the shape, including its height.
     *
     * @return A string in the format "Height: [height]".
     */
    @Override
    public String toString() {
        return "Height: " + height;  // Returns the height as part of the string representation.
    }
}