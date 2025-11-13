package com.xilften.controller;


import com.xilften.controller.request.CategoryRequest;
import com.xilften.controller.response.CategoryResponse;
import com.xilften.mapper.CategoryMapper;
import com.xilften.model.CategoryModel;
import com.xilften.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    //📥 ENTRADA → CategoryRequest
    //📤 SAÍDA → CategoryResponse (dentro de um ResponseEntity)

    @GetMapping("/listar")
    public ResponseEntity<List<CategoryResponse>> listar() {
        List<CategoryResponse> list = categoryService.list()
                .stream()
                .map(CategoryMapper::toResponse)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/criar")
    public ResponseEntity<CategoryResponse> criar(@RequestBody CategoryRequest request) {
        CategoryModel model = CategoryMapper.toCategory(request);
        CategoryModel criar = categoryService.criar(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toResponse(criar));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return categoryService.buscarId(id)
                .map(CategoryModel -> ResponseEntity.ok(CategoryMapper.toResponse(CategoryModel)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        categoryService.deleById(id);
        return ResponseEntity.ok("deletado com sucesso");
    }
}