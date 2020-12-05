package thoughts;

public class Dynamic1 {
    private int minDist = Integer.MAX_VALUE;
    private int [][] mem = new int [4][4];
    private int [][] matrix = {{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
    public void minDistBT(int i,int j,int dist, int [][]w,int n){

        if(i==n-1&&j==n-1){
            dist = dist+w[i][j];
            if(dist<minDist) minDist = dist;
            return;
        }

        if(i<n-1){
            minDistBT(i+1,j,dist+w[i][j],w,n);
        }

        if(j<n-1){
            minDistBT(i,j+1,dist+w[i][j],w,n);
        }
    }

    public int minDistDP(int [][] matrix, int n){
        int [][] states = new int[n][n];
        int sum =0;
        for(int j=0;j<n;j++){
            sum+=matrix[0][j];
            states[0][j]=sum;
        }

        sum =0;
        for(int i=0;i<n;i++){
            sum+=matrix[i][0];
            states[i][0]=sum;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                states[i][j] = matrix[i][j]+Math.min(states[i-1][j],states[i][j-1]);
            }
        }
        return states[n-1][n-1];
    }

    public int minDist(int i,int j){
        if(i==0&&j==0) return matrix[0][0];
        if(mem[i][j]>0) return mem[i][j];
        int minLeft = Integer.MAX_VALUE;
        if(j-1>=0){
            minLeft = minDist(i,j-1);
        }
        int minUp = Integer.MAX_VALUE;
        if(i-1>=0){
            minUp = minDist(i-1,j);
        }

        int currMinDist = matrix[i][j] + Math.min(minLeft,minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

    public static void main(String[] args) {
        int [][] w={{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
        Dynamic1 d = new Dynamic1();
        d.minDistBT(0,0,0,w,4);
        System.out.println(d.minDist);
        System.out.println(d.minDistDP(w,4));
        System.out.println(d.minDist(3,3));
    }
}
