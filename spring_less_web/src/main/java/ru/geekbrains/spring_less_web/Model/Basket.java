package ru.geekbrains.spring_less_web.Model;

public class Basket {

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

    public Basket(Long id, String name, Long cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Basket() {
    }
}

