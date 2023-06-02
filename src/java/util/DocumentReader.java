package util;

import faculties.FacultyType;
import faculties.Units;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DocumentReader {

    private static final String SOURCE_FILE = "src/resources/szakok.txt";
    public static Map<FacultyType, List<Units>> allUnits = new HashMap<>();

    public static void readFile () throws IOException {
        FileReader fileReader = new FileReader(SOURCE_FILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (String line; (line = bufferedReader.readLine()) != null;) {
            String[] parts = line.split(";");
            Units currentUnit = new Units(parts);
            allUnits.putIfAbsent(
                    currentUnit.getFacultyType(),
                    new ArrayList<>()
                    );
            allUnits.get(currentUnit.getFacultyType()).add(currentUnit);
        }
    }

    public static Map<FacultyType, List<Units>> getAllUnits() {
        return allUnits;
    }
}
