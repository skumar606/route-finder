package com.lucidity.routefinder.model;

import java.util.List;

public class Response {

    private double timeTaken;
    private List<GraphNode> bestRoute;

    public Response(double timeTaken, List<GraphNode> bestRoute) {
        this.timeTaken = timeTaken;
        this.bestRoute = bestRoute;
    }

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public List<GraphNode> getBestRoute() {
        return bestRoute;
    }

    public void setBestRoute(List<GraphNode> bestRoute) {
        this.bestRoute = bestRoute;
    }
}
