package models;

import javax.persistence.*;

@Entity
@Table(name = "adverts")
public class Advert {
    /*
    +title String
    +description String
    +category Enum(Category)
    +askingPrice int
    +deliveryOption Set<Enums>
    +id
    -POJO functions
    */

    private int id;
    private String title;
    private String description;
    private CategoryType category;
    private int askingPrice;
    private DeliveryType deliveryOption;

    public Advert(String title, String description, CategoryType category, int askingPrice, DeliveryType deliveryOption) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.askingPrice = askingPrice;
        this.deliveryOption = deliveryOption;
    }

    public Advert() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(value = EnumType.STRING)
    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    @Column(name = "asking_price")
    public int getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(int askingPrice) {
        this.askingPrice = askingPrice;
    }

    @Enumerated(value = EnumType.STRING)
    public DeliveryType getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(DeliveryType deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

}
