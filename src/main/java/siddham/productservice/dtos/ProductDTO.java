package siddham.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import siddham.productservice.model.Category;

@Getter
@Setter
public class ProductDTO {
    Long id;
    String title;
    String price;
    Category category;
    String description;
    String image;
}
