package com.app.salesinventory.controller;

import com.app.salesinventory.model.Stock;
import com.app.salesinventory.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stocks")
public class StockController {
    @Autowired
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAllStocks(){
        List<Stock> stocks = stockService.findAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") Long id){
        Stock stock = stockService.findStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        Stock newStock = stockService.addNewStock(stock);
        return new ResponseEntity<>(newStock, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock){
        Stock updatedStock = stockService.updateStock(stock);
        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStockById(@PathVariable("id") Long id){
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
