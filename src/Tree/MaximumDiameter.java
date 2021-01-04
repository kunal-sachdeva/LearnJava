package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


//Using 2 times BFS. First on root to depth and then that depth element to maximum diameter.
public class MaximumDiameter {
        class Graph{
            int root;
            ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
            Graph(ArrayList<Integer> A){
                for(int i=0; i<A.size(); i++){
                    adj.add(new ArrayList<Integer>());
                    if(A.get(i)!=-1){
                        adj.get(i).add(A.get(i));
                        adj.get(A.get(i)).add(i);
                    }
                    else root=i;
                }
            }
        }
        public int[] bfs(Graph g, int root){
            int[] ans=new int[]{root,0};
            Queue<int[]> q=new LinkedList<>();
            Boolean[] visit=new Boolean[g.adj.size()];
            Arrays.fill(visit,false);
            q.add(new int[]{root,0});
            while(!q.isEmpty()){
                int[] set=q.poll();
                if(!visit[set[0]]){
                    visit[set[0]]=true;
                    if(set[1]>ans[1]){
                        ans[0]=set[0];
                        ans[1]=set[1];
                    }
                    for(int v: g.adj.get(set[0])){
                        q.add(new int[]{v, (set[1]+1)});
                        //System.out.println(v+" vertex distance: "+ (set[1]+1));
                    }
                }
            }
            return ans;
        }
        public int solve(ArrayList<Integer> A) {
            Graph g=new Graph(A);
            int[] t1=bfs(g,g.root);
            //System.out.println(t1[0]+" root distance: "+t1[1]);
            int[] t2=bfs(g,t1[0]);
            //System.out.println(t1[0]+" to "+t2[0]+" distance: ");
            return t2[1];

        }


}
