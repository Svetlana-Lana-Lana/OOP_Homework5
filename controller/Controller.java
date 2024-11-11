package controller;
import java.util.List;
import View.StudentView;
import View.TeacherView;
import model.Student;
import model.StudyGroup;
import model.Teacher;
import model.Type;
import model.User;
import service.StudyGroupService;


public class Controller {

    private final StudyGroupService service = new StudyGroupService();

    private final StudentView studentView  = new StudentView();

    private final TeacherView teacherView = new TeacherView();

    public void createStudent(String firstName, String middleName, String lastName){
        service.create(firstName, middleName, lastName, Type.STUDENT);
    }

    public void createTeacher(String firstName, String middleName, String lastName){
        service.create(firstName, middleName, lastName, Type.TEACHER);
    }

    public void createStudyGroup(Teacher teacher, List<Student> students){
        service.studyGroup(teacher, students);
    }

    public List<Student> getAllStudents() {
        List<User> userList = service.getAllStudents();
        for (User user : userList) {
            Student student = (Student) user;
            studentView.printOnConsole(student);  
        }
        return null;
    }

     public Teacher getAllTeachers() {
        List<User> userList = service.getAllTeachers();
        for (User user : userList) {
            Teacher teacher = (Teacher) user;
            teacherView.printOnConsole(teacher);
        }
        return null;       
    }

    public StudyGroup getStudyGroup(){
        for (User user : service.getAllTeachers()) {
            Teacher teacher = (Teacher) user;
            teacherView.printOnConsole(teacher);
        }
        for (User user : service.getAllStudents()) {
            Student student = (Student) user;
            studentView.printOnConsole(student);
        }
        return null;
    }
}

    
