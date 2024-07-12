import java.util.Arrays;
import java.util.List;

public class MethodRefExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Wick", "Bryce");

        // lambda expression
        System.out.println("Printing names using Lambda Expression:");
        names.forEach(name -> System.out.println(name));

        // method reference
        System.out.println("\nPrinting names using Method Reference:");
        names.forEach(System.out::println);
    }
}
