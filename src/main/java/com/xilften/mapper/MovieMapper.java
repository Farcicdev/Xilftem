package com.xilften.mapper;

import com.xilften.controller.request.MovieRequest;
import com.xilften.controller.response.CategoryResponse;
import com.xilften.controller.response.MovieResponse;
import com.xilften.controller.response.StreamingResponse;
import com.xilften.model.Category;
import com.xilften.model.Movie;
import com.xilften.model.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public Movie toMovie(MovieRequest request){
        List<Category> categories = request.categories()
                .stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings()
                .stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie
                .builder()
                .title(request.title())
                .description(request.description())
                .rating(request.rating())
                .releaseDate(request.releaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toResponse(Movie model){

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
