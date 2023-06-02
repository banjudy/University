package exercise;

import faculties.FacultyType;
import faculties.UnitType;
import faculties.Units;
import util.DocumentReader;

import java.io.IOException;
import java.util.*;

public class Exercise {

    /**
     * 1. Olvasd be a fájlt szak szerint rendezve!
     */
    public static Map<FacultyType, List<Units>> firstTaskMethod() throws IOException {
        DocumentReader.readFile();
        Map<FacultyType, List<Units>> firstTask = DocumentReader.allUnits;
        return firstTask;
    }

    /**
     * 2. Írj metódust, amely visszaadja (adatszerkezetben) azokat a tanegységeket, amelyeknek van gyenge előfeltétele.
     */
    public static Set<String> secondTaskMethod(Map<FacultyType, List<Units>> allUnits) {
        Set<String> unitsWithLowPrecondition = new HashSet<>();
        for (List<Units> unitsList : allUnits.values()) {
            for (Units currentUnit : unitsList) {
                for (String preconditions : currentUnit.getPreconditions())
                    if (preconditions.contains(Character.toString('*'))) {
                        unitsWithLowPrecondition.add(currentUnit.getUnitName());
                    }
            }
        }
        return unitsWithLowPrecondition;
    }

    /**
     * 3. Írj metódust, amely két bemeneti paramétert kap: a szakhoz tartozó tanegységek listáját és egy félévet
     * (a félév számát), és visszaadja (adatszerkezetben) azokat a tanegységeket, amelyek arra a félévre vannak ajánlva.
     */
    public static Set<String> thirdTaskMethod(List<Units> unitList, int specificSemester) {
        Set<String> unitsPerSemester = new HashSet<>();
        for (Units currentUnit : unitList) {
            for (int semester : currentUnit.getSemesters()) {
                if (semester == specificSemester) {
                    unitsPerSemester.add(currentUnit.getUnitName());
                }
            }
        }
        System.out.println();
        return unitsPerSemester;
    }

    /**
     * 4. Írj metódust, amely visszaadja az első legtöbb előfeltétellel rendelkező tanegységet szakokra lebontva!
     */
    public static Map<FacultyType, String> fourthTaskMethod(Map<FacultyType, List<Units>> allUnit) {
        Map<FacultyType, String> mostPrecondition = new HashMap<>();
        for (FacultyType facultyType : allUnit.keySet()) {
            for (List<Units> unitsList : allUnit.values()) {
                mostPrecondition.putIfAbsent(facultyType, getMostPrecond(unitsList, facultyType));
            }
        }
        return mostPrecondition;
    }

    public static String getMostPrecond(List<Units> unitsList, FacultyType facultyType) {
        Units resultUnit = new Units();
        for (Units currentUnit : unitsList) {
            if (currentUnit.getPreconditions().size() > resultUnit.getPreconditions().size()
                    && currentUnit.getFacultyType().equals(facultyType)) {
                resultUnit = currentUnit;
            }
        }
        return resultUnit.getUnitName();
    }

    /**
     * 5. Írj metódust, amely visszaadja, hogy szakonként mekkora a K (kollokvium) és a G (gyakorlat) tanegységek aránya!
     */
    public static Map<FacultyType, List<Integer>> fifthTask(Map<FacultyType, List<Units>> allUnit) {
        int countUnits = 0;
        Map<FacultyType, List<Integer>> fifthTask = new HashMap<>();
        for (FacultyType facultyType : allUnit.keySet()) {
            for (List<Units> unitsList : allUnit.values()) {
                countUnits = unitsList.size();
                fifthTask.putIfAbsent(facultyType, fifthTaskAdditional(allUnit.get(facultyType), facultyType));
            }
        }
        return fifthTask;
    }

    public static List<Integer> fifthTaskAdditional(List<Units> unitsList, FacultyType facultyType) {
        List<Integer> unitTypeKG = new ArrayList<>();
        int counterK = 0;
        int counterG = 0;
        for (Units currentUnit : unitsList) {
            if (currentUnit.getUnitType().equals(UnitType.K)) {
                counterK++;
            }
            if (currentUnit.getUnitType().equals(UnitType.G)) {
                counterG++;
            }
        }
        unitTypeKG.add(counterK);
        unitTypeKG.add(counterG);
        return unitTypeKG;
    }

    public static int getSizeOfUnitsPerFaculty(Map<FacultyType, List<Units>> allUnit) {
        int countUnits = 0;
        for (FacultyType facultyType : allUnit.keySet()) {
            for (List<Units> unitsList : allUnit.values()) {
                countUnits = unitsList.size();
            }
        }
        return countUnits;
    }

    /**
     * 6. Írj metódust, amely visszaadja az összes olyan tanegységet, amelynek megnevezésében szerepel a “nyelv” szó!
     * (Akár szóelemként is. Tehát a metódus keresi és megtalálja a tanegységet, amelynek megnevezésében
     * akár a “nyelv”, akár a “nyelvismeret”, akár a “nyelvtudomány” stb. szerepel.)
     */
    public static Set<Units> sixthTask(Map<FacultyType, List<Units>> allUnit) {
        Set<Units> sixthTask = new HashSet<>();
        for (FacultyType facultyType : allUnit.keySet()) {
            for (List<Units> unitsList : allUnit.values()) {
                for (Units currentUnit : unitsList) {
                    if (currentUnit.getUnitName().contains("nyelv")) {
                        sixthTask.add(currentUnit);
                    }
                }
            }
        }
        return sixthTask;
    }
}
