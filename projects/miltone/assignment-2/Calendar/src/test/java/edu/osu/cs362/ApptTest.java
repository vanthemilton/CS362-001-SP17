package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertEquals("\t4/10/2017 at 1:30pm, Birthday Party, This is my birthday party.\n", appt.toString());
	 }

	/*
	 *		Test invalid cases
	 *
	 */
	@Test
	public void test02()  throws Throwable  {
		int startHour=350;
		int startMinute=89;
		int startDay=40;
		int startMonth=20;
		int startYear=-50;
		String title="Begin spiral of self destructive habits";
		String description="Find as much Skooma as possible and go nuts.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		// assertions
		assertFalse(appt.getValid());

		// test sets and isValid
		appt.setStartHour(20);
		assertFalse(appt.getValid());

		appt.setStartMinute(30);
		assertFalse(appt.getValid());

		appt.setStartDay(15);
		assertFalse(appt.getValid());

		assertEquals(null, appt.toString());

		appt.setStartMonth(5);
		assertTrue(appt.getValid());

		appt.setStartYear(5000);
		assertTrue(appt.getValid());

		// reset values and check isValid
		appt.setStartHour(0);
		assertTrue(appt.getValid());

		assertEquals("\t5/15/5000 at 12:30am, Begin spiral of self destructive habits, Find as much Skooma as possible and go nuts.\n", appt.toString());
	}

	/*
	*		test toString, setTitle, and setDescription NULL cases
	 */

	@Test
	public void test03()  throws Throwable  {
		int startHour=350;
		int startMinute=89;
		int startDay=40;
		int startMonth=13;
		int startYear=-50;
		String title="Begin spiral of self destructive habits";
		String description="Find as much Skooma as possible and go nuts.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		// assertions

		// test toString of invalid
		appt.setStartHour(999);
		assertEquals(null, appt.toString());

		appt.setDescription(null);
		appt.setTitle(null);

		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	}
	
}
