package ru.geekbrains.less2.Module;

public class Product {

    private String title;

    private Long id;

    private int cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Product(String title, Long id, int cost) {
        this.title = title;
        this.id = id;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", cost=" + cost +
                '}';
    }
}
