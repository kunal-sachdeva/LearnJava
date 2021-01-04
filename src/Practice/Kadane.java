package Practice;

public class Kadane {
    // Function to find contiguous sub-array with the largest sum
    // in given set of integers (handles negative numbers as well)
    public static int maxArraySum(int[] A){
        int maxSofar = Integer.MIN_VALUE;
        int maxEnding=0;
        for(int i: A){
            maxEnding=maxEnding+i;
            maxEnding=Math.max(maxEnding,i);
            maxSofar=Math.max(maxEnding,maxSofar);
        }
        return maxSofar;
    }
    public static void main(String[] args){
        int[] A=new int[]{ -2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(maxArraySum(A));
    }
}
