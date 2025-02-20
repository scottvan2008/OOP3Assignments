package shapes;

// This class represents a 3D Pyramid, extending the Shape3D class.
public class Pyramid extends Shape3D {
    
    /**
     * Default constructor for Pyramid.
     * Calls the default constructor of the parent class (Shape3D).
     */
    public Pyramid() {
        super();  // Invokes the default constructor of Shape3D.
    }
    
    /**
     * Parameterized constructor for Pyramid.
     * 
     * @param height The height of the pyramid.
     * @param base_length The length of one side of the square base.
     */
    public Pyramid(double height, double base_length) {
        super(height, base_length);  // Invokes the parameterized constructor of Shape3D.
    }

    /**
     * Calculates and returns the volume of the pyramid.
     * 
     * The volume of a pyramid is given by the formula:
     * Volume = (Base Area * Height) / 3
     * 
     * @return The volume of the pyramid.
     */
    @Override
    public double getVolume() {
        return getBaseArea() * super.height / 3;  // Volume = (Base Area * Height) / 3
    }

    /**
     * Calculates and returns the area of the square base.
     * 
     * The formula for the area of a square with side length 'a' is:
     * Area = a^2
     * 
     * @return The area of the square base.
     */
    @Override
    public double getBaseArea() {
        // Calculate the area of the square base using the formula.
        return super.base_length * super.base_length;
    }
    
}