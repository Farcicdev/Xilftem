package com.xilften.mapper;

import com.xilften.controller.request.CategoryRequest;
import com.xilften.controller.response.CategoryResponse;
import com.xilften.model.CategoryModel;
import lombok.experimental.UtilityClass;

@UtilityClass

public class CategoryMapper {

    public static CategoryModel toCategory(CategoryRequest categoryRequest){//request e a saida de dados PARA O USUARIO
        return CategoryModel
                .builder()
                .name(categoryRequest.name())
                .build();
    }


    public static CategoryResponse toResponse(CategoryModel categoryModel){
        return CategoryResponse
                .builder()
                .name(categoryModel.getName())
                .id(categoryModel.getId())
                .build();
    }
}
