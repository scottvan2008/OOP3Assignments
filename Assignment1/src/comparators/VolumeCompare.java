package comparators;

import java.util.Comparator;
import shapes.Shape;

/**
 * A comparator class that compares two Shape objects based on their volume.
 * This class is used to sort shapes in ascending order of their volume.
 */
public class VolumeCompare implements Comparator<Shape> {

    /**
     * Compares two Shape objects based on their calculated volume.
     * 
     * @param s1 The first Shape object to compare.
     * @param s2 The second Shape object to compare.
     * @return A negative integer if s1's volume is less than s2's volume,
     *         zero if they are equal,
     *         or a positive integer if s1's volume is greater than s2's volume.
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        // Use Double.compare to compare the volumes of the two shapes
        return Double.compare(s1.calcVolume(), s2.calcVolume());
    }
}