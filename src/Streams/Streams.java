package Streams;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args){
        List<String> list= Arrays.asList("add1","add2","add3","add4","bad1","bad2","cad1","cad2","cad3");
        list.stream().filter( s -> s.contains("2")).forEach(System.out::println);
    }
}
