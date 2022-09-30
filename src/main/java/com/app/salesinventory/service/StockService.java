package com.app.salesinventory.service;

import com.app.salesinventory.model.Product;
import com.app.salesinventory.model.Stock;
import com.app.salesinventory.model.repository.StockRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> findAllStocks() {
        return stockRepository.findAll();
    }

    public void addNewStock(Stock stock) {
        Optional<Stock> stockOptional = stockRepository.findStockById(stock.getId());
        if (stockOptional.isPresent()){
            throw new IllegalStateException("Stock already added before!");
        }
        stockRepository.save(stock);
    }
}
