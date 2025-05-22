import java.util.List;

public class StreamCount {
    public static void main(String[] args) {
        List<String> names = List.of("Alexandra", "Don", "Alok", "Adam", "Rama");

        // Use streams to count names starting with "A"
        long count = names.stream()
                .filter(s -> s.startsWith("A"))
                .count();

        // Print the result
        System.out.println("Count: " + count);
    }
}
