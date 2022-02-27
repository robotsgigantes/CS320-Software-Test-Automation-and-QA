/**
 * 
 * @author shcar
 */

package contact_service;

public class Contact
{
	//initialize variables
    private String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public void contact(String contactID, String firstName, String lastName, String phone, String address)
    {
    	//create booleans for ease of String length verification
        boolean abc = contactIDlen(contactID);
        if(abc)
        {
            this.contactID = contactID;
        }
        
        boolean fn = firstnamelen(firstName);
        if(fn)
        {
            this.firstName = firstName;
        }
        
        boolean ln = lastnamelen(lastName);
        if(ln)
        {
            this.lastName = lastName;
        }
        
        boolean ph = phone(phone);
        if(ph)
        {
            this.phone = phone;
        }
        
        boolean ad = address(address);
        if(ad)
        {
            this.address = address;
        }
    }
    
    //verify contactID length restrictions
    public boolean contactIDlen(String contactID)
    {
        boolean len;
        if(contactID.length()>=10 || contactID == null)
        {
            len = false;
        }
        else
        {
            len = true;
        }
        return len;
    }

    //verify name length restrictions
    public boolean firstnamelen(String firstname)
    {
        boolean len = true;
        if(firstname.length()>=10)
        {
            len = false;
        }
        return len;
    }

    public boolean lastnamelen(String lastname)
    {
        boolean len = true;
        if(lastname.length()>=10)
        {
            len = false;
        }
        return len;
    }

    //verify phone length restrictions
    public boolean phone(String phone)
    {
        boolean len = false;
        if(phone.length()==10)
        {
            len = true;
        }
        return len;
    }

    //verify address length restrictions
    public boolean address(String add)
    {
        boolean len = false;
        if(add.length() <=30)
        {
            len = true;
        }
        return len;
    }

    /*
     * public calls for other files in package
     */
    public String getContactID()
    {
        return contactID;
    }

    public void setFirstName(String firstName)
    {
        boolean fn = firstnamelen(firstName);
        if(fn)
        {
            this.firstName = firstName;
        }
    }
    
    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        boolean ln = lastnamelen(lastName);
        if(ln)
        {
            this.lastName = lastName;
        }
    }
    
    public String getLastName()
    {
        return lastName;
    }

    public void setAddress(String address)
    {
        boolean ad = address(address);
        if(ad)
        {
            this.address = address;
        }
    }
    
    public String getAddress()
    {
        return address;
    }

    public void setPhone(String phone)
    {
        boolean ph = phone(phone);
        if(ph)
        {
            this.phone = phone;
        }
    }
    
    public String getPhone()
    {
        return phone;
    }
}