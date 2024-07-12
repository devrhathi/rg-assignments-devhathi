import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.BinaryOperator;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Predicate example: checks if a number is greater than 10
        Predicate<Integer> isGreaterThanTen = num -> num > 10;
        System.out.println("Is 15 greater than 10? " + isGreaterThanTen.test(15));

        // Function example: converts a string to its length
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));

        // Consumer example: prints a string
        Consumer<String> printString = str -> System.out.println(str);
        printString.accept("Hello World!");

        // Supplier example: supplies a string
        Supplier<String> stringSupplier = () -> "Hello from Supplier!";
        System.out.println(stringSupplier.get());

        // BinaryOperator example: adds two integers
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Sum of 5 and 3: " + add.apply(5, 3));
    }
}
