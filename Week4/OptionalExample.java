import java.util.Optional;

public class OptionalExample {

    // Method that returns an Optional value
    public static void checkValue(Optional<String> optionalValue) {
        if (optionalValue.isPresent()) {
            System.out.println("Value is present: " + optionalValue.get());
        } else {
            System.out.println("Value is absent");
        }
    }

    public static void main(String[] args) {

        // Creating an Optional
        Optional<String> optionalValue = Optional.of("Hello!");
        // Checking if value is present
        checkValue(optionalValue);

        Optional<String> optionalValue2 = Optional.ofNullable(null);
        // Checking if value is present
        checkValue(optionalValue2);

        // Using orElse to provide a default value
        String value = optionalValue2.orElse("Default Value");
        System.out.println("Value was null. " + value);

        // Using ifPresent to execute code if value is present
        optionalValue.ifPresent(v -> System.out.println("Value using ifPresent: " + v));

        // Using map to transform the value if present
        Optional<Integer> length = optionalValue.map(String::length);
        System.out.println("Length of value: " + length.orElse(0));

        Optional<Integer> length2 = optionalValue2.map(String::length);
        System.out.println("Length of value: " + length2.orElse(0));
    }
}
