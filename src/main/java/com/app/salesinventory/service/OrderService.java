package com.app.salesinventory.service;

import com.app.salesinventory.exception.StockNotFoundException;
import com.app.salesinventory.model.Order;
import com.app.salesinventory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }
    public Order addNewOrder(Order order) {
//        Optional<Order> orderOptional = orderRepository.findOrderById(order.getId());
//        if (orderOptional.isPresent()){
//            throw new IllegalStateException("Order already added before!");
//        }
        return orderRepository.save(order);
    }
    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }
    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id).orElseThrow(()-> new StockNotFoundException("Order by id " + id + " was not found"));
    }
    public void deleteOrder(Long id){
        orderRepository.deleteOrderById(id);
    }
}
