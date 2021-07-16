package com.example.javaspringws.service;

import com.example.javaspringws.entity.Product;
import com.example.javaspringws.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@Component(value = "productService")
@WebService
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @WebMethod
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @WebMethod
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @WebMethod
    public Boolean sellProduct(int productId, int quantity) {
        Optional<Product> existProduct = productRepository.findById(productId);
        if (!existProduct.isPresent()) {
            return false;
        }

        try {
            Product currentProduct = existProduct.get();
            currentProduct.setQuantity(quantity);
            productRepository.save(currentProduct);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
