package Array;

import javafx.beans.binding.ObjectBinding;

public class MyArray<T>{
    private T[] data;
    private int size;

    public MyArray(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    public MyArray(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

    public int count(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //修改制定位置元素
    public void set(int index,T e){
        checkIndex(index);
        data[index] = e;
    }

    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(T e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    private void resize(int capacity){
        T[] newData = (T[]) new Object[capacity];
        for(int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data=newData;
    }

    private void checkIndex(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Add failed! Require index>=0 and index<size");
        }
    }

    private void checkIndexForAdd(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("remove failed!Require index>=0 and index<=size");
        }
    }


}
