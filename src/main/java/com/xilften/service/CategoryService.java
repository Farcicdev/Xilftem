package com.xilften.service;

import com.xilften.model.Category;
import com.xilften.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> list() {
        return categoryRepository.findAll();
    }

    public Category criar(Category model) {
        return categoryRepository.save(model);
    }

    public Optional<Category> buscarId(Long id) {
        return categoryRepository.findById(id);
    }

    public void deleById(Long id) {
        categoryRepository.deleteById(id);
    }
}
