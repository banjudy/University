package faculties;

public enum FacultyType {

    ANG("anglisztika"),
    GER("germanisztika"),
    INF("informatikus könyvtáros"),
    JAP("japán"),
    CLF("klasszika filológia"),
    HUN("magyar"),
    SCA("skandinavisztika"),
    HIS("történelem"),
    OTHER("other");

    public final String description;

    FacultyType(String description) {
        this.description = description;
    }

    public static FacultyType getFacultyPerDescription (String str) {
        for (FacultyType facultyType : FacultyType.values()) {
            if (facultyType.description.equals(str)) {
                return facultyType;
            }
        }
        return FacultyType.OTHER;
    }

    public String getDescription() {
        return description;
    }

}
