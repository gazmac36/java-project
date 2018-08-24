package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Category category;
    private int askingPrice;
    private Set<DeliveryOption> deliveryOptions;

    public Advert(String title, String description, Category category, int askingPrice) {
        this.title = title;
        this.description = description;
        this.askingPrice = askingPrice;
        this.category = category;
        this.deliveryOptions = new HashSet<DeliveryOption>();
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

    @ManyToOne
    @JoinColumn(name = "advert_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "asking_price")
    public int getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(int askingPrice) {
        this.askingPrice = askingPrice;
    }



    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "adverts_delivery_options",
            joinColumns = {@JoinColumn(name = "advert_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "delivery_option_id", nullable = false, updatable = false)})
    public Set<DeliveryOption> getDeliveryOptions() {

        return deliveryOptions;
    }

    public void setDeliveryOptions(Set<DeliveryOption> deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }

    public void addDeliveryOption(DeliveryOption deliveryOption){
        deliveryOptions.add(deliveryOption);
    }


}
