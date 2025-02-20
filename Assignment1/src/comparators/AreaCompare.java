package comparators;

import java.util.Comparator;
import shapes.Shape;

/**
 * A comparator class that compares two Shape objects based on their base area.
 * This class is used to sort shapes in ascending order of their base area.
 */
public class AreaCompare implements Comparator<Shape> {

    /**
     * Compares two Shape objects based on their calculated base area.
     * 
     * @param s1 The first Shape object to compare.
     * @param s2 The second Shape object to compare.
     * @return A negative integer if s1's base area is less than s2's base area,
     *         zero if they are equal,
     *         or a positive integer if s1's base area is greater than s2's base area.
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        // Use Double.compare to compare the base areas of the two shapes
        return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
    }
}