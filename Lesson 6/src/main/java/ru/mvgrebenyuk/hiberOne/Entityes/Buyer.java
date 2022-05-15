package ru.mvgrebenyuk.hiberOne.Entityes;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Table(name = "buyers")
    public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "buyers_and_products",
            joinColumns = @JoinColumn(name = "id_buyer"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private List<Product> product;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Buyer() {
    }

    @Override
    public String toString() {
        return String.format("Buyers [id = %d, name = %s]", id, name);
    }
}
