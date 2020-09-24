package Collection.syn.neu;

public class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I believe I can";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
