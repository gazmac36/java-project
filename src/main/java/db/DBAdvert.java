package db;

import models.Advert;
import models.DeliveryOption;

public class DBAdvert {
    public static void addDeliveryOptionToAdvert(Advert advert, DeliveryOption deliveryOption){
        advert.addDeliveryOption(deliveryOption);
        DBHelper.save(advert);
    }
}
