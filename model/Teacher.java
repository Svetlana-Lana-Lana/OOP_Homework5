package model;

public class Teacher extends User{

    private int teacherId;

    public Teacher(String firstName, String middleName, String lastName, int teacherId) {
        super(firstName, middleName, lastName);
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Преподаватель [Id - " + teacherId + ", имя - " + getFirstName() + ", отчество - " + getMiddleName() + ", фамилия - " + getLastName() + "]";
    }
}
