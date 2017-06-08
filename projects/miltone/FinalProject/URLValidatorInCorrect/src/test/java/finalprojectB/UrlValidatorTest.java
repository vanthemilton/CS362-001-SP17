/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;


/**
 *
        CONFIRMED BUGS
        1. PORT REGEX only accepts 3 digits, should accept up to the value of 2^16 ~= 65k   UrlValidator line 158
        2. IP address units allow greater than 8 bit values, allowing any 3 digit number.   InetAddressValidator line 69
        3. .[country] & .tv incorrectly invalid


        POSSIBLE BUGS
        1. From part A, last element of array of schemes isn't tested
        2. Larger than possible port number is treated as true
        3. Authority IP address accepts larger values than it should (999.999.999.999)
        4. .[country] incorrectly invalid
 */

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
       System.out.println("||||||||||||||||||||Manual Test BEGIN|||||||||||||||||||||||||");
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println(urlVal.isValid("http://www.amazon.com"));

	   // Scheme
       System.out.println("------------------Scheme-------------------");
       System.out.println(urlVal.isValid("https://www.amazon.com"));
       System.out.println(urlVal.isValid("123://www.amazon.com"));
       System.out.println(urlVal.isValid("https:/www.amazon.com"));
       System.out.println(urlVal.isValid("https//www.amazon.com"));
       System.out.println(urlVal.isValid("https:www.amazon.com"));
       System.out.println(urlVal.isValid("www.amazon.com"));

       // Authority
       System.out.println("-------------------Authority Commercial-------------------");
       System.out.println(urlVal.isValid("http://amazon.com"));
       System.out.println(urlVal.isValid("https://www.amazon"));
       System.out.println(urlVal.isValid("https://www.com"));
       System.out.println(urlVal.isValid("https://www.a.com"));
       System.out.println(urlVal.isValid("https://"));
       System.out.println(urlVal.isValid("https://123"));
       System.out.println(urlVal.isValid("https://123.com"));
       System.out.println(urlVal.isValid("https://get-dog-food.com"));
       System.out.println(urlVal.isValid("https://thereoncewasamanfromperuwhodreamedhewaseattinghisshoehewoke" +
               "withafrightinthemiddleofthenighttofindthathisdreamhadcometrue.com"));

       System.out.println("-------------------Authority NonCommercial-------------------");
       System.out.println(urlVal.isValid("https://www.census.gov"));
       System.out.println(urlVal.isValid("https://www.us.gov"));
       System.out.println(urlVal.isValid("https://www.greenpeace.org"));
       System.out.println(urlVal.isValid("https://www.travel.us")); //bug?
       System.out.println(urlVal.isValid("https://www.travel.uk")); //bug?
       System.out.println(urlVal.isValid("https://www.twitch.tv")); //bug?
       System.out.println(urlVal.isValid("https://www.travel.eu")); //BOUNDARY
       System.out.println(urlVal.isValid("https://www.oregonstate.edu"));
       //! BUG CONFIRMED, SEE TOP OF FILE #3


       System.out.println("-------------------Authority IP-------------------");
       System.out.println(urlVal.isValid("https://1.2.3.4"));
       System.out.println(urlVal.isValid("https://1.2.3.4."));
       System.out.println(urlVal.isValid("https://1.2.3.4.5"));
       System.out.println(urlVal.isValid("https://5000.5000.5000.5000"));
       System.out.println(urlVal.isValid("https://256.256.256.256")); //bug?
       System.out.println(urlVal.isValid("https://999.999.999.999")); //bug?
       System.out.println(urlVal.isValid("https://1000.1000.1000.1000")); //BOUNDARY
       //! BUG CONFIRMED, SEE TOP OF FILE #2


       // Port
       System.out.println("--------------------Port-----------------");
       System.out.println(urlVal.isValid("http://www.amazon.com:1"));
       System.out.println(urlVal.isValid("http://www.amazon.com:0"));
       System.out.println(urlVal.isValid("http://www.amazon.com:-1"));
       System.out.println(urlVal.isValid("http://www.amazon.com:80"));
       System.out.println(urlVal.isValid("http://www.amazon.com:500"));
       System.out.println(urlVal.isValid("http://www.amazon.com:513"));
       System.out.println(urlVal.isValid("http://www.amazon.com:900"));
       System.out.println(urlVal.isValid("http://www.amazon.com:999"));     // BOUNDARY
       System.out.println(urlVal.isValid("http://www.amazon.com:1000"));//bug?
       System.out.println(urlVal.isValid("http://www.amazon.com:10000"));   //bug?
       System.out.println(urlVal.isValid("http://www.amazon.com:100000"));//bug?
       System.out.println(urlVal.isValid("http://www.amazon.com:1000000000000000000000000"));//bug?
       //! BUG CONFIRMED, SEE TOP OF FILE #1


       // Path
       System.out.println("--------------------Path-----------------");
       System.out.println(urlVal.isValid("http://www.amazon.com/a"));
       System.out.println(urlVal.isValid("http://www.amazon.com/abcdefghijklmnopqrstuvwxyz"));
       System.out.println(urlVal.isValid("http://www.amazon.com/10000000000000000000000"));
       System.out.println(urlVal.isValid("http://www.amazon.com/-+_=-=_+-=-][]{}{}{[]["));
       System.out.println(urlVal.isValid("http://www.amazon.com/butts"));
       System.out.println(urlVal.isValid("http://www.amazon.com/butts/tushy/bum/bumbum/rump/ass/behind/rear/rearend/booty/"));
       System.out.println(urlVal.isValid("http://www.amazon.com//"));


       // Query
       System.out.println("---------------------Query----------------");
       System.out.println(urlVal.isValid("http://www.amazon.com/?search=pigs"));
       System.out.println(urlVal.isValid("http://www.amazon.com/?search=pigs&id=suey"));
       System.out.println(urlVal.isValid("https://www.amazon.com/s/field-keywords=piggy"));
       System.out.println(urlVal.isValid("http://www.amazon.com/?search=125247"));
       System.out.println(urlVal.isValid("http://www.amazon.com/?search=][:"));

   }
   
   
   public void testYourFirstPartition()
   {
	   
   }
   
   public void testYourSecondPartition(){
	   
   }
   
   
   public void testIsValid()
   {
	   for(int i = 0; i < 10000 ;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   // found required number of bugs, oping out of additional tests
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
