package com.lucidity.routefinder;

import com.lucidity.routefinder.dto.*;
import com.lucidity.routefinder.model.Response;
import com.lucidity.routefinder.service.RouteFinderService;
import com.lucidity.routefinder.service.RouteFinderServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RouteFinderApplicationTests {
	private RouteFinderService routeFinderService = new RouteFinderServiceImpl();

	@Test
	void testFindBestRouteForDifferentFoodPreparationTimeAndLowDistanceOfRestaurants() {
		List<FoodOrder> orders = getListOfOrdersForTestCase1();
		GeoLocation deliveryExecutiveLocation = new GeoLocation(0, 0);
		DeliveryExecutive deliveryExecutive = new DeliveryExecutive(deliveryExecutiveLocation);

		Response response = routeFinderService.findBestRoute(orders, deliveryExecutive);

		Assert.notNull(response, "Response object should not be null");
		assertEquals(26, response.getTimeTaken(), "Time taken should be 26");
	}

	@Test
	void testFindBestRouteForDifferentFoodPreparationTimeAndHighDistanceOfRes2() {
		List<FoodOrder> orders = getListOfOrdersForTestCase2();
		GeoLocation deliveryExecutiveLocation = new GeoLocation(0, 0);
		DeliveryExecutive deliveryExecutive = new DeliveryExecutive(deliveryExecutiveLocation);

		Response response = routeFinderService.findBestRoute(orders, deliveryExecutive);

		Assert.notNull(response, "Response object should not be null");
		assertEquals(35, response.getTimeTaken(), "Time taken should be 35");
	}

	private List<FoodOrder> getListOfOrdersForTestCase2() {
		GeoLocation consumerLocation1 = new GeoLocation(100, 0);
		GeoLocation consumerLocation2 = new GeoLocation(120, 0);
		GeoLocation restaurantLocation1 = new GeoLocation(80, 0);
		GeoLocation restaurantLocation2 = new GeoLocation(-80, 0);

		Consumer consumer1 = new Consumer("c1", "John", "Doe", "1234567890", consumerLocation1);
		Consumer consumer2 = new Consumer("c2", "Jane", "Doe", "1234567898", consumerLocation2);
		Restaurant restaurant1 = new Restaurant("r1", "Restaurant1", restaurantLocation1, "1234567891", 10.0);
		Restaurant restaurant2 = new Restaurant("r2", "Restaurant2", restaurantLocation2, "1234567892", 25.0);


		FoodOrder order1 = new FoodOrder(UUID.randomUUID().toString(), consumer1, restaurant1);
		FoodOrder order2 = new FoodOrder(UUID.randomUUID().toString(), consumer2, restaurant2);
		List<FoodOrder> orders = List.of(order1, order2);
		return orders;
	}

	private List<FoodOrder> getListOfOrdersForTestCase1() {
		GeoLocation consumerLocation1 = new GeoLocation(100, 0);
		GeoLocation consumerLocation2 = new GeoLocation(-100, 0);
		GeoLocation restaurantLocation1 = new GeoLocation(80, 0);
		GeoLocation restaurantLocation2 = new GeoLocation(-80, 0);

		Consumer consumer1 = new Consumer("c1", "John", "Doe", "1234567890", consumerLocation1);
		Consumer consumer2 = new Consumer("c2", "Jane", "Doe", "1234567898", consumerLocation2);
		Restaurant restaurant1 = new Restaurant("r1", "Restaurant1", restaurantLocation1, "1234567891", 10.0);
		Restaurant restaurant2 = new Restaurant("r2", "Restaurant2", restaurantLocation2, "1234567892", 25.0);


		FoodOrder order1 = new FoodOrder(UUID.randomUUID().toString(), consumer1, restaurant1);
		FoodOrder order2 = new FoodOrder(UUID.randomUUID().toString(), consumer2, restaurant2);
		List<FoodOrder> orders = List.of(order1, order2);
		return orders;
	}

}
