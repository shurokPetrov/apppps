package catalog.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uniq_id")
    private String id;
    private String sku;
    @Column(name = "name_title")
    private String name;
    private String description;
    @Column(name = "list_price")
    private String listPrice;
    @Column(name = "sale_price")
    private String salePrice;
    private String category;
    @Column(name = "category_tree")
    private String categoryTree;
    @Column(name = "average_product_rating")
    private String averageRating;
    @Column(name = "product_url")
    private String productUrl;
    @Column(name = "product_image_urls")
    private String productImageUrl;
    private String brand;
    @Column(name = "total_number_reviews")
    private String numberOfReviews;
    @Column(name = "Reviews")
    private String reviews;
}
