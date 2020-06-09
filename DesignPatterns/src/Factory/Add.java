package Factory;

public class Add implements Operation {
    @Override
    public int getResult(int numA, int numB) {
        return numA+numB;
    }
}
