package Basis.thoughts;

public class Dynamic2 {
    private char [] a = "mitcmu".toCharArray();
    private char [] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    private int minDist = Integer.MAX_VALUE;

    public void lwstBT(int i,int j, int edist){
        if(i==n||j==m){
            if(i<n) edist += (n-i);
            if(j<m) edist += (m-j);
            if(edist<minDist) minDist = edist;
            return;
        }

        if(a[i]==b[i]){
            lwstBT(i+1,j+1,edist);
        }else{
            lwstBT(i+1,j,edist+1);
            lwstBT(i,j+1,edist+1);
            lwstBT(i+1,j+1,edist+1);
        }
    }

    public int lwstDP(char [] a, int n,char [] b, int m){
        int [][] minDist = new int [n][m];
        for(int j=0;j<m;j++){
            if(a[0]==b[j]) minDist[0][j]=j;
            else if(j!=0) minDist[0][j] = minDist[0][j-1]+1;
            else minDist[0][j] = 1;
        }

        for(int i=0;i<n;i++){
            if(a[i]==b[0]) minDist[i][0] = i;
            else if(i!=0) minDist[i][0] = minDist[i-1][0]+1;
            else minDist[i][0] =1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(a[i]==b[j])
                    minDist[i][j] = min(minDist[i-1][j]+1,minDist[i][j-1]+1,minDist[i-1][j-1]);
                else
                    minDist[i][j] = min(minDist[i-1][j]+1,minDist[i][j-1]+1,minDist[i-1][j-1]+1);
            }
        }
        return minDist[n-1][n-1];
    }

    private int min(int x,int y, int z){
        int minv = Integer.MAX_VALUE;
        if(x<minv) minv = x;
        if(y<minv) minv = y;
        if(z<minv) minv = z;
        return minv;
    }

    public static void main(String[] args) {
        Dynamic2 d = new Dynamic2();
        d.lwstBT(0,0,0);
        System.out.println(d.lwstDP(d.a,d.n,d.b,d.m));
    }
}
