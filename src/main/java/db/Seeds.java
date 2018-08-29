package db;

import models.*;

public class Seeds {

    public static void seedData() {

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
        Category tvDvdBlurayVideos = new Category("TV, DVD, Blu-ray & Videos");
        Category videoGamesConsoles = new Category("Video Games & Consoles");
        Category otherGoods = new Category("Other Goods");
        Category stuffWanted = new Category("Stuff Wanted");
        Category freebies = new Category("Freebies");
        Category swapShop = new Category("Swap Shop");
        Category tickets = new Category("Tickets");
        Category toys = new Category("Toys");
        tickets.setArchived(true);
        freebies.setArchived(true);
        stuffWanted.setArchived(true);
        swapShop.setArchived(true);
        toys.setArchived(true);

        DBHelper.save(appliances);
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
        DBHelper.save(videoGamesConsoles);
        DBHelper.save(freebies);
        DBHelper.save(otherGoods);
        DBHelper.save(stuffWanted);
        DBHelper.save(swapShop);
        DBHelper.save(toys);

        User user1 = new User("Ricardo", "Ruiz", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "rruiz", "07412334523", "r.ruiz@codeclan.co.uk");
        User user2 = new User("Garry", "McCrum", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "gmcrum", "07412334523", "g.mcrum@codeclan.co.uk");
        User user3 = new User("Beata", "Ficek", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "bficek", "07412334523", "b.ficek@codeclan.co.uk");
        User user4 = new User("Digory", "Philbrow", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "dphilbrow", "07412334523", "d.philbrow@codeclan.co.uk");
        User user5 = new User("Emil", "Vaklinov", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "evaklinov", "07412334523", "e.vaklinov@codeclan.co.uk");
        User user6 = new User("Euan", "Cunningham", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "ecunningham", "07412334523", "e.cunningham@codeclan.co.uk");
        User user7 = new User("Gemma", "Percival", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "gpercival", "07412334523", "g.percival@codeclan.co.uk");
        User user8 = new User("Joanna", "Gora", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "jgora", "07412334523", "j.gora@codeclan.co.uk");
        User user9 = new User("Kirstin", "Ryan", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "kryan", "07412334523", "k.ryan@codeclan.co.uk");
        User user10 = new User("Marcin", "Jerwan", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "mjerwan", "07412334523", "m.jerwan@codeclan.co.uk");
        User user11 = new User("Mark", "Ditzel", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "mditzel", "07412334523", "m.ditzel@codeclan.co.uk");
        User user12 = new User("Melinda", "Matthews", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "mmatthrews", "07412334523", "m.matthews@codeclan.co.uk");
        User user13 = new User("Mike", "Thorpe", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "mthorpe", "07412334523", "m.thorpe@codeclan.co.uk");
        User user14 = new User("Molly", "Drumm", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "mdrumm", "07412334523", "m.drumm@codeclan.co.uk");
        User user15 = new User("Patrycja", "Graczyk", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "pgraczyk", "07412334523", "p.graczyk@codeclan.co.uk");
        User user16 = new User("Raphael", "Ugha", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "rugha", "07412334523", "r.ugha@codeclan.co.uk");
        User user17 = new User("Robbie", "Dumbrell", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "rdumbrell", "07412334523", "r.dumbrell@codeclan.co.uk");
        User user18 = new User("Stuart", "Black", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "sblack", "07412334523", "s.black@codeclan.co.uk");
        User user19 = new User("Tahnee", "Downie", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "tdownie", "07412334523", "t.downie@codeclan.co.uk");
        User user20 = new User("Vicky", "Jackson", "37 Castle Terrace", "", "Edinburgh", "City of Edinburgh", "EH1 2EL", "vjackson", "07412334523", "v.jackson@codeclan.co.uk");
        DBHelper.save(user1);
        DBHelper.save(user2);
        DBHelper.save(user3);
        DBHelper.save(user4);
        DBHelper.save(user5);
        DBHelper.save(user6);
        DBHelper.save(user7);
        DBHelper.save(user8);
        DBHelper.save(user9);
        DBHelper.save(user10);
        DBHelper.save(user11);
        DBHelper.save(user12);
        DBHelper.save(user13);
        DBHelper.save(user14);
        DBHelper.save(user15);
        DBHelper.save(user16);
        DBHelper.save(user17);
        DBHelper.save(user18);
        DBHelper.save(user19);
        DBHelper.save(user20);


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

        Advert advert1 = new Advert("Whirlpool freezer", "It has 3 drawers, 1 has a crack at the front but still works", appliances, 40);
        Advert advert2 = new Advert("Creada Gas Double Oven", "In fully working order and good condition, has crack on top handle but that doesn't affect usage", appliances, 40);
        Advert advert3 = new Advert("SONY MINI DUAL (BLUETOOTH+NFC)", "A Sony Mini Dual Speaker which works on both NFC and Bluetooth which is in Excellent Condition is available for sale. Charger included", audioStereo, 90);
        Advert advert4 = new Advert("BOSE 10.2 floor standing speakers, VERY RARE", "Very rare bose 10.2 speakers, 1984, these are the best sounding speakers I've heard in my life nothing ever comes close", audioStereo, 350);
        Advert advert5 = new Advert("Chad Valley Indoor Trampoline", "Pink indoor trampoline, just over a year old", babyKidsStuff, 15);
        Advert advert6 = new Advert("Children's seats", "Two bright plastic children's stools for sale", babyKidsStuff, 5);
        Advert advert7 = new Advert("Canon 18-55 lens", "Canon 18-55mm lens IS II. Good condition, not used, no scratches", camerasCamcordersStudio, 50);
        Advert advert8 = new Advert("GoPro Silver Hero 4", "GoPro Hero Silver edition for sale. 2 years old but in excellent condition", camerasCamcordersStudio, 120);
        Advert advert9 = new Advert("Christmas Tree", "Comes with lights, bobbles, tinsel and star topper.", christmasDecorations, 30);
        Advert advert10 = new Advert("Wee pouch of kindness", "These beautiful boxed handmade keepsakes are the perfect gift to let someone know you're thinking about them", christmasDecorations, 4);
        Advert advert11 = new Advert("Red dress size 14", "Red dress used but still Good condition size 14", clothesFootwearAccessories, 10);
        Advert advert12 = new Advert("New Look size 14 jacket", "Maternity Jacket New Look size 14 used but in Good condition", clothesFootwearAccessories, 15);
        Advert advert13 = new Advert("Acer ES15 Aspire 15.6 inch screen laptop", "Laptop hardly used and immaculate. Currently retailing at Argos for £249.00. Windows 10. Cash Only, pickup 5 minutes from Portobello, no PayPal, posting etc,", computersSoftware, 170);
        Advert advert14 = new Advert("Targus laptop backpack", "Used but in good overall condition. Fits laptops up to 15 inches and has various storage compartments", computersSoftware, 10);
        Advert advert15 = new Advert("22 pure white large marble tiles", "22 pure white marble tiles. Offers. Please contact Andy on 07434534534 need gone ASAP", diyToolsMaterials, 10);
        Advert advert16 = new Advert("Joints nail/toobelt", "Joints nail and tool belt, only used once, excellent condition", diyToolsMaterials, 5);
        Advert advert17 = new Advert("Mobility scooter", "Mobility Scooter for sale, in fully working order. New batteries, free delivery in Edinburgh available", healthBeauty, 175);
        Advert advert18 = new Advert("Medical Pharmacy Refrigerator Lec+ PE109", "Medical Pharmacy Refrigerator Lec+ PE109 with precise digital temperature control, display and logging. The fridge has an internal blower which circulates cool air, insuring consistent temperature and speedy cooling throughout.", healthBeauty, 250);
        Advert advert19 = new Advert("Glass table", "Need gone ASAP", homeGarden, 30);
        Advert advert20 = new Advert("Tall Solid Pine Mirror - Excellent condition!", "Hey, selling my solid pine mirror. It's 40cm wide and 160cm tall. No cracks or scratches", homeGarden, 10);
        Advert advert21 = new Advert("Nearly brand new joie baby car seat used only once", "Retail price is £150, perfect condition, used once.", houseClearance, 90);
        Advert advert22 = new Advert("Bright Led Open Sign perfect for shops", "Super bright led open sign and has chain so you can hang it anywhere. Blue led moves around the red open part so it catches the eye from afar.", houseClearance, 25);
        Advert advert23 = new Advert("Garden Plants Encyclopedia", "A-Z Encyclopedia of garden plantes, personal collection from Portobello, Editor Christopher Brickell", musicFilmsBooksGames, 30);
        Advert advert24 = new Advert("Southpark 17", "Southpark season 17 for sale cheap price must go today collection only", musicFilmsBooksGames, 5);
        Advert advert25 = new Advert("Ashdown Bass Amp Combo £180", "Used Ashdown Evo ii 500 bass amp C115, 1x15 speaker", musicalInstrumentsDjEquipment, 180);
        Advert advert26 = new Advert("Danelectro Hodad Electric guitar - metallic red", "Great condition and versatile. Coil tao 'Lipstick' humbuckers. Very light guitar and well made/easy to play and tune", musicalInstrumentsDjEquipment, 215);
        Advert advert27 = new Advert("Computer chair", "Selling used computer/office chair, nice and comfortable, in a very good condition", officeFurnitureEquipment, 20);
        Advert advert28 = new Advert("Ikea Kallax Unit no55", "Some surface damage on one side, apart form that in solid and sturdy condition and structurally sound Wx 185cm, Dx 40cm, Hx 185cm", officeFurnitureEquipment, 45);
        Advert advert29 = new Advert("Origami rose Gift Box", "Origami roses box, a special gift for a loved person", otherGoods, 20);
        Advert advert30 = new Advert("Airspeed meter", "Listing is for perfect condition and new Airspeed meter, thanks for watching!", otherGoods, 25);
        Advert advert31 = new Advert("Samsung Galaxy A3 2016 Unlocked", "Samsung Galaxy A3 2015 Unlocked on all networks ", phonesMobilePhonesTelecoms, 84.99);
        Advert advert32 = new Advert("Apple Watch Nike edition Series 3 non cellular", "For sale is my Nike edition series 3 Apple Watch in Black. It’s 42mm and is the non cellular version. Used daily. It comes boxed with the charger.", phonesMobilePhonesTelecoms, 250);
        Advert advert33 = new Advert("Scott MX2 aluminium frame bike", "24 speed, 18 inch aluminium frame, 26 inch rims, ready to go", sportsLeisureTravel, 79);
        Advert advert34 = new Advert("Boys bike", "Bmx style bike suitable 5 to 7 year olds. It's an Apollo ACE bike which was brought at halfords.", sportsLeisureTravel, 15);
        Advert advert35 = new Advert("Coffee table/ Tv stand", "Good condition . Nice and clean. Some scratches on top Coffee table/ Tv stand . ", tvDvdBlurayVideos, 20);
        Advert advert36 = new Advert("50” Panasonic TX-P50G20B TV", "Panasonic TX-P50G20B 50-inch Widescreen Full HD 1080p 600Hz Neo Plasma TV with Freeview HD and Freesat HD plus remote, has a faint line running across screen (see photos). Buyer collects", tvDvdBlurayVideos, 200);
        Advert advert37 = new Advert("Defective playstation 3", "Defective PlayStation 3. Won't Power up. Spares or repair.... .. . . . . . .Pick up only", videoGamesConsoles, 5);
        Advert advert38 = new Advert("ps3 160gb playstation slim", "for sale is my ps3 works 100% no faults, 160gb hard drive and its the slim model. comes with 1 control and power cable. has 5 games on hard drive batman Arkham origins, fifa 14, gta 5, need for speed most wanted, pes 2014, ufc 3 and watch dog. has one game on disk mtx reflex. all games are free you dont have to pay for them.", videoGamesConsoles, 100);


        DBHelper.save(advert1);
        DBHelper.save(advert2);
        DBHelper.save(advert3);
        DBHelper.save(advert4);
        DBHelper.save(advert5);
        DBHelper.save(advert6);
        DBHelper.save(advert7);
        DBHelper.save(advert8);
        DBHelper.save(advert9);
        DBHelper.save(advert10);
        DBHelper.save(advert11);
        DBHelper.save(advert12);
        DBHelper.save(advert13);
        DBHelper.save(advert14);
        DBHelper.save(advert15);
        DBHelper.save(advert16);
        DBHelper.save(advert17);
        DBHelper.save(advert18);
        DBHelper.save(advert19);
        DBHelper.save(advert20);
        DBHelper.save(advert21);
        DBHelper.save(advert22);
        DBHelper.save(advert23);
        DBHelper.save(advert24);
        DBHelper.save(advert25);
        DBHelper.save(advert26);
        DBHelper.save(advert27);
        DBHelper.save(advert28);
        DBHelper.save(advert29);
        DBHelper.save(advert30);
        DBHelper.save(advert31);
        DBHelper.save(advert32);
        DBHelper.save(advert33);
        DBHelper.save(advert34);
        DBHelper.save(advert35);
        DBHelper.save(advert36);

        advert1.addDeliveryOption(pickup);
        advert2.addDeliveryOption(pickup);
        advert2.addDeliveryOption(carrierPidgeon);


        DBHelper.save(advert1);
        DBHelper.save(advert2);

        DBAdvert.addDeliveryOptionToAdvert(advert1, firstClassRecorded);

    }
}
