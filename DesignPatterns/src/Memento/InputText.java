package Memento;

import jdk.internal.util.xml.impl.Input;

import java.net.InetAddress;

public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText(){
        return text.toString();
    }

    public void append(String input){
        text.append(input);
    }

    public Snapshot createSnapshot(){
        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot){
        this.text.replace(0,this.text.length(),snapshot.getText());
    }


}
