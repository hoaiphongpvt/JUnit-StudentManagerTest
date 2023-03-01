public class Student {
    private String firstName;
    private String lastName;
    private int Age;
    private  String Adress;
    private String PhoneNumber;

    public Student(String firstName,String lastName, int age, String adress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Age = age;
        this.Adress = adress;
        this.PhoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getAge() {
        return Age;
    }

    public String getAdress() {
        return Adress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void validateFirstName() {
        if(this.firstName.isBlank()) {
            throw new RuntimeException("First name cannot be null or empty");
        }
    }

    public void validateLastName() {
        if(this.lastName.isBlank()) {
            throw new RuntimeException("Last name cannot be null or empty");
        }
    }

    public void validatePhoneNumber() {
        if (this.PhoneNumber.isBlank()){
            throw new RuntimeException("Phone Name Cannot be null or empty");
        }

        if (this.PhoneNumber.length() != 10) {
            throw new RuntimeException("Phone Number Should be 10 Digits Long");
        }
        if (!this.PhoneNumber.matches("\\d+")) {
            throw new RuntimeException("Phone Number Contain only digits");
        }
        if (!this.PhoneNumber.startsWith("0")) {
            throw new RuntimeException("Phone Number Should Start with 0");
        }
    }
}
