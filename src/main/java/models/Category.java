package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    private int id;
    private String category;
    private Set<Advert> adverts;

    public Category(String category){
        this.category = category;
    }

    public Category() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    public Set<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(Set<Advert> adverts) {
        this.adverts = adverts;
    }
}
