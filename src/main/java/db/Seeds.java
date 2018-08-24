package db;

import models.*;

public class Seeds {
    public static void main(String[] args) {

        User user1 = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
        User user2 = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
        DBHelper.save(user1);
        DBHelper.save(user2);

        DeliveryOption pickup = new DeliveryOption("Pick-up", 0);
        DeliveryOption firstClassRecorded = new DeliveryOption("Signed for 1st Class", 10);
        DeliveryOption secondClassRecorded = new DeliveryOption("Signed for 2nd Class", 7);
        DeliveryOption firstClass = new DeliveryOption("1st Class", 5);
        DeliveryOption secondClass = new DeliveryOption("2nd Class", 3);
        DBHelper.save(pickup);
        DBHelper.save(firstClassRecorded);
        DBHelper.save(secondClassRecorded);
        DBHelper.save(firstClass);
        DBHelper.save(secondClass);

        Advert advert1 = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", CategoryType.MUSICALISNTRUMENTSANDDJEQUIPMENT, 10000);
        Advert advert2 = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", CategoryType.MUSICALISNTRUMENTSANDDJEQUIPMENT, 10000);
        DBHelper.save(advert1);
        DBHelper.save(advert2);

        advert1.addDeliveryOption(pickup);
        advert2.addDeliveryOption(pickup);

        DBHelper.save(advert1);
        DBHelper.save(advert2);

        DBAdvert.addDeliveryOptionToAdvert(advert1,firstClassRecorded);


    }
}
