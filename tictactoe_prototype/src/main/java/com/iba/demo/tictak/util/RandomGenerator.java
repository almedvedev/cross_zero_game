package com.iba.demo.tictak.util;

import java.util.Random;

public class RandomGenerator {
private Random random;
	
	public RandomGenerator() {
		random = new Random();
	}
	
	/**
     * @param bound the upper bound (exclusive).  Must be positive.
     * @return {@code int} value between 1 (inclusive) and the specified value (exclusive)
     * @throws IllegalArgumentException if bound is not positive
     */
	public Integer getNext(Integer bound) {
		Integer randomInt = random.nextInt(bound - 1) + 1;
		
		return randomInt;
	}
	
}
