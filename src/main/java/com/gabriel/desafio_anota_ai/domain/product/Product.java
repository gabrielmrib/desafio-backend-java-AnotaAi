package com.gabriel.desafio_anota_ai.domain.product;

import com.gabriel.desafio_anota_ai.domain.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private  String Title;
    private String Owner;
    private Category category;
    private Double price;
    private String description;


    public Product(ProductRequestDTO productDTO){
        this.setDescription(productDTO.description());
        this.setTitle(productDTO.title());
        this.setOwner(productDTO.owner());
        this.setPrice(productDTO.price());
        this.setCategory(productDTO.category());

    }
}
