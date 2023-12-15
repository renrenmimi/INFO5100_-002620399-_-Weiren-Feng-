package Exercises.exercise5.DesignPatternsDemo.src;

public class Main {
    public static void main(String[] args) {
        // Singleton Demo
        SingletonDemo singleton = SingletonDemo.getInstance();
        singleton.showMessage();

        // Observer Demo
        Subject subject = new Subject();
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        subject.attach(observer1);
        subject.attach(observer2);
        subject.setMessage("New Event Occurred!");

        // Factory Demo
        Product productA = ProductFactory.getProduct("A");
        productA.use();
        Product productB = ProductFactory.getProduct("B");
        productB.use();
    }
}

