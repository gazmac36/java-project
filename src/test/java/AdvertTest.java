import models.Advert;
import models.CategoryType;
import models.DeliveryOption;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvertTest {
    private Advert advert;
    DeliveryOption firstClassRecorded;

    @Before
    public void before(){
        advert = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", CategoryType.MUSICALISNTRUMENTSANDDJEQUIPMENT, 10000);
        firstClassRecorded = new DeliveryOption("Signed for 1st Class", 10);

    }

    @Test
    public void advertHasTitle(){
        assertEquals("Awesome Guitar, used by Hendrix", advert.getTitle());
    }

    @Test
    public void advertHasDescription(){
        assertEquals("Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", advert.getDescription());
    }

    @Test
    public void advertHasCategory(){
        assertEquals(CategoryType.MUSICALISNTRUMENTSANDDJEQUIPMENT, advert.getCategory());
    }

    @Test
    public void advertHasAskingPrice(){
        assertEquals(10000, advert.getAskingPrice());
    }

    @Test
    public void advertHasDeliveryOption(){
        advert.addDeliveryOption(firstClassRecorded);
        assertEquals(1, advert.getDeliveryOptions().size());
    }

    @Test
    public void advertCanSetTitle(){
        advert.setTitle("Something");
        assertEquals("Something", advert.getTitle());
    }

    @Test
    public void advertCanSetDescription(){
        advert.setDescription("Something");
        assertEquals("Something", advert.getDescription());
    }

    @Test
    public void advertCanSetCategory(){
        advert.setCategory(CategoryType.APPLIANCES);
        assertEquals(CategoryType.APPLIANCES, advert.getCategory());
    }

    @Test
    public void advertCanSetAskingPrice(){
        advert.setAskingPrice(1);
        assertEquals(1, advert.getAskingPrice());
    }

    @Test
    public void advertCanSetDeliveryOption(){
        advert.addDeliveryOption(firstClassRecorded);
        assertEquals(1, advert.getDeliveryOptions().size());
    }




}
