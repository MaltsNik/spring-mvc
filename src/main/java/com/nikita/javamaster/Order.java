package com.nikita.javamaster;

import lombok.*;

import java.util.Objects;


public class Order {
    private String title;
    private Integer price;

    public Order() {
    }

    public Order(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(title, order.title) && Objects.equals(price, order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
