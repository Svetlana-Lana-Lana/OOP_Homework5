package model;

public class Student extends User {

    private int studentId;

    public Student(String firstName, String middleName, String lastName, int studentId) {
        super(firstName, middleName, lastName);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Студент [Id - " + studentId + ", имя - " + getFirstName() + ", отчество - " + getMiddleName() + ", фамилия - " + getLastName() +  "]";
    }
}
