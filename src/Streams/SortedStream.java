package Streams;

import java.util.Arrays;
import java.util.List;


import java.util.Arrays;
import java.util.List;

    public class SortedStream {
        public static void main(String[] args){
            List<String> list= Arrays.asList("add1","add2","add3","add4","bad1","bad2","cad1","cad2","cad3");
            list.stream()
                    .sorted((a,b)-> b.compareTo(a)) //use only 'sorted()' for ascending order
                    .forEach(System.out::println);
        }
    }


