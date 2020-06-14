package Observer;

public class ConcreteObserverTwo implements Observer {
    @Override
    public void update() {
        System.out.println("ConcreteObserverTwo is notified");
    }

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverTwo());
        subject.registerObserver(new ConcreteObserverOne());
        subject.notifyObservers();
    }
}
