package com.lucidity.routefinder.model;

import com.lucidity.routefinder.dto.Consumer;
import com.lucidity.routefinder.dto.DeliveryExecutive;
import com.lucidity.routefinder.dto.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    private boolean isDeliveryExecutive;
    private DeliveryExecutive deliveryExecutive;
    private boolean isRestaurant;
    private Restaurant restaurant;
    private boolean isConsumer;
    private Consumer consumer;
    private List<GraphNode> children;

    public GraphNode(boolean isDeliveryExecutive, DeliveryExecutive deliveryExecutive, boolean isRestaurant, Restaurant restaurant, boolean isConsumer, Consumer consumer) {
        this.isDeliveryExecutive = isDeliveryExecutive;
        this.deliveryExecutive = deliveryExecutive;
        this.isRestaurant = isRestaurant;
        this.restaurant = restaurant;
        this.isConsumer = isConsumer;
        this.consumer = consumer;
    }

    // constructor for delivery executive
    public GraphNode(DeliveryExecutive deliveryExecutive) {
        this.isDeliveryExecutive = true;
        this.deliveryExecutive = deliveryExecutive;
        this.children = new ArrayList<>();
    }

    // constructor for restaurant
    public GraphNode(Restaurant restaurant) {
        this.isRestaurant = true;
        this.restaurant = restaurant;
        this.children = new ArrayList<>();
    }

    // constructor for consumer
    public GraphNode(Consumer consumer) {
        this.isConsumer = true;
        this.consumer = consumer;
        this.children = new ArrayList<>();
    }

    public boolean isDeliveryExecutive() {
        return isDeliveryExecutive;
    }

    public void setDeliveryExecutive(boolean deliveryExecutive) {
        isDeliveryExecutive = deliveryExecutive;
    }

    public DeliveryExecutive getDeliveryExecutive() {
        return deliveryExecutive;
    }

    public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        this.deliveryExecutive = deliveryExecutive;
    }

    public boolean isRestaurant() {
        return isRestaurant;
    }

    public void setRestaurant(boolean restaurant) {
        isRestaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isConsumer() {
        return isConsumer;
    }

    public void setConsumer(boolean consumer) {
        isConsumer = consumer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public List<GraphNode> getChildren() {
        return children;
    }

    public void setChildren(List<GraphNode> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return "GraphNode{" +
                "deliveryExecutive=" + deliveryExecutive +
                ", restaurant=" + restaurant +
                ", consumer=" + consumer +
                '}';
    }
}
