package Graph;

import java.util.ArrayList;

public class PimsMST {
    public int minKey(int[] key, Boolean[] mstSet){
        int min_index=-1;
        int minVal= Integer.MAX_VALUE;
        for(int i=0; i<key.length; i++) {
            if(key[i]<minVal && !mstSet[i]){
                min_index=i;
                minVal=key[i];
            }
        }
        return min_index;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[][] graph=new int[A][A];
        for(int i=0; i<B.size(); i++){
            graph[B.get(i).get(0)-1][B.get(i).get(1)-1]=B.get(i).get(2);
            graph[B.get(i).get(1)-1][B.get(i).get(0)-1]=B.get(i).get(2);
        }
        Boolean[] mstSet=new Boolean[A];
        int[] key=new int[A];
        int[] parent = new int[A];
        int maxVal= Integer.MAX_VALUE;
        for(int k=0; k<A; k++){
            key[k]=maxVal;
            mstSet[k]=false;
        }
        key[0]=0;
        for(int i=0; i<A; i++){
            int u=minKey(key, mstSet);
            //System.out.println("u: "+u);
            mstSet[u]=true;
            //System.out.println("mstSet: "+mstSet);
            for(int v=0; v<A; v++){
                if(graph[u][v]!=0 && mstSet[v]!=true && graph[u][v] < key[v]){
                    key[v]=graph[u][v];
                    parent[v]=u;
                }
            }
        }
        int ans=0;
        for(int j=0; j<A; j++){
            //System.out.println(parent[j] + " - " + j + "\t" + graph[j][parent[j]] +"\t"+key[j]);
            ans=ans+graph[j][parent[j]];
        }
        return ans;
    }
}
