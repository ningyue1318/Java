package CodeingInterview;

import java.util.HashMap;

/*
    一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Jz40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],2);
            }
        }

        int a = -1;
        int b = -1;
        for(int i :map.keySet()){
            if(map.get(i)!=2){
                if(a==-1){
                    a = i;
                }else{
                    b = i;
                    break;
                }
            }
        }

        num1[0] = a;
        num2[0] = b;
    }

    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int xor1 = 0;
        for(int i=0;i<array.length;i++){
            xor1^=array[i];
        }
        System.out.println(xor1);
        int index =1;
        while((index&xor1)==0){
            index = index<<1;
        }

        for(int i=0;i<array.length;i++){
            if((index&array[i])==0){
                num1[0] = num1[0]^array[i];
            }else{
                num2[0] = num2[0]^array[i];
            }
        }
    }
    public static void main(String[] args) {
        Jz40 z = new Jz40();
        z.FindNumsAppearOnce1(new int[]{2,4,3,6,3,2,5,5},new int[]{0},new int[]{0});

    }
}
