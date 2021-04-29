package jobtech.ecomerce.ecommercesearch.domain.products.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jobtech.ecomerce.ecommercesearch.domain.base.entities.BaseEntity;
import jobtech.ecomerce.ecommercesearch.domain.base.entities.Image;
import jobtech.ecomerce.ecommercesearch.domain.base.entities.Review;
import jobtech.ecomerce.ecommercesearch.domain.base.entities.Tag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
@RequiredArgsConstructor
@Document(indexName = "ecm-product", type = "Product")
public class Product extends BaseEntity  {

    @Id
    private long id;

    private String sku;

    private String name;

    private String longName;

    private float price;

    private String description;

    private String longDescription;

    private String additionalInformation;

    private double oldPrice;

    private double discount;

    private double ratingsCount;

    private double ratingsValue;

    private int availability;

    private int cartCount;

    private boolean inOffer;

    private List<ExtraDetail> extraDetails = new ArrayList<>();

    @Setter(value = AccessLevel.NONE)
    private List<Review> reviews = new ArrayList<>();

    @Setter(value = AccessLevel.NONE)
    private List<Image> images = new ArrayList<>();

    @Setter(value = AccessLevel.NONE)
    private List<Tag> tags = new ArrayList<>();


}
