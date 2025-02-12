package exercise1;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Smith", 34));
        students.add(new Student("Johnson", 21));
        students.add(new Student("Williams", 67));
        students.add(new Student("Brown", 53));
        students.add(new Student("Jones", 48));
        students.add(new Student("Miller", 36));
        students.add(new Student("Davis", 44));
        students.add(new Student("Wilson", 52));
        students.add(new Student("Anderson", 34));
        students.add(new Student("Moore", 33));

        System.out.println("Before sorting: " + students);

        // Sort by name using Comparable (natural ordering)
        Collections.sort(students);
        System.out.println("Sorted by name: " + students);

        // Sort by age using Comparator
        Collections.sort(students, new StudentAgeComparator());
        System.out.println("Sorted by age: " + students);
    }
}

