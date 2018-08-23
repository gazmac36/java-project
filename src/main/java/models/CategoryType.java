package models;

public enum CategoryType {

    APPLIANCES("Appliances"),
    AUDIOANDSTEREO("Audio & Stereo"),
    BABYANDKIDSSTUFF("Baby & Kids Stuff"),
    CAMERASCAMCORDERSANDSTUDIO("Cameras Camcorders & Studio"),
    CHRISTMASDECORATIONS("Christmas Decorations"),
    CLOTHESFOOTWEARANDACCESSORIES("Clothes Footwear & Accessories"),
    COMPUTERSANDSOFTWARE("Computers & Software"),
    DYITOOLSANDMATERIALS("Dyi Tools & Materials"),
    HEALTHANDBEAUTY("Health & Beauty"),
    HOMEANDGARDEN("Home & Garden"),
    HOUSECLEARANCE("House Clearance"),
    MUSICFILMSBOOKSANDGAMES("Music Films Books & Games"),
    MUSICALISNTRUMENTSANDDJEQUIPMENT("Musical Instruments & Dj Equipment"),
    OFFICEFURNITUREANDEQUIPMENT("Office Furniture & Equipment"),
    PHONESMOBILEPHONESANDTELECOMS("Phones Mobile Phones & Telecoms"),
    SPORTSLEISUREANDTRAVEL("Sports Leisure & Travel"),
    TICKETS("Tickets"),
    TVDVDBLURAYANDVIDEOS("Tv Dvd Blu-ray & Videos"),
    VIDEOGAMESANDCONSOLES("Video Games & Consoles"),
    FREEBIES("Freebies"),
    OTHERGOODS("Othergoods"),
    STUFFWANTED("Stuff Wanted"),
    SWAPSHOP("Swapshop");

    CategoryType(String prettyText) {
        this.prettyText = prettyText;
    }

    private final String prettyText;

    public String getPrettyText() {
        return prettyText;
    }


}
