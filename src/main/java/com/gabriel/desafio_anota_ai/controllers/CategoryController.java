package com.gabriel.desafio_anota_ai.controllers;

import com.gabriel.desafio_anota_ai.domain.category.Category;
import com.gabriel.desafio_anota_ai.domain.category.CategoryRequestDTO;
import com.gabriel.desafio_anota_ai.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryRequestDTO requestDTO ){

        Category category = this.categoryService.insert(requestDTO);

        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = this.categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable(name = "id")String id, @RequestBody CategoryRequestDTO categoryRequestDTO){
        Category updateCategory =  this.categoryService.update(id,categoryRequestDTO);
        return  ResponseEntity.ok(updateCategory);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable(name = "id") String id){
         this.categoryService.delete(id);
        return  ResponseEntity.noContent().build();

    }

}
