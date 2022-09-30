package com.app.salesinventory.service;

import com.app.salesinventory.exception.StockNotFoundException;
import com.app.salesinventory.model.Stock;
import com.app.salesinventory.model.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockService {
    @Autowired
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> findAllStocks() {
        return stockRepository.findAll();
    }
    public Stock addNewStock(Stock stock) {
        Optional<Stock> stockOptional = stockRepository.findStockById(stock.getId());
        if (stockOptional.isPresent()){
            throw new IllegalStateException("Stock already added before!");
        }
        return stockRepository.save(stock);
    }
    public Stock updateStock(Stock stock){
        return stockRepository.save(stock);
    }
    public Stock findStockById(Long id) {
        return stockRepository.findStockById(id).orElseThrow(()-> new StockNotFoundException("Stock by id " + id + " was not found"));
    }
    public void deleteStock(Long id){
        stockRepository.deleteStockById(id);
    }
}
