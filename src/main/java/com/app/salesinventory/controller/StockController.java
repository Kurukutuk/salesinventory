package com.app.salesinventory.controller;

import com.app.salesinventory.model.Product;
import com.app.salesinventory.model.Stock;
import com.app.salesinventory.service.StockService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping(path = "api/v1/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/getStocks")
    private List<Stock> getStocks() {
        List<Stock> allStocks = stockService.findAllStocks();
        return allStocks;
    }

    @PostMapping("/addStocks")
    public void registerNewStudent(@RequestBody Stock stock){
        stockService.addNewStock(stock);
    }
}
