import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistryManager {
    private List<Student> students = new ArrayList<>();

    // Method 1: read the file line by line and fill the list
    public void loadStudentsFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split(",");

                // only use lines that have 4 parts: id, name, gpa, major
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double gpa = Double.parseDouble(parts[2].trim());
                    String major = parts[3].trim();

                    students.add(new Student(id, name, gpa, major));
                }

                line = reader.readLine(); // go to the next line
            }

            reader.close();
            System.out.println(students.size() + " students loaded from the file.");
        } catch (IOException e) {
            System.out.println("Could not read the file: " + e.getMessage());
        }
    }

    // Method 2: print every student
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Method 3: group the students' names by major
    public void groupStudentsByMajor() {
        Map<String, List<String>> groups = new HashMap<>();

        for (Student s : students) {
            String major = s.getMajor();
            if (!groups.containsKey(major)) {
                groups.put(major, new ArrayList<>());
            }
            groups.get(major).add(s.getName());
        }

        for (String major : groups.keySet()) {
            System.out.println(major + ": " + groups.get(major));
        }
    }
}