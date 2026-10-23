public class Main {
    public static void main(String[] args) {
        RegistryManager manager = new RegistryManager();

        manager.loadStudents("students.txt");   // reads the file
        manager.printAllStudents();
        manager.printGroupedByMajor();
        manager.saveReport("report.txt");       // writes the file
    }
}