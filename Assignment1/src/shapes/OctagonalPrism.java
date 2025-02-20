package shapes;

// This class represents a 3D Octagonal Prism, extending the Shape3D class.
public class OctagonalPrism extends Shape3D {
    
    /**
     * Default constructor for OctagonalPrism.
     * Calls the default constructor of the parent class (Shape3D).
     */
    public OctagonalPrism() {
        super();  // Invokes the default constructor of Shape3D.
    }
    
    /**
     * Parameterized constructor for OctagonalPrism.
     * 
     * @param height The height of the octagonal prism.
     * @param base_length The length of one side of the octagonal base.
     */
    public OctagonalPrism(double height, double base_length) {
        super(height, base_length);  // Invokes the parameterized constructor of Shape3D.
    }

    /**
     * Calculates and returns the volume of the octagonal prism.
     * 
     * The volume of a prism is given by the product of the base area and the height.
     * 
     * @return The volume of the octagonal prism.
     */
    @Override
    public double getVolume() {
        return getBaseArea() * super.height;  // Volume = Base Area * Height
    }

    /**
     * Calculates and returns the area of the octagonal base.
     * 
     * The formula for the area of a regular octagon with side length 'a' is:
     * Area = 2 * (1 + sqrt(2)) * a^2
     * 
     * @return The area of the octagonal base.
     */
    @Override
    public double getBaseArea() {
        // Calculate the area of the octagonal base using the formula.
        return 2 * (1 + Math.sqrt(2)) * super.base_length * super.base_length;
    }
    
}