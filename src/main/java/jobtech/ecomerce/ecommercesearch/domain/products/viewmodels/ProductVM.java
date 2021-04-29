package jobtech.ecomerce.ecommercesearch.domain.products.viewmodels;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ProductVM {

    private long id;
    private String name;
    private double oldPrice;
    private double newPrice;
    private double discount;
    private double ratingsCount;
    private double ratingsValue;
    private String description;
    private int availibilityCount;
    private int cartCount;
    private long categoryId;
}
