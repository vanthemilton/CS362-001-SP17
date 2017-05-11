package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CalDayTest {

	@Test
	public void test01() throws Throwable {

		//Construct a Gregorian Calendar Object and pass in to CalDay
		GregorianCalendar gregor = new GregorianCalendar();
		CalDay cal = new CalDay(gregor);
		assertTrue(cal.isValid());

		//Test empty constructor
		CalDay calEmpty = new CalDay();
		assertFalse(calEmpty.isValid());

		//Create appts
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt apptNo1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		startHour=1;
		startMinute=15;
		startDay=20;
		startMonth=6;
		startYear=2017;
		title="Slumber Party";
		description="This is my slumber party.";
		Appt apptNo2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		startHour=8;
		startMinute=20;
		startDay=20;
		startMonth=6;
		startYear=2017;
		title="Bachelor Party";
		description="This is my bachelor party.";
		Appt apptNo3 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		//add valid appts to CalDay
		cal.addAppt(apptNo1);
		cal.addAppt(apptNo2);
		cal.addAppt(apptNo3);

		assertEquals(3, cal.getSizeAppts());

		//create and try to add invalid
		startHour=666;
		startMinute=666;
		startDay=666;
		startMonth=666;
		startYear=2017;
		title="Evil Party";
		description="This is my evil party.";
		Appt apptNo4 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		cal.addAppt(apptNo4);

		assertEquals(3, cal.getSizeAppts());
	}

	/*
	 *  		test iterator
	 */
	@Test
	public void test02() throws Throwable {

		//Construct a Gregorian Calendar Object and pass in to CalDay
		GregorianCalendar gregor = new GregorianCalendar();
		CalDay cal = new CalDay(gregor);
		assertTrue(cal.isValid());
		cal.iterator();

		CalDay cal2 = new CalDay();
		assertFalse(cal2.isValid());
		cal2.iterator();
	}

	/*
	 *  		test toString()
	 */
	@Test
	public void test03() throws Throwable {

		//Construct a Gregorian Calendar Object and pass in to CalDay
		GregorianCalendar gregor = new GregorianCalendar();
		CalDay cal = new CalDay(gregor);
		assertTrue(cal.isValid());

		//Create appts
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt apptNo1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		//test toString
		cal.addAppt(apptNo1);
		String calString = cal.toString();

		String half = (apptNo1.getStartHour() > 11) ? "pm" : "am";
		int printableHour = apptNo1.getStartHour();
		if (printableHour > 11)	{printableHour -= 12;}
		if (printableHour == 0)	{printableHour = 12;}
		String printableHourString = String.valueOf(printableHour);

		String dateAndTime =  apptNo1.getStartMonth() + "/" + apptNo1.getStartDay() + "/" + apptNo1.getStartYear()
		+ " at " + printableHourString + ":" + apptNo1.getStartMinute() + half;

		assertEquals("\t --- " + cal.getMonth() + "/" + cal.getDay() + "/" + cal.getYear() + " --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t" + dateAndTime + " ,Birthday Party, This is my birthday party.\n \n", calString);
	}
}
