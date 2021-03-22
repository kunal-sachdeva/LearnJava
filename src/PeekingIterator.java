import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    Boolean hasPeeked=false;
    int peekedElement;
    Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator=iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasPeeked){
            peekedElement=iterator.next();
            hasPeeked=true;
        }
        return peekedElement ;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(hasPeeked) {
            hasPeeked=false;
            return peekedElement;
        } else
            return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return hasPeeked||iterator.hasNext();
    }

}

class test{
    public static void main(String[] args){
        List<Integer> ll= Arrays.asList(new Integer[]{1,2,3});
        Iterator<Integer> i=ll.iterator();
        PeekingIterator p= new PeekingIterator(i);
        System.out.println(p.next());
        System.out.println(p.peek());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.hasNext());
    }
}
