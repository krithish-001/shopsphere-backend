package com.shopsphere.shopsphere.category.service;

import com.shopsphere.shopsphere.category.dto.CategoryRequestDto;
import com.shopsphere.shopsphere.category.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto request);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto getCategoryById(Long id);
}
