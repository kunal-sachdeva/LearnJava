package Practice;

public class CoinChange {
    public static int totalChange(int[] A, int n, int N){
        int ans=0;
        if(N<0 || n<=0)
            return 0;
        if(N==0)
            return 1;
        return totalChange(A,n, N-A[n-1])+totalChange(A,n-1, N);
    }

    public static void main(String[] args){
        int[] A=new int[]{1,3,5,7};
        int N=8;
        System.out.println(totalChange(A, 4 , N));
    }
}
