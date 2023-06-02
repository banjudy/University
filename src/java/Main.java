import exercise.Exercise;
import faculties.FacultyType;
import faculties.Units;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        try {
            Map<FacultyType, List<Units>> allUnit = Exercise.firstTaskMethod();
            Set<String> secondTask = Exercise.secondTaskMethod(allUnit);
            Set<String> thirdTask = Exercise.thirdTaskMethod(allUnit.get(FacultyType.HUN), 2);
            Map<FacultyType, String> fourthTask = Exercise.fourthTaskMethod(allUnit);
            Map<FacultyType, List<Integer>> fifthTask = Exercise.fifthTask(allUnit);
            Set<Units> sixthTask = Exercise.sixthTask(allUnit);

        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
