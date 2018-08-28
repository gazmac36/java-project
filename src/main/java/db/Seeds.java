package db;

import models.*;

public class Seeds {

    public static void seedData(){

        Category appliances = new Category("Appliances");
        Category audioStereo = new Category("Audio & Stereo");
        Category babyKidsStuff = new Category("Baby & Kids Stuff");
        Category camerasCamcordersStudio = new Category("Cameras, Camcorders & Studio");
        Category christmasDecorations = new Category("Christmas Decorations");
        Category clothesFootwearAccessories = new Category("Clothes, Footwear & Accessories");
        Category computersSoftware = new Category("Computers & Software");
        Category diyToolsMaterials = new Category("DIY Tools & Materials");
        Category healthBeauty = new Category("Health & Beauty");
        Category homeGarden = new Category("Home & Garden");
        Category houseClearance = new Category("House Clearance");
        Category musicFilmsBooksGames = new Category("Music, Films, Books & Games");
        Category musicalInstrumentsDjEquipment = new Category("Musical Instruments & Dj Equipment");
        Category officeFurnitureEquipment = new Category("Office Furniture & Equipment");
        Category phonesMobilePhonesTelecoms = new Category("Phones, Mobile Phones & Telecoms");
        Category sportsLeisureTravel = new Category("Sports, Leisure & Travel");
        Category tickets = new Category("Tickets");
        Category tvDvdBlurayVideos = new Category("TV, DVD, Blu-ray & Videos");
        Category videoGamesConsoles = new Category("Video Games & Consoles");
        Category freebies = new Category("Freebies");
        Category otherGoods = new Category("Other Goods");
        Category stuffWanted = new Category("Stuff Wanted");
        Category swapShop = new Category("Swap Shop");
        Category toys = new Category("Toys");
        toys.setArchived(true);

        DBHelper.save(audioStereo);
        DBHelper.save(babyKidsStuff);
        DBHelper.save(camerasCamcordersStudio);
        DBHelper.save(christmasDecorations);
        DBHelper.save(clothesFootwearAccessories);
        DBHelper.save(computersSoftware);
        DBHelper.save(diyToolsMaterials);
        DBHelper.save(healthBeauty);
        DBHelper.save(homeGarden);
        DBHelper.save(houseClearance);
        DBHelper.save(musicFilmsBooksGames);
        DBHelper.save(musicalInstrumentsDjEquipment);
        DBHelper.save(officeFurnitureEquipment);
        DBHelper.save(phonesMobilePhonesTelecoms);
        DBHelper.save(sportsLeisureTravel);
        DBHelper.save(tickets);
        DBHelper.save(tvDvdBlurayVideos);
        DBHelper.save(freebies);
        DBHelper.save(otherGoods);
        DBHelper.save(stuffWanted);
        DBHelper.save(swapShop);
        DBHelper.save(toys);

        User user1 = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
        User user2 = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
        user2.setArchived(true);
        DBHelper.save(user1);
        DBHelper.save(user2);

        DeliveryOption pickup = new DeliveryOption("Pick-up", 0);
        DeliveryOption firstClassRecorded = new DeliveryOption("Signed for 1st Class", 10);
        DeliveryOption secondClassRecorded = new DeliveryOption("Signed for 2nd Class", 7);
        DeliveryOption firstClass = new DeliveryOption("1st Class", 5);
        DeliveryOption secondClass = new DeliveryOption("2nd Class", 3);
        DeliveryOption carrierPidgeon = new DeliveryOption("Carrier pidgeon", 2);
        carrierPidgeon.setArchived(true);
        DBHelper.save(pickup);
        DBHelper.save(firstClassRecorded);
        DBHelper.save(secondClassRecorded);
        DBHelper.save(firstClass);
        DBHelper.save(secondClass);
        DBHelper.save(carrierPidgeon);

        Advert advert1 = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", musicalInstrumentsDjEquipment, 10000);
        Advert advert2 = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", musicalInstrumentsDjEquipment, 10000);
        DBHelper.save(advert1);
        advert2.setArchived(true);
        DBHelper.save(advert2);

        advert1.addDeliveryOption(pickup);
        advert2.addDeliveryOption(pickup);
        advert2.addDeliveryOption(carrierPidgeon);


        DBHelper.save(advert1);
        DBHelper.save(advert2);

        DBAdvert.addDeliveryOptionToAdvert(advert1, firstClassRecorded);

    }
}
