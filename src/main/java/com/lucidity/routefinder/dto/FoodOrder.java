package com.lucidity.routefinder.dto;

public class FoodOrder {
    private String orderId;
    private Consumer consumer;
    private Restaurant restaurant;

    public FoodOrder(String orderId, Consumer consumer, Restaurant restaurant) {
        this.orderId = orderId;
        this.consumer = consumer;
        this.restaurant = restaurant;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
