package faculties;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Units {

    private FacultyType facultyType;
    private String unitCode;
    private String unitName;
    private UnitType unitType;
    private List<Integer> semesters;
    private int credit;
    private List<String> preconditions = new ArrayList<>();

    public Units() {}

    public Units(String[] parts) {
        this(
                parts[0],
                parts[1],
                parts[2],
                UnitType.valueOf(parts[3]),
                Utils.prepareIntegerListFromString(Arrays.asList(parts[4].split("\\|"))),
                Integer.parseInt(parts[5]),
                Arrays.asList(parts[6].split("\\|"))
        );
    }

    public Units(String facultyType,
                 String unitCode,
                 String unitName,
                 UnitType unitType,
                 List<Integer> semesters,
                 int credit,
                 List<String> preconditions) {
        this.facultyType = FacultyType.getFacultyPerDescription(facultyType);
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.unitType = unitType;
        this.semesters = semesters;
        this.credit = credit;
        this.preconditions = preconditions;
    }

    public FacultyType getFacultyType() {
        return facultyType;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public List<Integer> getSemesters() {
        return semesters;
    }

    public int getCredit() {
        return credit;
    }

    public List<String> getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(List<String> preconditions) {
        this.preconditions = preconditions;
    }
}
