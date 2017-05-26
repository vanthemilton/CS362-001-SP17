package edu.osu.cs362;

import org.junit.Test;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 / 4; /* Timeout at 7.5 seconds */
	private static final int NUM_TESTS = 100;

	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */
	@Test
	public void radnomtest() throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		System.out.println("Start testing...");

		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed = System.currentTimeMillis();
			//System.out.println("Seed: " + randomseed);
			Random random = new Random(randomseed);

			for (int i = 0; i < NUM_TESTS; i++) {

				// make seeds
				int valueSeed = ValuesGenerator.getRandomIntBetween(random,0, 3);
				int addAppt1toListSeed = ValuesGenerator.getRandomIntBetween(random,0, 1);
				int addAppt2toListSeed = ValuesGenerator.getRandomIntBetween(random,0, 1);

				// make objects
				int ranHour = ValuesGenerator.getRandomIntBetween(random, -24, 47);
				int ranMinute = ValuesGenerator.getRandomIntBetween(random, -60, 120);
				int ranDay = ValuesGenerator.getRandomIntBetween(random, -30, 62);
				int ranMonth = ValuesGenerator.getRandomIntBetween(random, -12, 24);
				int ranYear = ValuesGenerator.getRandomIntBetween(random, -2000, 4000);
				Appt testAppt1 = new Appt(ranHour, ranMinute, ranDay, ranMonth, ranYear, null, null);

				ranHour = ValuesGenerator.getRandomIntBetween(random, -24, 47);
				ranMinute = ValuesGenerator.getRandomIntBetween(random, -60, 120);
				ranDay = ValuesGenerator.getRandomIntBetween(random, -30, 62);
				ranMonth = ValuesGenerator.getRandomIntBetween(random, -12, 24);
				ranYear = ValuesGenerator.getRandomIntBetween(random, -2000, 4000);
				Appt testAppt2 = new Appt(ranHour, ranMinute, ranDay, ranMonth, ranYear, null, null);

				LinkedList<Appt> list = new LinkedList<Appt>();
				if (addAppt1toListSeed == 1)
					list.add(testAppt1);

				if (addAppt2toListSeed == 1)
					list.add(testAppt2);

				TimeTable tt = new TimeTable();


				// TEST DELETEAPPT
				LinkedList<Appt> returnList;
				switch (valueSeed) {

					case 0:
						returnList = tt.deleteAppt(list, testAppt1);
						if (addAppt1toListSeed == 1 && testAppt1.getValid()) {
							assertFalse(returnList.contains(testAppt1));
							assertNotNull(returnList);
						}
						else
							assertNull(returnList);

					case 1:
						returnList = tt.deleteAppt(null, testAppt1);
						assertNull(returnList);

					case 2:
						returnList = tt.deleteAppt(list, null);
						assertNull(returnList);

					case 3:
						returnList = tt.deleteAppt(null, null);
						assertNull(returnList);

				}
			}
			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if ((iteration % 10000) == 0 && iteration != 0)
				System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		}
		System.out.println("Done testing...");
	}
}
