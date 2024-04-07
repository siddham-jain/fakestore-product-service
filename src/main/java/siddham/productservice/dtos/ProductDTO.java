package siddham.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    Long id;
    String title;
    String price;
    String category;
    String description;
    String image;
}
