package jvm.syn.neu;

import java.nio.ByteBuffer;
import java.util.Scanner;

public class DIrectMemory {

    private static final int BUFFER = 1024*1024*1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完毕，请求指示");

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("直接内存开始释放");
        byteBuffer = null;
        System.gc();
        scanner.next();
    }

}
