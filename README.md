# University Registry System

This Java program reads student records from `students.txt`, stores them as `Student` objects, displays all students, and groups the student names by major.

## Classes

- `Student`: keeps the id, name, GPA and major of one student.
- `RegistryManager`: reads the file, stores the students in a list, displays them and groups them by major.
- `Main`: runs the program.

## How to run

Keep `students.txt` in the same folder as the `.java` files, then run:

```
javac Student.java RegistryManager.java Main.java
java Main
```