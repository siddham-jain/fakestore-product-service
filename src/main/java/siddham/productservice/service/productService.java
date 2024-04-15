package siddham.productservice.service;
import jdk.jfr.Category;
import siddham.productservice.customexceptions.ProductNotFoundException;
import siddham.productservice.model.Product;

import java.util.List;

public interface productService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id) throws ProductNotFoundException;
    public List<String> getAllCategories();
    public List<Product> getProductByCategory(String Category);
    public Product createProduct(Product product) throws ProductNotFoundException;
}
