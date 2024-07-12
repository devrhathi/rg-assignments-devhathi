import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Wick", "Bryce", "Duncan");

        System.out.println("[BEFORE MAP]");
        System.out.println("names: " + names);

        // Convert each element to uppercase using map
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("[AFTER MAP]");
        System.out.println("names: " + uppercaseNames);
    }
}
