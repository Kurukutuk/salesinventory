package com.app.salesinventory.service;

import com.app.salesinventory.exception.StockNotFoundException;
import com.app.salesinventory.model.Product;
import com.app.salesinventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
    public Product addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductById(product.getId());
        if (productOptional.isPresent()){
            throw new IllegalStateException("Product already added before!");
        }
        return productRepository.save(product);
    }
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
    public Product findProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(()-> new StockNotFoundException("Product by id " + id + " was not found"));
    }
    public void deleteProduct(Long id){
        productRepository.deleteProductById(id);
    }
}
