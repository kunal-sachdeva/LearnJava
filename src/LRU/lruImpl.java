package LRU;


import java.util.ArrayDeque;
import java.util.Deque;

public class lruImpl {
    Deque<Integer> lru;
    public lruImpl(){
        lru=new ArrayDeque<>();
    }
    public void insert(Integer i){
        if(lru.contains(i)){
            lru.remove(i);
            //lru.removeLastOccurrence(i);
            lru.addLast(i);
        }
        else if(lru.size()<5){
            lru.addLast(i);
        } else {
            lru.removeFirst();
            lru.addLast(i);
        }

    }
    public void showLru(){
            System.out.println("LRU Elements are : "+lru);
    }
    public static void main(String[] args){
          lruImpl l=new lruImpl();
          l.insert(1);
          l.insert(2);
          l.insert(3);
          l.insert(4);
          l.insert(5);
          l.showLru();
          l.insert(6);
          l.showLru();
          l.insert(3);
          l.showLru();
    }

}
