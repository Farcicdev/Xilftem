package com.xilften.mapper;

import com.xilften.controller.request.CategoryRequest;
import com.xilften.controller.response.CategoryResponse;
import com.xilften.model.Category;
import lombok.experimental.UtilityClass;

@UtilityClass

public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){//request e a saida de dados PARA O USUARIO
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }


    public static CategoryResponse toResponse(Category category){
        return CategoryResponse
                .builder()
                .name(category.getName())
                .id(category.getId())
                .build();
    }
}
