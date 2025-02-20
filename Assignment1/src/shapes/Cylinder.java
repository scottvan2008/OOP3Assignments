package shapes;

/**
 * Represents a 3D Cylinder shape, which is a subclass of Shape3D.
 * A cylinder has a height and a base length (radius), and provides methods
 * to calculate its volume and base area.
 */
public class Cylinder extends Shape3D {

    /**
     * Default constructor for the Cylinder class.
     * Initializes the Cylinder with default values for height and base length (radius).
     */
    public Cylinder() {
        super(); // Calls the default constructor of the parent class (Shape3D)
    }

    /**
     * Parameterized constructor for the Cylinder class.
     * Initializes the Cylinder with the given height and base length (radius).
     *
     * @param height      The height of the cylinder.
     * @param base_length The base length (radius) of the cylinder.
     */
    public Cylinder(double height, double base_length) {
        super(height, base_length); // Calls the parameterized constructor of the parent class (Shape3D)
    }

    /**
     * Calculates and returns the volume of the cylinder.
     * The formula for the volume of a cylinder is:
     * Volume = π * r² * h
     * where r is the base length (radius) and h is the height.
     *
     * @return The volume of the cylinder.
     */
    @Override
    public double getVolume() {
        return Math.PI * super.base_length * super.base_length * super.height;
    }

    /**
     * Calculates and returns the base area of the cylinder.
     * The formula for the base area of a cylinder is:
     * Base Area = π * r²
     * where r is the base length (radius).
     *
     * @return The base area of the cylinder.
     */
    @Override
    public double getBaseArea() {
        return Math.PI * super.base_length * super.base_length;
    }
}