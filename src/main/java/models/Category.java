package models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    private int id;
    private String category;

    public Category(String category){
        this.category = category;
    }

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
