package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class StackImpl {
    public static void main(String[] args) {
        Deque<String> q = new ArrayDeque<>();
        String path = "/home//foo/";
        String[] tokens = path.split("/");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("..")) {
                q.pollLast();
            } else if (!(tokens[i].length() ==0) && !tokens[i].equals(".")) {
                q.addLast(tokens[i]);
            }
    }
        String res="";
       while(!q.isEmpty()){
          res=res+"/"+q.pollFirst();
       }
       if(res.length()==0)
           res="/";
       System.out.println(res);
    }
}
