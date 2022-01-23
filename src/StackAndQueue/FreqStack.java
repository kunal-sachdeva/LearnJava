package StackAndQueue;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FreqStack {
    List<Pair<Integer,Integer>> stack;
    Map<Integer,Integer> countMap;
        public FreqStack() {
            stack=new LinkedList<>();
            countMap=new HashMap<>();
        }

        public void push(int x) {
            if (countMap.get(x) != null) {
                countMap.replace(x, countMap.get(x) + 1);
            } else {
                countMap.putIfAbsent(x, 1);
            }
            stack.add(new Pair(x,countMap.get(x)));

        }

        public int pop() {
             int index=stack.size()-1;
            int maxVal=1;
             for(Pair p:stack){
                 if((int)p.getValue()>1 && (int)p.getValue()>=maxVal) {
                     index = stack.indexOf(p);
                     maxVal = (int) p.getValue();
                 }
             }
            if (maxVal > 1) {
                countMap.replace(stack.get(index).getKey(), maxVal - 1);
            } else {
                countMap.remove(stack.get(index).getKey());
            }
            return stack.remove(index).getKey();
        }
    public static void main(String[] args){
        FreqStack f=new FreqStack();
        f.push(1);
        f.push(1);
        f.push(1);
        f.push(2);
        System.out.println(f.pop());
        System.out.println(f.pop());
        f.push(2);
        f.push(2);
        f.push(1);
        /*f.push(6);
        f.push(1);
        f.push(5);

        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());*/
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
    }
}
