package siddham.productservice.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import siddham.productservice.model.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{
    @Override
    Category save(Category category);
}
