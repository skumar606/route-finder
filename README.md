# route-finder

## Description
This is a program that finds the best route to deliver food orders to multiple consumers by one delivery executive. The program uses depth first search algorithm to find the best route which will take minimum time to deliver all the orders.

## Setup
1. Clone the repository
2. Install Java JDK 17
3. `RouteFinderApplication` is the entry point of the application. It has main method to run the program. You can test it with multiple inputs.  

## Usage
The program takes following input:
1. List of two orders with the consumer and restaurant details
2. Delivery executive details with the current location

Pass these inputs to the bestRouteFinder function to get the best route and time to deliver all the orders.

## Data Structures
- The program uses depth first search algorithm to find the best route which will take minimum time to deliver all the orders. 
- The program uses GraphNode class to represent the nodes in the graph. The graph is represented as a list of GraphNodes.
- The program uses DeliveryExecutive, Consumer and Restaurant classes to represent the delivery executive, consumer and restaurant details.
- The program uses GeoLocation class to represent the location details.

## Design Principles Used
- **Modular and Maintainable**: The program is modular and maintainable. It has separate classes for each entity and function.
- **Inheritance**: The program uses inheritance to represent the delivery executive, consumer and restaurant details.
- **Encapsulation**: The program uses encapsulation to hide the internal details of the classes.
- **Single Responsibility Principle**: The program uses single responsibility principle to make sure that each class has only one responsibility.
- **Open Closed Principle**: The program uses open closed principle to make sure that the classes are open for extension but closed for modification.
- **Unit Testing**: The program has unit tests to test the functionality of the program.

## Example Output
```
Minimum time taken: 35.0
Best route: [GraphNode{deliveryExecutive=DeliveryExecutive{location=GeoLocation{latitude=0.0, longitude=0.0}}, restaurant=null, consumer=null}, GraphNode{deliveryExecutive=null, restaurant=Restaurant{location=GeoLocation{latitude=80.0, longitude=0.0}, name='Restaurant1', id='r1'}, consumer=null}, GraphNode{deliveryExecutive=null, restaurant=null, consumer=Consumer{id='c1', location=GeoLocation{latitude=100.0, longitude=0.0}}}, GraphNode{deliveryExecutive=null, restaurant=Restaurant{location=GeoLocation{latitude=-80.0, longitude=0.0}, name='Restaurant2', id='r2'}, consumer=null}, GraphNode{deliveryExecutive=null, restaurant=null, consumer=Consumer{id='c2', location=GeoLocation{latitude=120.0, longitude=0.0}}}]
```