/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 13 21:20:49 GMT 2017
 */

package edu.osu.cs362;

import org.junit.Test;
import static org.junit.Assert.*;
/*import static org.evosuite.runtime.EvoAssertions.*;
import edu.osu.cs362.Point;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;*/

//@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true)
public class Point_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Point point0 = new Point();
      Point point1 = new Point((-1), 0);
      double double0 = point0.getSlopeBetween(point1);
      assertEquals(-1, point1.getXaxis());
      assertEquals(1.0, double0, 0.01);
      assertEquals(0, point1.getYaxis());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Point point0 = new Point((-1), (-1));
      Point point1 = new Point();
      double double0 = point0.distanceFrom(point1);
      assertEquals(-1, point0.getYaxis());
      assertEquals(-1, point0.getXaxis());
      assertEquals(0, point1.getXaxis());
      assertEquals(0, point1.getYaxis());
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Point point0 = new Point(1556, 1556);
      double double0 = point0.distanceFrom(point0);
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Point point0 = new Point();
      int int0 = point0.getYaxis();
      assertEquals(0, int0);
      assertEquals(0, point0.getXaxis());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Point point0 = new Point();
      point0.setXaxis(1727);
      int int0 = point0.getXaxis();
      assertEquals(1727, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Point point0 = new Point((-1), (-1));
      int int0 = point0.getXaxis();
      assertEquals(-1, point0.getYaxis());
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Point point0 = new Point();
      point0.setYaxis(1312);
      double double0 = point0.getSlopeBetween(point0);
      assertEquals(1312, point0.getYaxis());
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Point point0 = new Point();
      double double0 = point0.getSlopeBetween(point0);
      assertEquals(Double.NaN, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Point point0 = new Point(0, 1);
      Point point1 = new Point(1, 1);
      double double0 = point0.getSlopeBetween(point1);
      assertEquals(Double.NEGATIVE_INFINITY, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Point point0 = new Point();
      Point point1 = new Point(1, 0);
      double double0 = point1.distanceFrom(point0);
      assertEquals(1, point1.getXaxis());
      assertEquals(1.0, double0, 0.01);
      assertEquals(0, point0.getYaxis());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Point point0 = new Point();
      // Undeclared exception!
      try { 
        point0.distanceFrom((Point) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.Point", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Point point0 = new Point();
      int int0 = point0.getXaxis();
      assertEquals(0, int0);
      assertEquals(0, point0.getYaxis());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Point point0 = new Point(96, 96);
      int int0 = point0.getYaxis();
      assertEquals(96, int0);
      assertEquals(96, point0.getXaxis());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Point point0 = new Point(96, 96);
      point0.setYaxis((-1));
      int int0 = point0.getYaxis();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Point point0 = new Point();
      // Undeclared exception!
      try { 
        point0.getSlopeBetween((Point) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.Point", e);
      }
  }
}
