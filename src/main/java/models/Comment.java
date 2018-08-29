package models;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    Advert advert;
    String body;
    int id;

    public Comment(Advert advert, String body) {
        this.advert = advert;
        this.body = body;
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

    public Comment() {
    }

    @ManyToOne
    @JoinColumn(name = "advert_id", nullable = false)
    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
