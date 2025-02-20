package shapes;

// This class represents a 3D Square Prism, extending the Shape3D class.
public class SquarePrism extends Shape3D {
    
    /**
     * Default constructor for SquarePrism.
     * Calls the default constructor of the parent class (Shape3D).
     */
    public SquarePrism() {
        super();  // Invokes the default constructor of Shape3D.
    }
    
    /**
     * Parameterized constructor for SquarePrism.
     * 
     * @param height The height of the square prism.
     * @param base_length The length of one side of the square base.
     */
    public SquarePrism(double height, double base_length) {
        super(height, base_length);  // Invokes the parameterized constructor of Shape3D.
    }

    /**
     * Calculates and returns the volume of the square prism.
     * 
     * The volume of a prism is given by the product of the base area and the height.
     * 
     * @return The volume of the square prism.
     */
    @Override
    public double getVolume() {
        return getBaseArea() * super.height;  // Volume = Base Area * Height
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