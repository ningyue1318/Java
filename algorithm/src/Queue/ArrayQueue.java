package Queue;

public class ArrayQueue{
    private String [] items;
    private int n=0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item){
        if(n==tail){
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue(){
        if(head==tail){
            return null;
        }
        return items[head++];
    }

    public void printAll(){
        for(int i=head;i<tail;i++){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        System.out.println(queue.dequeue());
        System.out.println(queue.head+" "+queue.tail);
        queue.printAll();
    }
}
