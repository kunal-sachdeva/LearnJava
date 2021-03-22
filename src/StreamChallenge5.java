import Tree.Node;
import javafx.util.Pair;

import java.util.*;

public class StreamChallenge5 extends Thread {

    public static void main(String[] args) {
        int[] candyType;
        Deque<Integer> d = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        s.append("c"+"#");
        String[] words={"time","stime","estime"};
        Arrays.sort(words,(s1,s2)->s2.length()-s1.length());
        Arrays.stream(words).forEach(System.out::println);
        String str="";
        boolean b=true;
        Boolean b1=new Boolean(true);
        b1.equals(b);

    }

}
