package CodeingInterview;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/*
    小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
    但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
    没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
    现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Jz41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if(sum<=0) return null;

        ArrayList<ArrayList<Integer>> returnData = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 2;i<sum;i++){
            int a1 = (sum-i*(i-1)/2)/i;
            if(a1>=1){
                ArrayList<Integer> result = new ArrayList<>();
                int resultSum =0;
                for(int j=0;j<i;j++){
                    result.add(a1+j);
                    resultSum+= a1+j;
                }
                if(resultSum==sum) {
                    map.put(a1, result);
                }
            }
        }

        for(int i=0;i<sum/2+1;i++){
            if(map.containsKey(i)){
                returnData.add(map.get(i));
            }
        }
        return returnData;
    }


    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        if(sum<=0) return null;
        ArrayList<ArrayList<Integer>> returnData = new ArrayList<ArrayList<Integer>>();

        int tmp = 0;
        for(int i=1;i<sum/2;i++){
            for(int j=i;j<sum;j++){
                tmp += j;
                if(tmp==sum){
                    ArrayList<Integer> result = new ArrayList<>();
                    for(int k =i;k<=j;k++){
                        result.add(k);
                    }
                    returnData.add(result);
                }
                if(tmp>sum){
                    tmp = 0;
                    break;
                }
            }
        }
        return returnData;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        if(sum<=0) return null;
        ArrayList<ArrayList<Integer>> returnData = new ArrayList<ArrayList<Integer>>();

        int l =1,r=1;
        int tmp =0;
        while(l<=sum/2){
            if(tmp<sum){
                tmp+=r;
                r++;
            }
            if(tmp>sum){
                tmp-=l;
                l++;
            }else{
                ArrayList<Integer> result = new ArrayList<>();
                for(int k =l;k<r;k++){
                    result.add(k);
                }
                returnData.add(result);
                tmp-=l;
                l++;
            }
        }
        return  returnData;
    }

}
