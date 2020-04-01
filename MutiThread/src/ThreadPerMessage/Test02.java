package ThreadPerMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener{
    public MyFrame(){
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Thread-Per-Message Sample"));
        JButton button = new JButton("Execute");
        getContentPane().add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Service.service();
    }
}

class Service{
    private static volatile boolean working = false;

    public static synchronized void service(){
        System.out.println("service");
        if(working){
            System.out.println(" is balked");
            return;
        }
        working = true;
        new Thread(){
            public void run(){
                doService();
            }
        }.start();
    }

    public static  void doService(){
        for(int i=0;i<50;i++){
            System.out.print(".");
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }
        System.out.println("done.");
    }

}
public class Test02 {
    public static void main(String[] args) {
        new MyFrame();
    }
}
