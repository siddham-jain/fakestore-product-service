package siddham.productservice.customexceptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception{
    private long id;
    public ProductNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
}
