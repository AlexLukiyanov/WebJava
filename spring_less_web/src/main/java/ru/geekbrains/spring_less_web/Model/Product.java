package ru.geekbrains.spring_less_web.Model;

public class Product {

    private Long id;

    private String name;

    private Long cost;

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

    public void getCost() {
        this.cost = cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Product(Long id, String name, Long cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Product() {
    }
}
