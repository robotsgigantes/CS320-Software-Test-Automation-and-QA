package contact_service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("unused")
public class ContactTest
{
   Contact cont;
   private String contactID;
   private String firstName;
   private String lastName;
   private String phone;
   private String address;

   @BeforeClass
   public void setup()
   {
        cont = new Contact();
   }

   @Test
   public void test()
   {
       cont.setFirstName("abcd");
       cont.setLastName("xyz");
       cont.setAddress("opp xyz");
       cont.setPhone("1234567890");
       cont.contact("12345","abcd","xyz","1234567890","opp xyz");
       contactID= cont.getContactID();
       firstName=cont.getFirstName();
       lastName=cont.getLastName();
       address = cont.getAddress();
       phone = cont.getPhone();
       Assert.assertEquals("12345",contactID);
       Assert.assertEquals("abcd",firstName);
       Assert.assertEquals("xyz",lastName);
       Assert.assertEquals("1234567890",phone);
       Assert.assertEquals("opp xyz",address);
   }

   @Test
   public void testWithExp()
   {
       cont.setFirstName("abcdefghijklmno");
       cont.setLastName("xyzooooooooooo");
       cont.setAddress("opp xyz;beside abc,state name,pin code,India");
       cont.setPhone("999999999999");
       cont.contact("12345000000","abcdefghijklmno","xyzooooooooooo","999999999999","opp xyz;beside abc,state name,pin code,India");
       contactID= cont.getContactID();
       firstName=cont.getFirstName();
       lastName=cont.getLastName();
       address = cont.getAddress();
       phone = cont.getPhone();
       Assert.assertNull(contactID);
       Assert.assertNull(firstName);
       Assert.assertNull(lastName);
       Assert.assertNull(phone);
       Assert.assertNull(address);
   }
}