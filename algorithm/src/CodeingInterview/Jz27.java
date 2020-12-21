package CodeingInterview;

import java.util.*;
import java.util.stream.Collectors;

/*
    输入一个字符串,按字典序打印出该字符串中字符的所有排列。
    例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Jz27 {
    public ArrayList<String> Permutation(String str) {
        if(str==null||str.length()==0) return null;
        ArrayList<String> returnData = new ArrayList<>();
        char [] data = str.toCharArray();
        Permutation_sub(data,0,returnData);
        HashSet<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        for(String s:returnData){
            if(!set.contains(s)) {
                result.add(s);
                set.add(s);
            }
        }
        Collections.sort(result);
        return result;
    }

    public void Permutation_sub(char[] str,int start,ArrayList<String> returnData){
        if(start==str.length){
            returnData.add(new String(str));
            return;
        }
        for(int i=start;i<str.length;i++){
            char temp = str[start];
            str[start] = str[i];
            str[i] = temp;
            Permutation_sub(str,start+1,returnData);
            temp = str[start];
            str[start] = str[i];
            str[i] = temp;
        }

    }


    public static void main(String[] args) {
        String s = "abc";
        Jz27 z = new Jz27();
        System.out.println(z.Permutation(s));
    }

}
