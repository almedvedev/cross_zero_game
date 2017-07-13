package com.iba.demo.tictak.test;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.iba.demo.tictak.util.RandomGenerator;

public class RandomGeneratorTest {
	
	public static final Integer MAX_ITER_COUNT = 100;
	
	@Test
	public void testGenerationFromOneToNine() {
		RandomGenerator gen = new RandomGenerator();
		List<Integer> validatedSeq = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Set<Integer> seq = new HashSet<>();
		Boolean completed = false;
		Integer iterCounter = 0;
		
		while(!completed) {
			Integer num = gen.getNext(10);
			System.out.print(num);
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
	
}