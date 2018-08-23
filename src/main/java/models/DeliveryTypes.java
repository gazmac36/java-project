package models;

public enum DeliveryTypes {

    PICKUP("Pick-up", 0),
    FIRSTCLASSRECORDED("Signed For 1st Class", 10),
    SECONDCLASSRECORDED("Signed For 2nd Class", 7),
    FIRSTCLASS("1st Class", 5),
    SECONDCLASS("2nd Class", 3);


    DeliveryTypes(String prettyText, int cost){
        this.prettyText = prettyText;
        this.cost = cost;
    }

    private final String prettyText;
    private final int cost;

    public String getPrettyText(){
        return prettyText;
    }

    public int getCost(){
        return cost;
    }

}
