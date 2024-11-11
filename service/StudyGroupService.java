package service;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.StudyGroup;
import model.Teacher;
import model.Type;
import model.User;

public class StudyGroupService {

    private List<User> userList;

    private List<StudyGroup> groupList;

    public StudyGroupService() {
        this.userList = new ArrayList<>();
        this.groupList = new ArrayList<>();
    }

    public void create(String firstName, String middleName, String lastName, Type type) {
        int id = getFreeId(type);
        if (Type.STUDENT == type) {
            Student student = new Student(firstName, middleName, lastName, id);
            userList.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(firstName, middleName, lastName, id);
            userList.add(teacher);
        }
    }

    private int getFreeId(Type type) {
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent) {
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if (user instanceof Student && itsStudent) {
                lastId = ((Student) user).getStudentId() + 1;
            }
        }
        return lastId;
    }

    public void studyGroup(Teacher teacher, List<Student> students) {
        groupList.add(new StudyGroup(teacher, students));
    }

    public User getUserById(Type type, int id) {
        boolean itsStudent = Type.STUDENT == type;
        User currentuser = null;

        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherId() == id) {
                currentuser = user;
            }
            if (user instanceof Student && itsStudent && ((Student) user).getStudentId() == id) {
                currentuser = user;
            }
        }
        return currentuser;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public List<User> getAllStudents() {
        List<User> finaltList = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                finaltList.add(user);
            }
        }
        return finaltList;
    }

    public List<User> getAllTeachers() {
        List<User>finalList = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Teacher) {
                finalList.add(user);
            }
        }
        return finalList;
    }
}
