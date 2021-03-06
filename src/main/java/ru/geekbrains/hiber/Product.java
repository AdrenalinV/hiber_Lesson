package ru.geekbrains.hiber;

import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="title")
    private String title;
    @Column(name="cost")
    private double cost;

    public Product() {
    }

    public Product(String title, double cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product(long id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Product [" +
                "id=" + id + '\t'+
                "title='" + title + '\t' +
                "cost=" + cost +
                ']';
    }
}
