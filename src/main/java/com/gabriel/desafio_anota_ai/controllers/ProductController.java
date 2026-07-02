package com.gabriel.desafio_anota_ai.controllers;

import com.gabriel.desafio_anota_ai.domain.product.Product;
import com.gabriel.desafio_anota_ai.domain.product.ProductRequestDTO;
import com.gabriel.desafio_anota_ai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> product = this.productService.getAll();
        return ResponseEntity.ok(product);

    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductRequestDTO body){
        Product product = this.productService.insert(body);
        return  ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable(name ="id") String id, @RequestBody ProductRequestDTO body){
        Product product = this.productService.update(id,body);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id){
        this.productService.delete(id);
      return ResponseEntity.noContent().build();
    }

}
