package contact_service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.HashMap;


public class ContactServiceTest
{
    ContactService contactservice;
    Contact contact;
    @SuppressWarnings("unused")
	private String uniqueID;
    @SuppressWarnings("unused")
	private String firstName ;
    @SuppressWarnings("unused")
	private String lastName ;
    @SuppressWarnings("unused")
	private String phone;
    @SuppressWarnings("unused")
	private String address;
    private HashMap<String,Contact> contactlist=new HashMap<>();

    @SuppressWarnings("unused")
	private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setup()
    {
        System.setOut(new PrintStream(outputStreamCaptor));
        contactservice = new ContactService();
        contact = new Contact();
        contact.contact("1","def","hij","4567891230","opp xyz,near abc");
        contactlist.put("1",contact);
    }

    @Test
    public void addNewContact()
    {
        contactservice.addNewContact(contactlist,"cde","fgh","0123456789","opp xyz");
        Assert.assertEquals(2,contactlist.size());
    }

    @Test
    public void addNewContactException()
    {
        contactservice.addNewContact(contactlist,"abcdefghijklmno","xyz","0123456789","opp xyz");
        Assert.assertEquals("Try again with a valid input", outputStreamCaptor.toString().trim());
    }

    @Test
    public void updateFirstName()
    {
        contactservice.updateFirstName(contactlist,"1","abc");
        Assert.assertEquals("abc",contact.getFirstName());
    }

    @Test
    public void removeContact()
    {
        contactservice.removeContact(contactlist,"1");
        Assert.assertNotEquals(true,contactlist.containsKey("1"));
    }

    @Test
    public void updateLastName()
    {
        contactservice.updateLastName(contactlist,"1","abc");
        Assert.assertEquals("abc",contact.getLastName());
    }

    @Test
    public void updateaddress()
    {
        contactservice.address(contactlist,"1","opp abc");
        Assert.assertEquals("opp abc",contact.getAddress());
    }

    @Test
    public void updatephonenumber()
    {
        contactservice.updateNumber(contactlist,"1","0123456789");
        Assert.assertEquals("0123456789",contact.getPhone());
    }

    @Test
    public void firstNameException()
    {
        contactservice.updateFirstName(contactlist,"3","abc");
        Assert.assertEquals("Check your ID and try again", outputStreamCaptor.toString().trim());
    }

    @Test
    public void lastNameException()
    {
        contactservice.updateLastName(contactlist,"3","abc");
        Assert.assertEquals("Check your ID and try again", outputStreamCaptor.toString().trim());
    }

    @Test
    public void removeContactException()
    {
        contactservice.removeContact(contactlist,"3");
        Assert.assertEquals("Check your ID and try again", outputStreamCaptor.toString().trim());
    }

    @Test
    public void updateAddressException()
    {
        contactservice.address(contactlist,"3","opp abc");
        Assert.assertEquals("Check your ID and try again", outputStreamCaptor.toString().trim());
    }

    @Test
    public void updateNumberException()
    {
        contactservice.updateNumber(contactlist,"3","0123456789");
        Assert.assertEquals("Check your ID and try again", outputStreamCaptor.toString().trim());
    }

    @Test
    public void phoneNumException()
    {
        contactservice.addNewContact(contactlist,"abcd","xyz","012345678900","opp xyz");
        Assert.assertEquals("Try again with a valid input", outputStreamCaptor.toString().trim());
    }
}