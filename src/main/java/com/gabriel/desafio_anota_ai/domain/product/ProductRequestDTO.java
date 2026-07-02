package com.gabriel.desafio_anota_ai.domain.product;

import com.gabriel.desafio_anota_ai.domain.category.Category;

public record ProductRequestDTO(String title, String description, Double price , String category, String owner) {
}
