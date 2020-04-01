package WorkerThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    private final JLabel label = new JLabel("Event Dispatching Thread Sample");
    private final JButton button = new JButton("countUp");
    public MyFrame(){
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label);
        getContentPane().add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==button){
            countUp();
        }
    }

    private void countUp(){
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":countUp:setText("+i+")");
            label.setText(""+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}
public class Test02 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+":BEGIN");
        new MyFrame();
        System.out.println(Thread.currentThread().getName()+":END");
    }
}
