package CodeingInterview;

public class Jz33 {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0) return 0;
        int [] result = new int[index];
        result[0] = 1;
        int p2=0,p3=0,p5=0;
        for(int i=1;i<index;i++){
            result[i] = Math.min(result[p2]*2,Math.min(result[p3]*3,result[p5]*5));
            if(result[i]==result[p2]*2) p2++;
            if(result[i]==result[p3]*3) p3++;
            if(result[i]==result[p5]*5) p5++;
        }

        return result[index-1];
    }


    public static void main(String[] args) {
        Jz33 z = new Jz33();
        System.out.println(z.GetUglyNumber_Solution(7));
    }
}
