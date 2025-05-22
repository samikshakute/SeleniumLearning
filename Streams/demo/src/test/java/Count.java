import java.util.List;

public class Count {
    public static void main(String[] args) {
        List<String> names = List.of("Alexandra", "Don", "Alok", "Adam", "Rama");
        int count = 0;
        for (String name : names) {
            if (name.startsWith("A")) {
                count++;
            }
        }
        System.out.println("Count: " + count);
    }
}