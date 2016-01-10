package com.jrandom;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomCollections {
    public static <T> List<T> randomList(Supplier<T> supplier){
        return randomList(supplier, 0, RandomUtils.nextInt(0, 100));
    }

    public static <T> List<T> randomList(Supplier<T> supplier, int min, int max){
        return IntStream.range(min, max).mapToObj((i) -> supplier.get()).collect(Collectors.toList());
    }
}
