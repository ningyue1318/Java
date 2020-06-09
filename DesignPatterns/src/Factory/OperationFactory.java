package Factory;

public class OperationFactory {
    public static Operation createOperation(String operation){
        Operation operate = null;
        switch (operation){
            case "+":
                operate = new Add();
                break;
                case "-":
                    operate = new Sub();
                    break;
        }
        return operate;
    }

}

/*
    工厂的第二种写法：
    public class OperationFactory {
    private static final HashMap<String,Operation> map = new HashMap<>();
    static {
        map.put("+",new Add());
        map.put("-",new Sub());
    }

    public static Operation createOperation(String operation){
        return map.get(operation);
    }

}
 */