class Singleton {
    private static Singleton instance;

    private Singleton() { // Private constructor
        // Constructor logic, if any.
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance");
    }
}

public class Question4 {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        s.showMessage();
    }
}