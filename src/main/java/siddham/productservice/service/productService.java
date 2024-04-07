package siddham.productservice.service;
import siddham.productservice.model.Product;

import java.util.List;

public interface productService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
}
