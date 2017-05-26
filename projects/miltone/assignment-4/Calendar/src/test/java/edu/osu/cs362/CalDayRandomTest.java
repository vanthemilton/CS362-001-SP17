package edu.osu.cs362;


import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 / 4; /* Timeout at 7.5 seconds */
	private static final int NUM_TESTS = 100;

	/**
	 * Generate Random Tests that tests CalDay Class.
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

			// PRELIMS

			for (int i = 0; i < NUM_TESTS; i++) {

				// TEST ADDAPPT

				//		make CalDay
				GregorianCalendar cal = new GregorianCalendar();
				CalDay calday = new CalDay(cal);

				//		make appts
				int ranHour = ValuesGenerator.getRandomIntBetween(random, -24, 47);
				int ranMinute = ValuesGenerator.getRandomIntBetween(random, -60, 120);
				int ranDay = ValuesGenerator.getRandomIntBetween(random, -30, 62);
				int ranMonth = ValuesGenerator.getRandomIntBetween(random, -12, 24);
				int ranYear = ValuesGenerator.getRandomIntBetween(random, -2000, 4000);

				Appt appt1 = new Appt(ranHour, ranMinute, ranDay, ranMonth, ranYear, "appt 1", "cool");

				ranHour = ValuesGenerator.getRandomIntBetween(random, -24, 47);
				ranMinute = ValuesGenerator.getRandomIntBetween(random, -60, 120);
				ranDay = ValuesGenerator.getRandomIntBetween(random, -30, 62);
				ranMonth = ValuesGenerator.getRandomIntBetween(random, -12, 24);
				ranYear = ValuesGenerator.getRandomIntBetween(random, -2000, 4000);

				Appt appt2 = new Appt(ranHour, ranMinute, ranDay, ranMonth, ranYear, "appt 2", "warm");

				//		addAppt()
				calday.addAppt(appt1);
				calday.addAppt(appt2);

				// 		asserts
				LinkedList<Appt> list = calday.getAppts();

				if (appt1.getValid())
					assertTrue(list.contains(appt1));
				else
					assertFalse(list.contains(appt1));

				if (appt2.getValid())
					assertTrue(list.contains(appt2));
				else
					assertFalse(list.contains(appt2));

				if (appt1.getValid() && appt2.getValid()) {
					if (appt1.getStartHour() <= appt2.getStartHour())
						assertEquals(list.get(0), appt1);

					else
						assertEquals(list.get(0), appt2);
				}
			}
			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if ((iteration % 10000) == 0 && iteration != 0)
				System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		}
		System.out.println("Done testing...");

	}
}
