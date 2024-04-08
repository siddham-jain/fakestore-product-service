package siddham.productservice.service;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import siddham.productservice.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import siddham.productservice.dtos.ProductDTO;
@Service
public class productServiceImplementation implements productService {
    String url = "https://fakestoreapi.com/products";
    RestTemplate restTemplate = new RestTemplate();

    public Product mapToProduct(ProductDTO productdto) {
        Product product = new Product();
        product.setId(productdto.getId());
        product.setTitle(productdto.getTitle());
        product.setPrice(productdto.getPrice());
        product.setDescription(productdto.getDescription());
        product.setCategory(productdto.getCategory());
        product.setImage(productdto.getImage());
        return product;
    }
    @Override
    public List<Product> getAllProducts() {
//        RestTemplate restTemplate = new RestTemplate();
        ProductDTO[] productsdto = restTemplate.getForObject(url, ProductDTO[].class);
        if(productsdto == null){
            System.out.println("There are no products");
            return Collections.emptyList();
        }
        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productsdto) {
            if(productDTO == null){
                System.out.println("There are no products");
                return Collections.emptyList();
            }
            Product product = mapToProduct(productDTO);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getProductById(Long id) {
//        RestTemplate restTemplate = new RestTemplate();
        ProductDTO productdto = restTemplate.getForObject(url + "/" + id, ProductDTO.class);
        if(productdto == null){
            System.out.println("There is no product with this id");
            return null;
        }
        return mapToProduct(productdto);
    }

    @Override
    public List<String> getAllCategories() {
//        RestTemplate restTemplate = new RestTemplate();
        ProductDTO[] productsdto = restTemplate.getForObject(url, ProductDTO[].class);
        if(productsdto == null){
            System.out.println("There are no products");
            return Collections.emptyList();
        }
        List<String> categories = new ArrayList<>();
        for(ProductDTO pdto : productsdto){
            if(pdto == null){
                System.out.println("There are no products");
                return Collections.emptyList();
            }
            String cat = pdto.getCategory();
            if(!categories.contains(cat)){
                categories.add(cat);
            }
        }
        return categories;
    }

    @Override
    public List<Product> getProductByCategory(String category){
//        RestTemplate restTemplate = new RestTemplate();
        ProductDTO[] pdto = restTemplate.getForObject(url, ProductDTO[].class);
        List<Product> products = new ArrayList<>();
        if(pdto == null){
            return null;
        }
        for(ProductDTO dto : pdto){
            if(dto.getCategory().equals(category)){
                products.add(mapToProduct(dto));
            }
        }
        return products;
    }

}
