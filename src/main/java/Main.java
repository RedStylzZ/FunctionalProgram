import model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static int[] zahlen = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5};

    public static void main(String[] args) {
        int sum = Arrays.stream(zahlen).sum();
        int product = Arrays.stream(zahlen).reduce(1,(a, b) -> a*b);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);

        List<String> students = openFile();
        List<String> studentsList;
        List<Student> studentList = new ArrayList<>();

        if (students != null) {
             studentsList = students.stream()
                     .skip(1)
                     .filter(s -> !s.isBlank())
                     .distinct()
                     .toList();

            studentsList.forEach(s -> {
                String[] t = s.split(",");
                studentList.add(new Student(Integer.parseInt(t[0]), t[1], Integer.parseInt(t[2]), Integer.parseInt(t[3])));
            });
        }

        studentList.forEach(System.out::println);
    }

    public static List<String> openFile() {
        try {
            return Files.lines(Path.of("src/main/resources/students.csv")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
