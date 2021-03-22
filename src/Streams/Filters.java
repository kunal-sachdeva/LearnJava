package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Filters {
    //filter accepts predicate which is Boolean FunctionalInterface
    //And for each accepts consumer functionInterface
    public static void main(String[] args){
        List<String> list= Arrays.asList("add1","add3","add4","add2");
        //list.stream().filter( s -> s.contains("2")).forEach(System.out::println);
        list.sort(Comparator.comparing(s -> s));
        list.stream().forEach(System.out::println);

    }
}
