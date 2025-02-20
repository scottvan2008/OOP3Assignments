package shapes;

/**
 * Represents a 3D Cone shape, which is a subclass of Shape3D.
 * A cone has a height and a base length (radius), and provides methods
 * to calculate its volume and base area.
 */
public class Cone extends Shape3D {

    /**
     * Default constructor for the Cone class.
     * Initializes the Cone with default values for height and base length (radius).
     */
    public Cone() {
        super(); // Calls the default constructor of the parent class (Shape3D)
    }

    /**
     * Parameterized constructor for the Cone class.
     * Initializes the Cone with the given height and base length (radius).
     *
     * @param height      The height of the cone.
     * @param base_length The base length (radius) of the cone.
     */
    public Cone(double height, double base_length) {
        super(height, base_length); // Calls the parameterized constructor of the parent class (Shape3D)
    }

    /**
     * Calculates and returns the volume of the cone.
     * The formula for the volume of a cone is:
     * Volume = (π * r² * h) / 3
     * where r is the base length (radius) and h is the height.
     *
     * @return The volume of the cone.
     */
    @Override
    public double getVolume() {
        return Math.PI * super.base_length * super.base_length * super.height / 3;
    }

    /**
     * Calculates and returns the base area of the cone.
     * The formula for the base area of a cone is:
     * Base Area = π * r²
     * where r is the base length (radius).
     *
     * @return The base area of the cone.
     */
    @Override
    public double getBaseArea() {
        return Math.PI * super.base_length * super.base_length;
    }
}