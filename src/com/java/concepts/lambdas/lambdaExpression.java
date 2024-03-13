package com.java.concepts.lambdas;

import java.util.ArrayList;
import java.util.List;

public class lambdaExpression {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>(List.of(
            "alpha","bravo", "charlie", "delta"
        ));

        for(String s: list){
            System.out.println(s);
        }
        System.out.println("----------");
        list.forEach((myString) -> System.out.println(myString));

        System.out.println("----------");
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });

        int result = calculator((a, b) -> a + b, 5, 2);

    }

    public static <T> T calculator(Operation<T> funciton, T value1, T value2){
        T result =funciton.opearate(value1, value2);
        System.out.println("Result: " + result);
        return result;
    }
}
