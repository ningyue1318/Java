package CodeingInterview;

import java.util.ArrayList;

public class Jz65 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        if(num==null||num.length==0) return new ArrayList();
        int start = 0;
        int end = size-1;
        int currentIndex = 0;
        int maxValue = 0;

        ArrayList<Integer> result = new ArrayList();
        for(int i=start;i<=end;i++){
            if(maxValue<num[i]){
                maxValue = num[i];
                currentIndex = i;
            }
        }

        result.add(maxValue);

        start++;
        end++;
        for(;end<num.length;end++){
            if(num[currentIndex]<num[end]){
                currentIndex = end;
                maxValue = num[currentIndex];
            }else{
                if(currentIndex<start){

                    for(int i=start;i<=end;i++){
                        if(maxValue<num[i]){
                            maxValue = num[i];
                            currentIndex = i;
                        }
                    }
                }
            }
            result.add(maxValue);
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        Jz65 z = new Jz65();
        System.out.println(z.maxInWindows(new int[]{2,3,4,2,6,2,5,1},3));
    }
}
