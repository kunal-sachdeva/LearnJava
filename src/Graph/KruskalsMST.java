package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalsMST {

        public class UF {
            int N;
            int[] parent;

            UF(int n) {
                this.N = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }

            }

            public boolean Find(int i,int j){
                if(parent[i]==parent[j]) return true;
                else return false;
            }

            public void Union(int i,int j){
                if(Find(i,j))
                    return;
                int changeThis = parent[i];
                for(int v=0;v<N;v++){
                    if(parent[v]==changeThis )
                        parent[v] = parent[j];
                }
            }

        }

        public class Edge implements Comparable<Edge>{
            int s;
            int e;
            int w;

            Edge(int u,int v,int w){
                this.s = u;
                this.e = v;
                this.w = w;
            }

            public int compareTo(Edge that){
                return this.w-that.w;
            }

            public String toString(){
                return ""+s+" to "+e+" weight "+w;
            }

        }
        public int solve(int A, ArrayList<ArrayList<Integer>> B) {

            UF u = new UF(A);
            ArrayList<Edge> eList = new ArrayList<Edge>();
            for(int i=0;i<B.size();i++ )
                eList.add( new Edge (B.get(i).get(0)-1 , B.get(i).get(1)-1,0+B.get(i).get(2) ) );
            Collections.sort(eList);
            // System.out.println(eList);
            int ans=0;
            for(int i=0;i<eList.size();i++){
                if( !u.Find(eList.get(i).s ,eList.get(i).e  ) ){
                    u.Union(eList.get(i).s ,eList.get(i).e );
                    ans+=eList.get(i).w;
                }
            }

            return ans;

        }

}
