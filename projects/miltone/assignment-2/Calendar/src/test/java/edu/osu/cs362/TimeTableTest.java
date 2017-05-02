package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {

		 //make linked lists
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 LinkedList<Appt> appts = new LinkedList<Appt>();

	 	//make timetable and calendars
		 TimeTable tt = new TimeTable();
		 GregorianCalendar today = new GregorianCalendar(2017, 6, 3);
		 GregorianCalendar later = new GregorianCalendar(2017, 6, 4);
		 GregorianCalendar before = new GregorianCalendar(2017, 6, 2);

		 //make caldays
		 CalDay current = new CalDay(today);
		 CalDay future = new CalDay(later);
		 CalDay past = new CalDay(before);

		 //create appts
		 int startHour=13;
		 int startMinute=30;
		 int startDay=2;
		 int startMonth=6;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt apptNo1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);	// earliest

		 startHour=1;
		 startMinute=15;
		 startDay=3;
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
				 description);	// middle

		 startHour=8;
		 startMinute=20;
		 startDay=4;
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
				 description);	// latest

		 //add to list of appts
		 appts.add(apptNo1);
		 appts.add(apptNo2);
		 appts.add(apptNo3);

		 //add appointments to CalDay
		 past.addAppt(apptNo1);
		 current.addAppt(apptNo2);
		 future.addAppt(apptNo3);

		 //add caldays to list of caldays
		 calDays.add(past);
		 calDays.add(current);
		 calDays.add(future);

		 //get CalDays Linked List
		 GregorianCalendar start = new GregorianCalendar(2017, 6, 2);
		 GregorianCalendar end = new GregorianCalendar(2017, 6, 5);
		 LinkedList<CalDay> getApptRangeReturnArray = tt.getApptRange(appts, start, end); // proper order days

		 assertEquals(getApptRangeReturnArray + "", calDays + ""); //test getApptRange   //!! Formatting


		 //test illegal date range
		try {
			LinkedList<CalDay> getIllegalRangeReturnArray = tt.getApptRange(appts, end, start); // proper order days
			fail("illegal exeption from getApptRange was not properly thrown");
		} catch (IllegalArgumentException e) {
			assertTrue(true); // illegal argument caught
		}


		 //test invalid appts in list
		 LinkedList<Appt> inValidList = new LinkedList<Appt>();
		 Appt inValidAppt = new Appt(666, 666, 666, 666, 666,
				 "bad", "aint no good");

		 inValidList.add(inValidAppt);
		 LinkedList<CalDay> getApptRangeInvalidReturnArray = tt.getApptRange(inValidList, start, end); // invalid appt in list


		 //test empty list
		 LinkedList<Appt> Empty = new LinkedList<Appt>();
		 LinkedList<CalDay> EmptyApptListReturn = tt.getApptRange(Empty, start, end); // no appts in list
		 assertEquals(EmptyApptListReturn + "" , getApptRangeInvalidReturnArray + "");


		 //test can delete from empty list
		 LinkedList<Appt> apptsEmpty = new LinkedList<Appt>();
		 assertNull(tt.deleteAppt(apptsEmpty, apptNo1));


		 //test deleting appt
		 tt.deleteAppt(appts, apptNo1); //test deleteAppt
		 assertFalse(appts.contains(apptNo1));


		 //test delete null
		 tt.deleteAppt(appts, null); //test deleteAppt
		 assertTrue(appts.contains(apptNo2));


		 //test delete inValid appts
		 appts.add(inValidAppt);
		 tt.deleteAppt(appts, inValidAppt); //test deleteAppt
		 assertTrue(appts.contains(inValidAppt));


		 //test deleting from null
		 assertNull(tt.deleteAppt(null, inValidAppt)); //test deleteAppt
	 }


}
