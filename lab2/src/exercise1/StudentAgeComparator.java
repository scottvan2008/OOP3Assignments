package exercise1;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // First compare by age
        int ageComparison = Integer.compare(s1.getAge(), s2.getAge());
        
        // If ages are equal, compare by name
        if (ageComparison == 0) {
            return s1.getName().compareTo(s2.getName());
        }
        
        return ageComparison;
    }
}
