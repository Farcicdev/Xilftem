package com.xilften.mapper;

import com.xilften.controller.request.MovieRequest;
import com.xilften.controller.response.CategoryResponse;
import com.xilften.controller.response.MovieResponse;
import com.xilften.controller.response.StreamingResponse;
import com.xilften.model.CategoryModel;
import com.xilften.model.MovieModel;
import com.xilften.model.StreamingModel;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public MovieModel toMovie(MovieRequest request){

        List<CategoryModel> categories = request.categories()
                .stream()
                .map(categoryId -> CategoryModel.builder().id(categoryId).build())
                .toList();

        List<StreamingModel> streamings = request.streamings()
                .stream()
                .map(streamingId -> StreamingModel.builder().id(streamingId).build())
                .toList();

        return MovieModel
                .builder()
                .title(request.title())
                .description(request.description())
                .rating(request.rating())
                .releaseDate(request.releaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toResponse(MovieModel model){

        List<CategoryResponse> categories = model.getCategories()
                .stream()
                .map(category -> CategoryMapper.toResponse(category))
                .toList();

        List<StreamingResponse> streamings = model.getStreamings()
                .stream()
                .map(streaming -> StreamingMapper.toResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(model.getId())
                .title(model.getTitle())
                .description(model.getDescription())
                .rating(model.getRating())
                .releaseDate(model.getReleaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}
