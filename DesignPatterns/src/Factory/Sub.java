package Factory;

public class Sub implements Operation{

    @Override
    public int getResult(int numA, int numB) {
        return numA-numB;
    }
}
