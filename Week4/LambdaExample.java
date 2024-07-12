@FunctionalInterface
interface Addable {
    int add(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {

        // Without Lambda
        Addable addable = new Addable() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        int result = addable.add(5, 3);
        System.out.println("Result without lambda: " + result);

        // With Lambda
        Addable addable2 = (a, b) -> a + b;
        int result2 = addable2.add(5, 3);
        System.out.println("Result with lambda: " + result2);
    }
}
