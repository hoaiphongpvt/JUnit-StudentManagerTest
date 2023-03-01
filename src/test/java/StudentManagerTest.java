import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class StudentManagerTest {

    StudentManager studentManager;
    @BeforeAll
    public static void setupAll() {
        System.out.println("Should print before all tests");
    }

    @BeforeEach
    public void setup() {
        studentManager = new StudentManager();
    }
    @Test
    public void shouldCreateStudent() {
        studentManager.addStudent("Phong","Nguyen",21, "LA", "0855559851");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1, studentManager.getAllStudents().size());
    }
    @Test
    @DisplayName("Should Not Create Student When First Name Is Null")
    public void shouldThrowRunTimeExceptionWhenFirstNameIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            studentManager.addStudent(null, "Le", 20, "HCM", "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Student When Last Name Is Null")
    public void shouldThrowRunTimeExceptionWhenLastNameIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            studentManager.addStudent("Phuc", null, 20, "HCM", "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Student When Phone Number Is Null")
    public void shouldThrowRunTimeExceptionWhenPhoneNumberIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            studentManager.addStudent("Chau", "Tran", 20, "HCM", null);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should execute after each test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should execute at the end of the test");
    }

    //Conditional Executions
    @Test
    @DisplayName("Should Create Student Only On MAC")
    @EnabledOnOs(value = OS.MAC, disabledReason = "Disable on MAC OS")
    public void shouldCreateStudentOnlyOnMAC() {
        studentManager.addStudent("Phong", "Nguyen", 21, "LA", "0855559851");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1, studentManager.getAllStudents().size());
        Assertions.assertTrue(studentManager.getAllStudents().stream()
                .filter(student -> student.getFirstName().equals("Phong") &&
                        student.getLastName().equals("Nguyen") &&
                        student.getAdress().equals("LA") &&
                        student.getPhoneNumber().equals("0855559851"))
                .findAny()
                .isPresent());
    }


    @Test
    @DisplayName("Should Create Student Only On Windows")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Disable on Windows OS")
    public void shouldCreateStudentOnlyOnWindows() {
        studentManager.addStudent("Phong", "Nguyen", 21, "LA", "0855559851");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1, studentManager.getAllStudents().size());
        Assertions.assertTrue(studentManager.getAllStudents().stream()
                .filter(student -> student.getFirstName().equals("Phong") &&
                        student.getLastName().equals("Nguyen") &&
                        student.getAdress().equals("LA") &&
                        student.getPhoneNumber().equals("0855559851"))
                .findAny()
                .isPresent());
    }

    //Assumptions
    @Test
    @Disabled
    @DisplayName("Test Student Creation On Developer Machine")
    public void shouldTestStudentCreationOnDEV() {
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        studentManager.addStudent("Phong", "Nguyen", 21, "LA", "0855559851");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1, studentManager.getAllStudents().size());
    }

    //Repected Tests
    @DisplayName("Repeat Student Creation Test 3 Times")
    @RepeatedTest(value = 3)
    public void shouldTestStudentCreationRepeatedly() {
        studentManager.addStudent("Phong", "Nguyen", 21, "LA", "0855559851");
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1, studentManager.getAllStudents().size());
    }

    //Parameterized Tests
    //Parameterized Test using ValueSource
    @DisplayName("Repeat Student Creation Test 3 Times With Parameterized Test using ValueSource")
    @ParameterizedTest
    @ValueSource(strings = {"0855559851", "0855559851", "0855559851"})
    public void shouldTestStudentCreationUsingValueSource(String phoneNumber) {
        studentManager.addStudent("Phong", "Nguyen", 21, "LA", phoneNumber);
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1, studentManager.getAllStudents().size());
    }

    //Parameterized Test using ValueSource
    @DisplayName("Repeat Student Creation Test 3 Times With Parameterized Test using ValueSource")
    @ParameterizedTest
    @MethodSource("phoneNumberList")
    public void shouldTestStudentCreationUsingMethodSource(String phoneNumber) {
        studentManager.addStudent("Phong", "Nguyen", 21, "LA", phoneNumber);
        Assertions.assertFalse(studentManager.getAllStudents().isEmpty());
        Assertions.assertEquals(1, studentManager.getAllStudents().size());
    }

    private static List<String> phoneNumberList() {
        return Arrays.asList("0855559851", "0855559851", "0855559851");
    }

    //Nested Tests
    //Disable Tests
}
