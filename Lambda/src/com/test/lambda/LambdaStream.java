package com.test.lambda;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class LambdaStream {
    @Test
    public void test(){
        Stream<Double> stream = Stream.generate(()->Math.random());
        stream.forEach(num -> System.out.println(num));
    }
}
