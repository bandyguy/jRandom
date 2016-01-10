package com.jrandom;

import org.apache.commons.lang3.RandomUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static com.jrandom.RandomCollections.randomList;
import static com.jrandom.RandomHelper.randomInt;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class RandomCollectionsTest {
    @Test
    public void testRandomListProducesListFromSupplierWithSizeBetween0And100() throws Exception {
        IntStream.range(0, 1000).forEach((i) -> {
            List<Integer> randomList = randomList(() -> 1);
            assertThat(randomList.size(), greaterThanOrEqualTo(0));
            assertThat(randomList.size(), lessThan(100));
        });
    }

    @Test
    public void testRandomListDoesNotAlwaysProduceListOfSameSize() throws Exception {
        Set<Integer> listSizes = new HashSet<>();
        IntStream.range(0, 1000).forEach((i) -> {
            listSizes.add(randomList(() -> 1).size());
        });
        assertThat(listSizes.size(), greaterThan(1));
    }

    @Test
    public void testRandomListObeysConstraints() throws Exception {
        int minSize = randomInt(10, 100);
        int maxSize = randomInt(100, 200);
        IntStream.range(0, 10000).forEach((i) -> {
            List<Integer> randomList = randomList(() -> 1, 10, 100);
            assertThat(randomList.size(), greaterThanOrEqualTo(minSize));
            assertThat(randomList.size(), lessThan(maxSize));
        });
    }
}