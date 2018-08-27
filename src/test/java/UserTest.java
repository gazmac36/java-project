import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void before() {
        user = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
    }

    @Test
    public void userHasFirstName(){
        assertEquals("Bobby", user.getFirstName());
    }

    @Test
    public void userHasLastName(){
        assertEquals("Bobberson", user.getLastName());
    }

    @Test
    public void userHasAddressLine1(){
        assertEquals("37 Castle Terrace", user.getAddressLine1());
    }

    @Test
    public void userHasAddressLine2(){
        assertEquals("", user.getAddressLine2());
    }

    @Test
    public void userHasCity(){
        assertEquals("Edinburgh", user.getAddressCity());
    }

    @Test
    public void userHasCounty(){
        assertEquals("City of Edinburgh", user.getAddressCounty());
    }

    @Test
    public void userHasPostCode(){
        assertEquals("EH1 2EL", user.getAddressPostcode());
    }

    @Test
    public void userHasUsername(){
        assertEquals("bobobby", user.getUsername());
    }

    @Test
    public void userHasPhoneNumber(){
        assertEquals("07412312312", user.getContactPhone());
    }

    @Test
    public void userHasEmail(){
        assertEquals("bobby.bobberson@bobbysserver.co.uk", user.getContactEmail());
    }

    @Test
    public void userCanSetFirstName(){
        user.setFirstName("Something");
        assertEquals("Something", user.getFirstName());
    }

    @Test
    public void userCanSetLastName(){
        user.setLastName("Something");
        assertEquals("Something", user.getLastName());
    }


    @Test
    public void userCanSetAddressLine1(){
        user.setAddressLine1("Something");
        assertEquals("Something", user.getAddressLine1());
    }


    @Test
    public void userCanSetAddressLine2(){
        user.setAddressLine2("Something");
        assertEquals("Something", user.getAddressLine2());
    }


    @Test
    public void userCanSetCity(){
        user.setAddressCity("Something");
        assertEquals("Something", user.getAddressCity());
    }


    @Test
    public void userCanSetCounty(){
        user.setAddressCounty("Something");
        assertEquals("Something", user.getAddressCounty());
    }


    @Test
    public void userCanSetPostCode(){
        user.setAddressPostcode("Something");
        assertEquals("Something", user.getAddressPostcode());
    }


    @Test
    public void userCanSetUsername(){
        user.setUsername("Something");
        assertEquals("Something", user.getUsername());
    }


    @Test
    public void userCanSetPhoneNumber(){
        user.setContactPhone("Something");
        assertEquals("Something", user.getContactPhone());
    }


    @Test
    public void userCanSetEmail(){
        user.setContactEmail("Something");
        assertEquals("Something", user.getContactEmail());
    }



}
