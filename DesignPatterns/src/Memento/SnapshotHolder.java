package Memento;

import java.util.Scanner;
import java.util.Stack;

public class SnapshotHolder {
    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapHot(){
        return snapshots.pop();
    }

    public void pushSnapshot(Snapshot snapshot){
       snapshots.push(snapshot);
    }

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String input = scanner.next();
            if(input.equals("list")){
                System.out.println(inputText.getText());
            }else if(input.equals("undo")){
                Snapshot snapshot = snapshotHolder.popSnapHot();
                inputText.restoreSnapshot(snapshot);
            }else{
                snapshotHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
