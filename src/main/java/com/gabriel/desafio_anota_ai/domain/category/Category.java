package com.gabriel.desafio_anota_ai.domain.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Locale;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String id;
    private String title;
    private String owner;
    private String description;

    public  Category(CategoryRequestDTO categoryData){
        this.description = categoryData.description();
        this.title = categoryData.title();
        this.owner = categoryData.owner();


    }

}

