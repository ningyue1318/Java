package Factory;

import java.util.Scanner;

public class TestOperationFactory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入第一个数字：");
        int numA = input.nextInt();
        System.out.println("请输入运算符,+或者-：");
        String operator = input.next();
        System.out.println("请输入第二个数字：");
        int numB = input.nextInt();
        Operation operation = OperationFactory.createOperation(operator);
        System.out.println(operation.getResult(numA,numB));
    }
}
