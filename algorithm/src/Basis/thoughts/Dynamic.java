package thoughts;

public class Dynamic {
    private int maxW = Integer.MIN_VALUE;
    private int [] weight = {2,2,4,6,3};
    private int n = 5;
    private int w = 9;
    public void f(int i,int cw){
        if(cw==w||i==n){
            if(cw>w) maxW=cw;
            return;
        }
        f(i+1,cw);
        if(cw+weight[i]<=w){
            f(i+1,cw+weight[i]);
        }
    }

    public int knapsack(int [] weight, int n,int w){
        boolean [][] states = new boolean[n][w+1];
        states[0][0] = true;
        if(weight[0]<=w){
            states[0][weight[0]] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=w;j++){
                if(states[i-1][j]==true) states[i][j]=states[i-1][j];
            }
            for(int j=0;j<=w-weight[i];j++){
                if(states[i-1][j]==true) states[i][j+weight[i]] =true;
            }
        }

        for(int i=w;i>=0;i--){
            if(states[n-1][i]==true) return i;
        }
        return 0;
    }

    public static int knapsack3(int [] weight,int [] value,int n,int w){
        int [][] states = new int [n][w+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<w+1;j++){
                states[i][j]=-1;
            }
        }

        states[0][0] = 0;
        if(weight[0]<=w){
            states[0][weight[0]] =value[0];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=w;j++){
                if(states[i-1][j]>=0) states[i][j] = states[i-1][j];
            }

            for(int j=0;j<=w-weight[i];j++){
                if(states[i-1][j]>=0){
                    int v = states[i-1][j]+value[i];
                    if(v>states[i][j+weight[i]]){
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        int maxValue =-1;
        for(int j=0;j<=w;j++){
            if(states[n-1][j]>maxValue) maxValue =states[n-1][j];
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Dynamic d = new Dynamic();
        d.f(0,0);
        System.out.println(d.knapsack3(new int[]{2,2,4,6,3},new int[]{3,4,8,9,6},5,9));
    }
}
