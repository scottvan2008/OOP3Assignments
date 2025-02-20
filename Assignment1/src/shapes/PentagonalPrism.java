package shapes;

// This class represents a 3D Pentagonal Prism, extending the Shape3D class.
public class PentagonalPrism extends Shape3D {
    
    /**
     * Default constructor for PentagonalPrism.
     * Calls the default constructor of the parent class (Shape3D).
     */
    public PentagonalPrism() {
        super();  // Invokes the default constructor of Shape3D.
    }
    
    /**
     * Parameterized constructor for PentagonalPrism.
     * 
     * @param height The height of the pentagonal prism.
     * @param base_length The length of one side of the pentagonal base.
     */
    public PentagonalPrism(double height, double base_length) {
        super(height, base_length);  // Invokes the parameterized constructor of Shape3D.
    }

    /**
     * Calculates and returns the volume of the pentagonal prism.
     * 
     * The volume of a prism is given by the product of the base area and the height.
     * 
     * @return The volume of the pentagonal prism.
     */
    @Override
    public double getVolume() {
        return getBaseArea() * super.height;  // Volume = Base Area * Height
    }

    /**
     * Calculates and returns the area of the pentagonal base.
     * 
     * The formula for the area of a regular pentagon with side length 'a' is:
     * Area = (5 / 4) * tan(54 degrees) * a^2
     * 
     * Here, Math.tan(Math.toRadians(54)) is used to calculate the tangent of 54 degrees,
     * since Java's Math.tan function expects the angle in radians.
     * 
     * @return The area of the pentagonal base.
     */
    @Override
    public double getBaseArea() {
        // Calculate the area of the pentagonal base using the formula.
        return Math.tan(Math.toRadians(54)) * super.base_length * super.base_length * 5 / 4;
    }
    
}