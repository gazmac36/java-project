import models.DeliveryOption;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeliveryOptionTest {
    DeliveryOption deliveryOption;

    @Before
    public void before(){
        deliveryOption = new DeliveryOption("Signed for first class", 10);
    }

    @Test
    public void hasTitle(){
        assertEquals("Signed for first class",deliveryOption.getTitle());
    }

    @Test
    public void hasPrice(){
        assertEquals(10, deliveryOption.getPrice());
    }
}
