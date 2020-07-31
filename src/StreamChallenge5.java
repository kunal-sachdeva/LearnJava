import java.util.*;
import java.lang.System;

class StreamChallenge5 {
        public static List<Integer> getRow(int rowIndex) {
            List<Integer> res = new ArrayList<>();
            int[][]mem = new int[rowIndex+1][rowIndex];
            for(int i=0; i<=rowIndex; i++) {
                Arrays.fill(mem[i], -1);
            }
            for(int i=0; i<rowIndex; i++){
                res.add((Integer) getPascal(i,rowIndex,mem));
            }
            return res;
        }
    public static int getPascal(int ele, int rowIndex, int[][]mem) {
            if(rowIndex>=0 && ele>=0 && mem[rowIndex][ele]!=-1)
                return mem[rowIndex][ele];
            int ans;
            if(rowIndex==1){
                if(ele==0)
                    ans=1;
                else
                    return 0;
            } else if(rowIndex==2){
                if(ele==0)
                    ans=1;
                else if(ele==1)
                    ans=1;
                else
                    return 0;
            } else {
                return getPascal(ele - 1, rowIndex - 1, mem) + getPascal(ele, rowIndex - 1, mem);
            }
            mem[rowIndex][ele]=ans;
            return ans;
    }
    public static void main(String...args){
            System.out.println(System.currentTimeMillis());
            System.out.println(getRow(20));
            System.out.println(System.currentTimeMillis());
    }

}