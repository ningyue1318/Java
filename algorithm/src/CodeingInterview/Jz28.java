package CodeingInterview;

import java.util.HashMap;

/*
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Jz28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.get(array[i])==null) map.put(array[i],0);
            map.put(array[i],map.get(array[i])+1);
        }
        int returnValue=0;
        int num = 0;
        for(Integer i:map.keySet()){
            if(map.get(i)>num){
                num = map.get(i);
                returnValue = i;
            }
        }
        return returnValue;
    }

    public int MoreThanHalfNum_Solution1(int [] array){
        if(array==null||array.length==0) return 0;
        int result = array[0];
        int time = 1;
        for(int i=1;i<array.length;i++){
            if(time==0){
                result = array[i];
                time = 1;
            }else if(result==array[i]){
                time++;
            }else if(result!=array[i]){
                time--;
            }
        }

        time=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==result){
                time++;
            }
        }
        return time*2>array.length?result:0;
    }


    public static void main(String[] args) {
        Jz28 z = new Jz28();
        int [] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(z.MoreThanHalfNum_Solution(array));
    }
}
