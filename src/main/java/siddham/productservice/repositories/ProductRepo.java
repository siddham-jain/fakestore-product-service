package siddham.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siddham.productservice.model.Product;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);
    @Override
    Product save(Product product);

}
