package com.gabriel.desafio_anota_ai.service;

import com.gabriel.desafio_anota_ai.domain.category.Category;
import com.gabriel.desafio_anota_ai.domain.category.exceptions.CategotyNotFindExpeption;
import com.gabriel.desafio_anota_ai.domain.product.Product;
import com.gabriel.desafio_anota_ai.domain.product.ProductRequestDTO;
import com.gabriel.desafio_anota_ai.domain.product.exeptions.ProductNotFindExeption;
import com.gabriel.desafio_anota_ai.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product insert(ProductRequestDTO requestDTO){
        Category category = this.categoryService.getById(requestDTO.category()).orElseThrow(CategotyNotFindExpeption::new);
        Product product = new Product(requestDTO);
        product.setCategory(category);
        return this.productRepository.insert(product);
    }

    public Product update(String id,ProductRequestDTO productDTO){
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFindExeption::new);

        this.categoryService.getById(productDTO.category()).ifPresent(product::setCategory);
        if (!productDTO.title().isEmpty()) product.setTitle(productDTO.title());
        if (!productDTO.description().isEmpty()) product.setDescription(productDTO.description());
        if (!productDTO.owner().isEmpty()) product.setOwner(productDTO.owner());
        if (!productDTO.price().isNaN()) product.setPrice(productDTO.price());
        this.productRepository.save(product);
        return product;
    }

    public void delete(String id){
        Product product = this.productRepository.findById(id).orElseThrow(ProductNotFindExeption::new);
         this.productRepository.delete(product);
    }

}
