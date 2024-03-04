package servicetests;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.ContactService;

class ContactServiceTest {
	
	@AfterEach
	void tearDown() throws Exception {
		ContactService.contactList.clear();
	}

	@DisplayName("Test addContact")
	@Test
	void testAddContact() {

		String firstName = "Frank";
		String lastName = "Garcia";
		String phoneNumber = "9234932013";
		String address = "123 Main Street";

		ContactService test = new ContactService();
         assertTrue(ContactService.contactList.isEmpty());

		test.addContact(firstName, lastName, phoneNumber, address);

		assertFalse(ContactService.contactList.isEmpty());
		
		assertEquals(0, ContactService.contactList.get(0).getContactID());
		
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		
		assertEquals(address, ContactService.contactList.get(0).getAddress());

	}
	
	@DisplayName("Test deleteContact")			  
	@Test void testDeleteContact() {
				  
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		  
		test.deleteContact("1");
		  assertEquals(2,ContactService.contactList.size());
		 
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == 1) {
				testBool = true;
			}
		}		
		assertFalse(testBool);				 
	}
	@DisplayName("Test editing a phone number")
	@Test
	void testEditPhone() {
		
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";
		  
		ContactService test = new ContactService();
		
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		
		test.editNumber("0", "1987654321");
		assertEquals("1987654321", ContactService.contactList.get(0).getPhoneNumber());
	}
	@DisplayName("Test editing a last name")
	@Test
	void testEditLast() {
		
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";
		  
		ContactService test = new ContactService();
		
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		
		test.editLastName("0", "Test_Name");
		assertEquals("Test_Name", ContactService.contactList.get(0).getLastName());
	}
	
	@DisplayName("Test editing a first name")
	@Test
	void testEditFirst() {
		
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";

		ContactService test = new ContactService();
		
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		
		test.editFirstName("0", "Test_First");
		assertEquals("Test_First", ContactService.contactList.get(0).getFirstName());
	}

	@DisplayName("Test editing an address")
	@Test
	void testEditAddress() {
		
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";

		ContactService test = new ContactService();
		
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(address, ContactService.contactList.get(0).getAddress());
		
		test.editAddress("0", "Test_Address");
		assertEquals("Test_Address", ContactService.contactList.get(0).getAddress());
	}
	

	@DisplayName("Test editing a bad address Id")
	@Test
	void testEditBadAddress() {
		
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		
		  assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		
		test.editAddress("3", "Test_Address");
		assertEquals(3,ContactService.contactList.size());
		  	 
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getAddress().equals("Test_Address")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);						

	}
	
	@DisplayName("Test editing a bad first name Id")
	@Test
	void testEditBadFirstName() {
		
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		
		test.addContact(firstName, lastName, phoneNumber, address);
		
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		
		test.editFirstName("3", "Test_Name");
		assertEquals(3,ContactService.contactList.size());
		  	 
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getFirstName().equals("Test_Name")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);			
	}

	@DisplayName("Test editing a bad last name Id")
	@Test
	void testEditBadLastName() {
		
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		
		test.editLastName("3", "Test_Name");
		
		assertEquals(3,ContactService.contactList.size());
		  	 
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getLastName().equals("Test_Name")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);			
	}
	
	@DisplayName("Test editing a bad last name Id")
	@Test
	void testEditBadNumber() {
		
		String firstName = "Frank"; 
		String lastName = "Garcia"; 
		String phoneNumber = "9234932013"; 
		String address = "444 Wince Street";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  		assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		
		test.addContact(firstName, lastName, phoneNumber, address);
		
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		
		test.editNumber("3", "9876543210");
		
		assertEquals(3,ContactService.contactList.size());
		  	 
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getPhoneNumber().equals("Test_Name")) {
				testBool = true;
			}
		}		
		assertFalse(testBool);			
	}
}

