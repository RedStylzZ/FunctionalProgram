import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    static int[] zahlen = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5};
    public static void main(String[] args) {
        int sum = Arrays.stream(zahlen).sum();
        int product = Arrays.stream(zahlen).reduce(1,(a, b) -> a*b);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);

        String students = openFile();

    }

    public static String openFile() {
        try {
            return Files.lines(Path.of("src/main/resources/students.csv")).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
