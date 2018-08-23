package db;

import models.Advert;
import models.CategoryType;
import models.DeliveryType;
import models.User;

public class Seeds {
    public static void main(String[] args) {

        User user1 = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
        User user2 = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
        DBHelper.save(user1);
        DBHelper.save(user2);

        Advert advert1 = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", CategoryType.MUSICALISNTRUMENTSANDDJEQUIPMENT, 10000, DeliveryType.PICKUP);
        Advert advert2 = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", CategoryType.MUSICALISNTRUMENTSANDDJEQUIPMENT, 10000, DeliveryType.PICKUP);
        DBHelper.save(advert1);
        DBHelper.save(advert2);
    }
}
