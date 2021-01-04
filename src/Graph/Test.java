package Graph;

import Tree.BinaryTree;
import Tree.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        UndirectedGraph<Integer> graph= new UndirectedGraph<>(new HashMap<>());
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(4,1);
        graph.addEdge(3,1);
        graph.addEdge(2,1);
        graph.addEdge(2,3);
        graph.addEdge(4,3);
        graph.breadthFirstTraversal(0);
        int[] arr=new int[3];


    }
}
