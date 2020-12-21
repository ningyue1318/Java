package CodeingInterview;

import java.util.HashMap;

/*
    在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
     如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class Jz34 {
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0) return -1;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),i);
            }else{
                map.put(str.charAt(i),-1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i:map.values()){
            if(i!=-1&&i<min){
                min = i;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }

    public static void main(String[] args) {
        Jz34 z = new Jz34();
        System.out.println(z.FirstNotRepeatingChar("google"));
    }
}
