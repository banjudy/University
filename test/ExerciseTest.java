import exercise.Exercise;
import faculties.FacultyType;
import faculties.Units;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseTest {
    private Map<FacultyType, List<Units>> allUnitTest = new HashMap<>();
    private Exercise exam = new Exercise();

    @BeforeClass
    public void getUnitsForTest() throws IOException {
        this.allUnitTest = exam.firstTaskMethod();
    }

    @Test
    public void firstTaskMethod() {
        Assert.assertNotNull(allUnitTest);
    }

    @Test
    public void secondTaskMethod() {
    }
}