package Graph;

import java.util.*;

public class UndirectedGraph<T> {
    private Map<T,ArrayList<T>> adj;
    public UndirectedGraph(Map<T, ArrayList<T>> adj){
        this.adj=adj;
    }
    public void addEdge(T u, T v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void addVertex(T vertex){
        adj.putIfAbsent(vertex, new ArrayList<T>());
    }
    public List<T> getAdjVertices(T vertex){
        return adj.get(vertex);
    }
    public Set<T> depthFirstTraversal(T root){
        Stack<T> stack=new Stack<>();
        Set<T> visited=new HashSet<>();
        stack.push(root);
        while(!stack.empty()){
            T temp=stack.pop();
            if(!visited.contains(temp)){
                System.out.println("visiting :"+temp.toString());
                visited.add(temp);
                for(T node: getAdjVertices(temp))
                    stack.push(node);
            }
        }
        return visited;
    }

    public Set<T> breadthFirstTraversal(T root){
        Queue<T> queue=new LinkedList<>();
        Set<T> visited=new HashSet<>();
        queue.add(root);
        while(!queue.isEmpty()){
            T temp=queue.poll();
            if(!visited.contains(temp)){
                System.out.println("visiting :"+temp.toString());
                visited.add(temp);
                for(T node: getAdjVertices(temp))
                    queue.add(node);
            }
        }
        return visited;
    }
}
