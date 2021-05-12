package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerEx {
    public static void main(String[] args){
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");
        //Consumer 1 to change toi uppercase
        Consumer<List<String>> upperCaseCities= list->{
            for(int i=0; i<list.size(); i++){
                list.set(i,list.get(i).toUpperCase());
            }
        };
        //Consumer 2 to print.
        Consumer<List<String>> printCities= list->{
          list.stream().forEach(System.out::println);
        };
        //Use of combinational consumer
        upperCaseCities.andThen(printCities).accept(cities);

        //Sort and then consume
        cities.stream().sorted().forEach(s -> {
            s.toUpperCase();
            System.out.println(s);
        });

    }
}
