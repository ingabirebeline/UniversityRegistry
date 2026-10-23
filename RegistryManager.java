import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistryManager {
    private List<Student> students = new ArrayList<>();

    // READ the students from the file
    public void loadStudents(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double gpa = Double.parseDouble(parts[2].trim());
                    String major = parts[3].trim();

                    students.add(new Student(id, name, gpa, major));
                }
            }

            reader.close();
            System.out.println(students.size() + " students loaded from the file.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Show all students on the screen
    public void printAllStudents() {
        System.out.println("\n===== ALL STUDENTS =====");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Group the student names by major
    public Map<String, List<String>> groupByMajor() {
        Map<String, List<String>> groups = new HashMap<>();

        for (Student s : students) {
            if (!groups.containsKey(s.getMajor())) {
                groups.put(s.getMajor(), new ArrayList<>());
            }
            groups.get(s.getMajor()).add(s.getName());
        }

        return groups;
    }

    // Show the groups on the screen
    public void printGroupedByMajor() {
        System.out.println("\n===== STUDENTS GROUPED BY MAJOR =====");
        Map<String, List<String>> groups = groupByMajor();

        for (String major : groups.keySet()) {
            System.out.println(major + ": " + groups.get(major));
        }
    }

    // WRITE the report into a new file
    public void saveReport(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write("===== ALL STUDENTS =====\n");
            for (Student s : students) {
                writer.write(s + "\n");
            }

            writer.write("\n===== STUDENTS GROUPED BY MAJOR =====\n");
            Map<String, List<String>> groups = groupByMajor();
            for (String major : groups.keySet()) {
                writer.write(major + ": " + groups.get(major) + "\n");
            }

            writer.close();
            System.out.println("\nReport saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}