package com.iba.demo.tictak;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.iba.demo.tictak.util.RandomGenerator;

public class RandomGeneratorTest {
	
	public static final Integer MAX_ITER_COUNT = 100;
	private RandomGenerator gen;
	
	@Before
	public void init() {
		gen = new RandomGenerator();
	}
	
	@Test
	public void testGenerationFromOneToNine() {
		List<Integer> validatedSeq = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Set<Integer> seq = new HashSet<>();
		Boolean completed = false;
		Integer iterCounter = 0;
		
		while(!completed) {
			Integer num = gen.getNext(10);
			assertNotEquals("The generated value should not be 0!", new Integer(0), num);

			seq.add(num);
			if(seq.containsAll(validatedSeq)) {
				completed = true;
			}
			
			assertNotEquals("The generator has exceeded the maximum number of iterations!",
					MAX_ITER_COUNT, iterCounter);
			iterCounter++;
		}
	}
	
	@Test
	public void testGenerationInRange() {
		Integer from = 1;
		Integer to = 9;
		
		List<Integer> validatedSeq = new ArrayList<>();
		Set<Integer> seq = new HashSet<>();
		Boolean completed = false;
		Integer iterCounter = 0;
		
		
		for(int i = from; i < to + 1; i++) {
			validatedSeq.add(i);
		}
		
		while(!completed) {
			Integer num = gen.getRandomNumInRange(from, to);
			
			seq.add(num);
			if(seq.containsAll(validatedSeq)) {
				completed = true;
			}
			
			assertNotEquals("The generator has exceeded the maximum number of iterations!",
					MAX_ITER_COUNT, iterCounter);
			iterCounter++;
		}
	}
	
}
