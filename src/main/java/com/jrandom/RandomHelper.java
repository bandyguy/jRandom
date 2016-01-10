package com.jrandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class RandomHelper {
    public static int randomInt(){
        return RandomUtils.nextInt(0, 100);
    }

    public static int randomInt(int startInclusive, int endExclusive){
        return RandomUtils.nextInt(startInclusive, endExclusive);
    }

    public static String randomString(){
        return RandomStringUtils.randomAlphabetic(randomInt(10, 100));
    }

    public static String randomString(int size){
        return RandomStringUtils.randomAlphabetic(size);
    }

    public static String randomString(int startInclusive, int endInclusive){
        return RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(startInclusive, endInclusive));
    }
}
