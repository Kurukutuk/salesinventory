package com.app.salesinventory.controller;

import com.app.salesinventory.model.Order;
import com.app.salesinventory.model.Product;
import com.app.salesinventory.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = orderService.findAllOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id){
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order newOrder = orderService.addNewOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        Order updatedOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
