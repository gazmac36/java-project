import models.Advert;
import models.Category;
import models.DeliveryOption;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvertTest {
    private Advert advert;
    private Category category;
    private Category category2;
    DeliveryOption firstClassRecorded;

    @Before
    public void before(){
        category = new Category("Musical Instruments & Dj Equipment");
        advert = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", category, 10000);
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
        assertEquals(category, advert.getCategory());
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
        category2 = new Category("");
        advert.setCategory(category2);
        assertEquals(category2, advert.getCategory());
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
