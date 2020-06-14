package Observer;

public class ConcreteObserverOne implements Observer{
    @Override
    public void update() {
        System.out.println("ConcreteObserverOne is notified");
    }
}
