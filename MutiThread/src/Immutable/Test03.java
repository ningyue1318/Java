package Immutable;

class Something{
    private int x = 0;
    private boolean valid = false;

    public void write(){
        valid=true;
        x=123;
    }

    public void read(){
        if(valid){
            System.out.println(x);
        }
    }
}

public class Test03 {
    public static void main(String[] args) throws InterruptedException {
      final Something obj = new Something();

      new Thread(()->{
          obj.write();
      }).start();

      new Thread(()->{
          obj.read();
      }).start();
    }
}
