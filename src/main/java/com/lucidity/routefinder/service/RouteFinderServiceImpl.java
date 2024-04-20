package com.lucidity.routefinder.service;

import com.lucidity.routefinder.dto.*;
import com.lucidity.routefinder.model.GraphNode;
import com.lucidity.routefinder.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteFinderServiceImpl implements RouteFinderService {
    private final double averageSpeedOfDeliveryExecutive = 20.0;
    private double minTimeTaken = Double.MAX_VALUE;
    private List<FoodOrder> orders = new ArrayList<>();
    private Map<String, GraphNode> restaurantVsGraphNodeMap = new HashMap<>();
    private List<GraphNode> bestRoute = new ArrayList<>();

    public RouteFinderServiceImpl() {
    }

    private boolean isAllVisited(Map<GraphNode, Boolean> visited) {
        for (Map.Entry<GraphNode, Boolean> entry : visited.entrySet()) {
            if (!entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private void depthFirstSearch(double currentTime, Map<GraphNode, Boolean> visited, GraphNode root, List<GraphNode> route) {
        markNodeVisited(visited, root);
        route.add(root);
        if (isAllVisited(visited)) {
            if (currentTime < minTimeTaken) {
                minTimeTaken = currentTime;
                bestRoute = new ArrayList<>(route);
            }
        }
        for (GraphNode child : root.getChildren()) {
            if (!visited.get(child)) {
                double time1 = calculateTime(root, child);
                if (child.isRestaurant()) {
                    double time2 = Math.max(time1 + currentTime, child.getRestaurant().getAverageFoodPreparationTime());
                    depthFirstSearch(time2, visited, child, route);
                } else if (child.isConsumer()) {
                    depthFirstSearch(time1 + currentTime, visited, child, route);
                }
            }
        }
        visited.put(root, false);
        route.remove(route.size() - 1);
    }

    private void markNodeVisited(Map<GraphNode, Boolean> visited, GraphNode root) {
        if (root.isConsumer()) {
            String key = getFoodOrderByConsumerId(root.getConsumer().getId()).getRestaurant().getId();
            if (visited.get(restaurantVsGraphNodeMap.get(key))) {
                visited.put(root, true);
            }
            return;
        }
        visited.put(root, true);
    }

    private FoodOrder getFoodOrderByConsumerId(String consumerId) {
        for (FoodOrder order : orders) {
            if (order.getConsumer().getId().equals(consumerId)) {
                return order;
            }
        }
        return null;
    }

    // Method to find the best route(minimize time) to deliver a list of orders by a delivery executive
    // Return the list of addresses in the order in which the delivery executive should follow to deliver the orders in minimum time
    public Response findBestRoute(List<FoodOrder> foodOrders, DeliveryExecutive deliveryExecutive) {
        // Assume length of orders is 2
        minTimeTaken = Double.MAX_VALUE;
        orders = foodOrders;
        bestRoute = new ArrayList<>();
        restaurantVsGraphNodeMap = new HashMap<>();

        Consumer consumer1 = orders.get(0).getConsumer();
        Consumer consumer2 = orders.get(1).getConsumer();
        Restaurant restaurant1 = orders.get(0).getRestaurant();
        Restaurant restaurant2 = orders.get(1).getRestaurant();


        GraphNode root = new GraphNode(deliveryExecutive);
        GraphNode restaurantNode1 = new GraphNode(restaurant1);
        GraphNode restaurantNode2 = new GraphNode(restaurant2);
        GraphNode consumerNode1 = new GraphNode(consumer1);
        GraphNode consumerNode2 = new GraphNode(consumer2);

        root.setChildren(List.of(restaurantNode1, restaurantNode2));
        restaurantNode1.setChildren(List.of(consumerNode1, consumerNode2, restaurantNode2));
        restaurantNode2.setChildren(List.of(consumerNode2, consumerNode1, restaurantNode1));
        consumerNode1.setChildren(List.of(restaurantNode1, restaurantNode2, consumerNode2));
        consumerNode2.setChildren(List.of(restaurantNode2, restaurantNode1, consumerNode1));

        restaurantVsGraphNodeMap.put(restaurantNode1.getRestaurant().getId(), restaurantNode1);
        restaurantVsGraphNodeMap.put(restaurantNode2.getRestaurant().getId(), restaurantNode2);


        Map<GraphNode, Boolean> visited = new HashMap<>();
        visited.put(root, false);
        visited.put(restaurantNode1, false);
        visited.put(restaurantNode2, false);
        visited.put(consumerNode1, false);
        visited.put(consumerNode2, false);
        depthFirstSearch(0, visited, root, new ArrayList<>());
        return new Response(minTimeTaken, bestRoute);
    }

    private double calculateTime(GraphNode node1, GraphNode node2) {
        GeoLocation location1 = getLocation(node1);
        GeoLocation location2 = getLocation(node2);
        double distance = Math.sqrt(Math.pow(location1.getLatitude() - location2.getLatitude(), 2) + Math.pow(location1.getLongitude() - location2.getLongitude(), 2));
        return distance / averageSpeedOfDeliveryExecutive;
    }

    private GeoLocation getLocation(GraphNode node1) {
        GeoLocation location;
        if (node1.isDeliveryExecutive()) {
            location = node1.getDeliveryExecutive().getLocation();
        } else if (node1.isRestaurant()) {
            location = node1.getRestaurant().getLocation();
        } else {
            location = node1.getConsumer().getLocation();
        }
        return location;
    }
}
