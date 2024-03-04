package maintests;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.Contact;

class ContactTest{

	@DisplayName("Test a valid Constructor")
	@Test
	public void testGoodConstructor() {
        String contactId = "1";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        
		assertEquals(1, testContact.getContactID());
		assertEquals(firstName, testContact.getFirstName());
		assertEquals(lastName, testContact.getLastName());
		assertEquals(phoneNumber, testContact.getPhoneNumber());
		assertEquals(address, testContact.getAddress());
	}
	
	@DisplayName("Test an invalid Constructor")
	@Test
	public void testBadConstructor() {
      	String badID = null;
      	
		String firstName = "Frank";
        String lastName = "Garcia";
        String address = "444 Wince Street";       
        
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      		 new Contact(badID, firstName, lastName, "9234932013", address);
        });
      	
      	assertEquals("Invalid contact ID", exception.getMessage());
      	
      	exception = assertThrows(IllegalArgumentException.class, () -> {
      		 new Contact("0", firstName, lastName, "1", address);
        });
      	
      	assertEquals("Invalid phone number", exception.getMessage());
	}
	
	@DisplayName("Test a valid setFirstName")
	@Test
	public void testGoodSetFirst() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setFirstName("Test");        
        assertEquals("Test", testContact.getFirstName());
	}
	
	@DisplayName("Test an invalid null setFirstName")
	@Test
	public void testBadSetFirst() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName(null);
        });
	}
	
	
	@DisplayName("Test an invalid length setFirstName")
	@Test
	public void testLongSetFirst() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName("IamWayTooLongOfAFirstName");
        });
	}
	
	@DisplayName("Test getID")
	@Test
	public void testGetID() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        assertEquals(3, testContact.getContactID());
	}	
	@DisplayName("Test bad getID")
	@Test
	public void testBadGetID() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Steet";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        assertNotEquals("3", testContact.getContactID());
	}
	
	@DisplayName("Test too long getID")
	@Test
	public void testlongGetID() {
        String contactId = "12345678910111213";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactId, firstName, lastName, phoneNumber, address);
        });
	}
	
	@DisplayName("Test an invalid null setLastName")
	@Test
	public void testBadSetLast() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName(null);
        });
	}
	
	@DisplayName("Test an invalid length setLastName")
	@Test
	public void testLongSetLast() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName("IamWayTooLongOfALastName");
        });
	}
	
	@DisplayName("Test a valid setLastName")
	@Test
	public void testGoodsetLast() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setLastName("Test");        
        assertEquals("Test", testContact.getLastName());
	}
	
	@DisplayName("Test an invalid null setPhoneNumber")
	@Test
	public void testBadSetPhone() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber(null);
        });
        
	}
	
	@DisplayName("Test an invalid length setPhoneNumber")
	@Test
	public void testWrongLengthPhone() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber("1");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber("324134151343213234");
        });
	}

	@DisplayName("Test a valid length setPhoneNumber")
	@Test
	public void testGoodPhone() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setPhoneNumber("1987654321");        
        assertEquals("1987654321", testContact.getPhoneNumber());

	}
	
	@DisplayName("Test an invalid null setAddress")
	@Test
	public void testNullSetAddress() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress(null);
        });
        
	}
	
	@DisplayName("Test an invalid length setPhoneNumber")
	@Test
	public void testWrongLengthAddress() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
              
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress("123456789 Address is way too long street");
        });
	}
	@DisplayName("Test a valid length setAddress")
	@Test
	public void testGoodAddress() {
        String contactId = "3";
      	String firstName = "Frank";
        String lastName = "Garcia";
        String phoneNumber = "9234932013";
        String address = "444 Wince Street";
		
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setAddress("123 Good Address");        
        assertEquals("123 Good Address", testContact.getAddress());

	}
	
}
