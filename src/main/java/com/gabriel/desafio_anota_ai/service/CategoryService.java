package com.gabriel.desafio_anota_ai.service;

import com.gabriel.desafio_anota_ai.domain.category.Category;
import com.gabriel.desafio_anota_ai.domain.category.CategoryRequestDTO;
import com.gabriel.desafio_anota_ai.domain.category.CategoryResponseDTO;
import com.gabriel.desafio_anota_ai.domain.category.exceptions.CategotyNotFindExpeption;
import com.gabriel.desafio_anota_ai.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category insert(CategoryRequestDTO data){
        Category newCategory = new Category(data);
        this.categoryRepository.save(newCategory);
        return newCategory;

    }

    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();
    }

    public Category update(String id,CategoryRequestDTO categoryData){
        Category category  = this.categoryRepository.findById(id).orElseThrow(CategotyNotFindExpeption::new);

        if(!categoryData.title().isEmpty())   category.setTitle(categoryData.title());

        if (!categoryData.description().isEmpty()) category.setDescription(categoryData.description());

        this.categoryRepository.save(category);
        return category;

    }

    public void delete(String id){
        Category category = this.categoryRepository.findById(id).orElseThrow(CategotyNotFindExpeption::new);
        this.categoryRepository.delete(category);
    }

    public Optional<Category> getById(String id){
        return this.categoryRepository.findById(id);
    }



}
