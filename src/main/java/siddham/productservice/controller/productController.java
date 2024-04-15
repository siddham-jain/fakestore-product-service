package siddham.productservice.controller;
import org.springframework.web.bind.annotation.*;
import siddham.productservice.customexceptions.ProductNotFoundException;
import siddham.productservice.model.Product;
import siddham.productservice.service.SelfProductService;
import siddham.productservice.service.productService;
//import siddham.productservice.service.productServiceImplementation;
import java.util.List;
@RestController
@RequestMapping("/products")
public class productController {

    private final productService psi;

    productController(productService ps){
        this.psi = ps;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return psi.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return psi.getProductById(id);
    }

    @GetMapping("/categories")
    public List<String> getAllCategories(){
        return psi.getAllCategories();
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductByCategory(@PathVariable("category") String category){
        if(category.equals("mensclothing")){
            return psi.getProductByCategory("men's clothing");
        } else if(category.equals("womensclothing")){
            return psi.getProductByCategory("women's clothing");
            }
        return psi.getProductByCategory(category);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) throws ProductNotFoundException {
        return psi.createProduct(product);
    }

}
