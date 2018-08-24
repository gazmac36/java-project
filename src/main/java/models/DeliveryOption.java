package models;

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

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
