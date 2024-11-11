import controller.Controller;

public class Main {
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createTeacher("Александр", "Сергеевич", "Жуков");
        controller.createStudent("Иван", "Иванович", "Иванов");
        controller.createStudent("Сергей", "Сергевич", "Сергеев");
        controller.createStudent("Петр", "Петрович", "Петров");

        controller.createStudyGroup(controller.getAllTeachers(),controller.getAllStudents());
        System.out.println();
        controller.getStudyGroup();
    }
}
