import java.io.File;

public class Main {
    public static void main(String[] args) {
        RegistryManager manager = new RegistryManager();

        // the file students.txt is in the project folder
        File file = new File("students.txt");
        manager.loadStudentsFromFile(file.getAbsolutePath());

        System.out.println();
        System.out.println("===== ALL STUDENTS =====");
        manager.displayAllStudents();

        System.out.println();
        System.out.println("===== STUDENTS GROUPED BY MAJOR =====");
        manager.groupStudentsByMajor();
    }
}