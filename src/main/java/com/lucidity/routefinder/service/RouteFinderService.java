package com.lucidity.routefinder.service;

import com.lucidity.routefinder.dto.DeliveryExecutive;
import com.lucidity.routefinder.dto.FoodOrder;
import com.lucidity.routefinder.model.Response;

import java.util.List;

public interface RouteFinderService {

    Response findBestRoute(List<FoodOrder> orders, DeliveryExecutive deliveryExecutive);


}
