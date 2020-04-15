package Array;

public class Array {
    //定义整型数组保存数据
    public int data [];
    //数组长度
    private int data_length;
    //数组内实际存储个数
    private int num;

    //构造方法定义数组大小
    public Array(int data_length){
        this.data_length = data_length;
        this.num =0;
        this.data = new int[data_length];
    }

    //根据索引找到数组中的元素
    public int find(int index){
        if(index<0||index>=num)return -1;
        return this.data[index];
    }

    //插入元素
    public boolean insert(int index,int value){
        if(num==data_length){
            System.out.println("数组元素已满");
            return false;
        }

        if(index<0||index>=data_length){
            System.out.println("插入位置不合理");
            return false;
        }

        for(int i=num;i>index;i--){
            this.data[i]=this.data[i-1];
        }
        this.data[index]=value;
        this.num++;
        return true;
    }

    //根据索引，删除数组中的元素
    public boolean delete(int index){
        if(num==0){
            System.out.println("数组元素已空");
            return false;
        }

        if(index<0||index>=num){
            System.out.println("删除位置不合理");
            return false;
        }
        for(int i=index;i<num;i++){
            this.data[i]=this.data[i+1];
        }
        this.num--;
        return true;
    }

    public void printAll(){
        for(int i=0;i<num;i++){
            System.out.print(this.data[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array data = new Array(5);
        data.insert(0,3);
        data.printAll();
        data.insert(0,4);
        data.printAll();
        data.insert(1,5);
        data.printAll();
        System.out.println(data.find(1));
        data.delete(1);
        data.printAll();
    }
}
