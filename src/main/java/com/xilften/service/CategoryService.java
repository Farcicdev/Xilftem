package com.xilften.service;

import com.xilften.model.CategoryModel;
import com.xilften.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryModel> list() {
        return categoryRepository.findAll();
    }

    public CategoryModel criar(CategoryModel model) {
        return categoryRepository.save(model);
    }

    public Optional<CategoryModel> buscarId(Long id) {
        return categoryRepository.findById(id);
    }

    public void deleById(Long id) {
        categoryRepository.deleteById(id);
    }
}
