package com.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMapOfStream {
    public static void main(String[] args) {

        Integer [] arr = {1,2,3,4,1,2,3};

        //first approach
        Map<Integer, Integer> map = new HashMap<>();
        List.of(arr).forEach(d -> map.put(d, map.containsKey(d) ? map.get(d)+1 : 1));
        System.out.println("elements : "+map);


        //second approach
        Map<Integer,Integer> collect1 = Arrays.stream(arr)
                .collect( Collectors.groupingBy( Function.identity(), Collectors.summingInt(e -> 1) ));
        System.out.println("count1 is : "+collect1);


        //third approach
        Map<Integer,Long> collect2 = Arrays.stream(arr)
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));
        System.out.println("count2 is : "+collect2);

    }
}
