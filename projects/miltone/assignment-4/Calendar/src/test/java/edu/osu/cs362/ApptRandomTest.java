package edu.osu.cs362;

import org.junit.Test;

import java.util.Calendar;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 / 4; /* Timeout at 7.5 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"isValid","setDescription"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name
        }
	
    /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis();
				//System.out.println("Seed: " + randomseed);
				Random random = new Random(randomseed);



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
				for (int i = 0; i < NUM_TESTS; i++) {

					// DESCRIPTION TEST
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setDescription")){
						   String newD = (String)ValuesGenerator.getString(random);
						   appt.setDescription(newD);
						   assertFalse((appt.getDescription()).equals(description));
						}

					// ISVALID TEST
					if (methodName.equals("isValid")) {
						int ranHour = ValuesGenerator.getRandomIntBetween(random, -24, 47);
						int ranMinute = ValuesGenerator.getRandomIntBetween(random, -60, 120);
						int ranDay = ValuesGenerator.getRandomIntBetween(random, -30, 62);
						int ranMonth = ValuesGenerator.getRandomIntBetween(random, -12, 24);
						int ranYear = ValuesGenerator.getRandomIntBetween(random, -2000, 4000);

						Appt testValidAppt = new Appt(ranHour, ranMinute, ranDay, ranMonth, ranYear, null, null);

						if (testValidAppt.getStartHour() < 0 || testValidAppt.getStartHour() > 23)
							assertFalse(testValidAppt.getValid());

						else if (testValidAppt.getStartMinute() < 0 || testValidAppt.getStartMinute() > 59)
							assertFalse(testValidAppt.getValid());

						else if (testValidAppt.getStartDay() < 1 || testValidAppt.getStartDay() > 31)
							assertFalse(testValidAppt.getValid());

						else if (testValidAppt.getStartMonth() < 1 || testValidAppt.getStartMonth() > 12)
							assertFalse(testValidAppt.getValid());

						else
							assertTrue(testValidAppt.getValid());
					}

				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		 System.out.println("Done testing...");
	 }


	
}
