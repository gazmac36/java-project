package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "delivery_options")
public class DeliveryOption {

    /*
    +title String
    +price int
    +id int
     */

    private int id;
    private String title;
    private int price;
    private Set<Advert> adverts;


    public DeliveryOption(String title, int price) {
        this.title = title;
        this.price = price;
        this.adverts = new HashSet<Advert>();
    }

    public DeliveryOption() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "adverts_delivery_options",
            joinColumns = {@JoinColumn(name = "delivery_option_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "advert_id", nullable = false, updatable = false)})
    public Set<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(Set<Advert> adverts) {
        this.adverts = adverts;
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

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addAdvert(Advert advert){
        this.adverts.add(advert);
    }
}
