package siddham.productservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siddham.productservice.model.Product;
import siddham.productservice.service.productServiceImplementation;
import java.util.List;
@RestController
@RequestMapping("/products")
public class productController {

    private productServiceImplementation psi;

    productController(productServiceImplementation productserviceimplementation){
        this.psi = productserviceimplementation;
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return psi.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return psi.getProductById(id);
    }

}
