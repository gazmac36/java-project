package db;

import models.*;

public class Seeds {
    public static void main(String[] args) {

       Category appliances = new Category("Appliances");
       Category audioStereo = new Category("Audio & Stereo");
       Category babyKidsStuff = new Category("Baby & Kids Stuff");
       Category camerasCamcordersStudio = new Category("Cameras, Camcorders & Studio");
       Category christmasDecorations= new Category("Christmas Decorations");
       Category clothesFootwearAccessories = new Category("Clothes, Footwear & Accessories");
       Category computersSoftware = new Category("Computers & Software");
       Category diyToolsMaterials= new Category("DIY Tools & Materials");
       Category healthBeauty = new Category("Health & Beauty");
       Category homeGarden = new Category("Home & Garden");
       Category houseClearance = new Category("House Clearance");
       Category musicFilmsBooksGames = new Category("Music, Films, Books & Games");
       Category musicalInstrumentsDjEquipment = new Category("Musical Instruments & Dj Equipment");
       Category officeFurnitureEquipment = new Category("Office Furniture & Equipment");
       Category phonesMobilePhonesTelecoms = new Category("Phones, Mobile Phones & Telecoms");
       Category sportsLeisureTravel= new Category("Sports, Leisure & Travel");
       Category tickets = new Category("Tickets");
       Category tvDvdBlurayVideos = new Category("TV, DVD, Blu-ray & Videos");
       Category videoGamesConsoles = new Category("Video Games & Consoles");
       Category freebies = new Category("Freebies");
       Category otherGoods= new Category("Other Goods");
       Category stuffWanted= new Category("Stuff Wanted");
       Category swapShop= new Category("Swap Shop");
        
        User user1 = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
        User user2 = new User("Bobby", "Bobberson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bobobby", "07412312312", "bobby.bobberson@bobbysserver.co.uk");
        DBHelper.save(user1);
        DBHelper.save(user2);

        Advert advert1 = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", CategoryType.MUSICALISNTRUMENTSANDDJEQUIPMENT, 10000);
        Advert advert2 = new Advert("Awesome Guitar, used by Hendrix", "Awesome guitar that Hendrix destroyed during his 1974 concert, restored to functionality", CategoryType.MUSICALISNTRUMENTSANDDJEQUIPMENT, 10000);
        DBHelper.save(advert1);
        DBHelper.save(advert2);

        advert1.addDeliveryType(DeliveryType.FIRSTCLASS);
        advert2.addDeliveryType(DeliveryType.SECONDCLASS);

        DBHelper.save(advert1);
        DBHelper.save(advert2);



    }
}
