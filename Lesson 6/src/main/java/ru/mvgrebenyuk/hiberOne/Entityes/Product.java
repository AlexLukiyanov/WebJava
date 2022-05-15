package ru.mvgrebenyuk.hiberOne.Entityes;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @ManyToMany
    @JoinTable(
            name = "buyers_and_products",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_buyer")
    )
    private List<Buyer> buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBuyer(List<Buyer> buyer) {
        this.buyer = buyer;
    }

    public List<Buyer> getBuyer() {
        return buyer;
    }

    public Product() {
    }

    public Product(Long id, String title, int price) {

    }

    @Override
    public String toString() {
        return String.format("Products [id = %d, title = %s, price = %d]", id, title, price);
    }

}
