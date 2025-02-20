package utilities;

import java.util.Comparator;
import appDomain.AppDriver;
import shapes.Shape3D;

// This class implements the Comparator interface to compare 3D shapes based on their volume or base area.
// The comparison type is determined by the sortType specified in AppDriver.
public class VolumeAndBaseCompare implements Comparator<Shape3D> {

    /**
     * Compares two 3D shapes based on the sorting type specified in AppDriver.
     * 
     * - If the sort type is 'v' (volume), it compares the volumes of the two shapes.
     * - If the sort type is 'a' (base area), it compares the base areas of the two shapes.
     * - For any other sort type, it returns 0, indicating no specific order.
     *
     * @param o1 The first 3D shape to compare.
     * @param o2 The second 3D shape to compare.
     * @return A negative integer, zero, or a positive integer as the first shape is less than,
     *         equal to, or greater than the second shape based on the specified sort type.
     */
    @Override
    public int compare(Shape3D o1, Shape3D o2) {
        switch (AppDriver.sortType) {
            case 'v':
                // Compare the volumes of the two shapes.
                return Double.compare(o1.getVolume(), o2.getVolume());
            case 'a':
                // Compare the base areas of the two shapes.
                return Double.compare(o1.getBaseArea(), o2.getBaseArea());
            default:
                // Return 0 for unsupported sort types, indicating no specific order.
                return 0;
        }
    }
}