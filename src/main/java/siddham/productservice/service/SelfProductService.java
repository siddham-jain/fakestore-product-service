package siddham.productservice.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import siddham.productservice.customexceptions.ProductNotFoundException;
import siddham.productservice.model.Category;
import siddham.productservice.model.Product;
import siddham.productservice.repositories.CategoryRepo;
import siddham.productservice.repositories.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements productService{
    ProductRepo productRepo;
    CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> op = productRepo.findById(id);
        if (op.isEmpty()) throw new ProductNotFoundException(id, "Product not found");
        return op.get();
    }

    @Override
    public Product createProduct(Product product) throws ProductNotFoundException {
        Category category = product.getCategory();
        if(category.getId() == null){
            Category newCategory = categoryRepo.save(category);
            product.setCategory(newCategory);
        }

        Product product1 = productRepo.save(product);
        Optional<Category> optionalCategory = categoryRepo.findById(category.getId());
        if (optionalCategory.isEmpty()) {
            //The category that is passed in the input product in invalid.
            throw new ProductNotFoundException((long)0, "Invalid category id passed");
        }
        return product1;
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public List<Product> getProductByCategory(String Category) {
        return null;
    }
}
