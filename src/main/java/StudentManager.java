import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StudentManager {
    Map<String, Student> studentList = new ConcurrentHashMap<String, Student>();

    public void addStudent(String fname, String lname, int age, String address, String phoneNumber) {
        Student student = new Student(fname,lname, age, address, phoneNumber);
        validateStudent(student);
        checkIfStudentAlreadyExist(student);
        studentList.put(generateKey(student), student);
    }

    public Collection<Student> getAllStudents() {
        return studentList.values();
    }

    private void checkIfStudentAlreadyExist(Student student) {
        if (studentList.containsKey(generateKey(student))) {
            throw new RuntimeException("Student already exists");
        }
    }

    private void validateStudent(Student student) {
        student.validateFirstName();
        student.validateLastName();
        student.validatePhoneNumber();
    }

    private String generateKey(Student student) {
        return String.format("%s-%s", student.getFirstName(), student.getLastName());
    }
}
