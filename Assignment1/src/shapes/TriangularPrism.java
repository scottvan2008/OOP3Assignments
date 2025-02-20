package shapes;

// This class represents a 3D Triangular Prism, extending the Shape3D class.
public class TriangularPrism extends Shape3D {
    
    /**
     * Default constructor for TriangularPrism.
     * Calls the default constructor of the parent class (Shape3D).
     */
    public TriangularPrism() {
        super();  // Invokes the default constructor of Shape3D.
    }
    
    /**
     * Parameterized constructor for TriangularPrism.
     * 
     * @param height The height of the triangular prism.
     * @param base_length The length of one side of the equilateral triangular base.
     */
    public TriangularPrism(double height, double base_length) {
        super(height, base_length);  // Invokes the parameterized constructor of Shape3D.
    }

    /**
     * Calculates and returns the volume of the triangular prism.
     * 
     * The volume of a prism is given by the product of the base area and the height.
     * 
     * @return The volume of the triangular prism.
     */
    @Override
    public double getVolume() {
        return getBaseArea() * super.height;  // Volume = Base Area * Height
    }

    /**
     * Calculates and returns the area of the equilateral triangular base.
     * 
     * The formula for the area of an equilateral triangle with side length 'a' is:
     * Area = (sqrt(3) / 4) * a^2
     * 
     * @return The area of the equilateral triangular base.
     */
    @Override
    public double getBaseArea() {
        // Calculate the area of the equilateral triangular base using the formula.
        return Math.sqrt(3) * super.base_length * super.base_length / 4;
    }
}