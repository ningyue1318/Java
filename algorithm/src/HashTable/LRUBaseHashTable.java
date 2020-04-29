package HashTable;


import java.util.HashMap;

public class LRUBaseHashTable<K, V> {
    private final static Integer DEFAULT_CAPACITY = 10;

    private DNode<K,V> headNode;

    private DNode<K,V> tailNode;

    private Integer length;

    private Integer capacity;

    private HashMap<K,DNode<K,V>> table;

    static class DNode<K,V>{
        private K key;

        private V value;

        private DNode<K,V> prev;

        private DNode<K,V> next;

        DNode(){
        }

        DNode(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUBaseHashTable(int capacity){
        this.length = 0;
        this.capacity = capacity;
        headNode = new DNode<K, V>();
        tailNode = new DNode<K, V>();

        headNode.next = tailNode;
        tailNode.prev = headNode;

        table = new HashMap<>();
    }

    public LRUBaseHashTable(){
        this(DEFAULT_CAPACITY);
    }

    public void add(K key,V value){
        DNode<K,V> node = table.get(key);
        if(node == null){
            DNode<K,V> newNode = new DNode<K, V>(key,value);
            table.put(key,newNode);
            addNode(newNode);

            if(length++>capacity){
                DNode<K,V> tail = popTail();
                table.remove(tail.key);
                length--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    /*
     * 新节点加入到头部
     */
    private void addNode(DNode<K,V> newNode){
        newNode.next = headNode.next;
        newNode.prev = headNode;

        headNode.next.prev = newNode;
        headNode.next = newNode;
    }

    private DNode<K,V> popTail(){
        DNode<K,V> node = tailNode.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(DNode<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DNode<K,V> node){
        removeNode(node);
        addNode(node);
    }

    public V get(K key){
        DNode<K,V> node = table.get(key);
        if(node == null){
            return null;
        }
        moveToHead(node);
        return  node.value;
    }

    public void remove(K key){
        DNode<K,V> node = table.get(key);
        if(node == null){
            return ;
        }
        removeNode(node);
        length--;
        table.remove(node.key);
    }

    private void printAll() {
        DNode<K, V> node = headNode.next;
        while (node.next != null) {
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }

}
