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
		Integer randomNum = random.nextInt(bound - 1) + 1;
		
		return randomNum;
	}
	
	/**
     * @param from initial value of the range
     * @param to end value of the range
     * @return {@code int} value between {@code from} (inclusive) and the {@code end} (inclusive)
     * @throws IllegalArgumentException if bound is not positive
     */
	public Integer getRandomNumInRange(int from, int to) {
		if(from > to) {
			throw new IllegalArgumentException("TO should be more than FROM");
		}
		
		Integer randomNum = random.nextInt((to - from) + 1) + from;
		
		return randomNum;
	}
	
}
