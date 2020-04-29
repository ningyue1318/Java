package HashTable;

import java.util.HashMap;
import java.util.Map;

public class HashTable<K, V>{
    private static final int DEFAuLT_INITAL_CAPACITY = 8;

    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K,V>[] table;

    private int size = 0;

    private int use =0;

    public HashTable(){
        table = (Entry<K,V> [])new Entry[DEFAuLT_INITAL_CAPACITY];
    }

    static class Entry<K,V>{
        K key;

        V value;

        Entry<K,V> next;

        Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value){
        int index = hash(key);

        if(table[index] == null){
            table[index] = new Entry<>(null,null,null);
        }

        Entry<K,V> tmp = table[index];

        if(tmp.next == null){
            tmp.next = new Entry<>(key,value,null);
            size++;
            use++;

            if(use>=table.length*LOAD_FACTOR){
                resize();
            }
        }else{
            do{
                tmp = tmp.next;
                if(tmp.key == key){
                    tmp.value = value;
                    return;
                }
            }while(tmp.next!=null);

            Entry<K,V> temp = table[index].next;
            table[index].next = new Entry<>(key,value,temp);
            size++;
        }
    }

    /*
     * 散列函数
     */
    private int hash(Object key){
        int h;
        return (key == null)?0:((h = key.hashCode())^(h>>>16))%table.length;
    }

    /*
     * 扩容
     */
    private void resize(){
        Entry<K,V>[] oldTable = table;
        table = (Entry<K,V>[])new Entry[table.length*2];
        use = 0;
        for(int i=0;i<oldTable.length;i++){
            if(oldTable[i]==null||oldTable[i].next==null){
                continue;
            }
            Entry<K,V> e = oldTable[i];
            while(e.next!=null){
                e = e.next;
                int index = hash(e.key);
                if(table[index]==null){
                    use++;
                    table[index] = new Entry<K, V>(null,null,null);
                }
                table[index].next = new Entry<K, V>(e.key,e.value,table[index]);
            }
        }
    }

    public V get(K key){
        int index = hash(key);
        Entry<K,V> e = table[index];
        if(e==null || e.next==null){
            return null;
        }
        while(e.next!=null){
            e = e.next;
            if(key == e.key){
                return e.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int index = hash(key);

        Entry e = table[index];
        if(e == null|| e.next ==null){
            return ;
        }

        Entry pre;
        Entry<K,V> headNode = table[index];
        do{
            pre = e;
            e = e.next;
            if(key == e.key){
                pre.next = e.next;
                size--;
                if(headNode.next == null )use--;
                return;
            }
        }while(e.next!=null);
    }
}
