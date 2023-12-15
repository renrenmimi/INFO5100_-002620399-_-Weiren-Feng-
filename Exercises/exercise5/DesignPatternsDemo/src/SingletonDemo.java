package Exercises.exercise5.DesignPatternsDemo.src;

public class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo() {}

    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}
