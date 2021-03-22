package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args){
        List<String> list= Arrays.asList("add1","add2","add3","add4","bad1","bad2","cad1","cad2","cad3");
        //list.stream().filter( s -> s.contains("2")).forEach(System.out::println);
        List<Integer> listInt=Arrays.asList(1,2,3,4,5);
        Integer sum = listInt.stream().mapToInt(Integer::intValue).sum();

        List<Product> productList=Arrays.asList(new Product(1,20.50,"Tomato"),
                new Product(1,41.50,"Onion"),
                new Product(1,30.80,"Potato")
                );
        // Use of function and sorting
        //Function takes one parameter and then return one value. BiFunction takes 2 parameter and return one.
        productList.sort(Comparator.comparing(product -> product.getPrice()));
        productList.stream().forEach(System.out::println);

    }
}
