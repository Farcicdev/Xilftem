package com.xilften.mapper;

import com.xilften.controller.request.MovieRequest;
import com.xilften.model.MovieModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieMapper {



    public MovieModel toMovie(MovieRequest request){
        return MovieModel
                .builder()
                .title(request.title())
                .description(request.description())
                .ratting(request.ratting())
                .releaseDate(request.releaseDate())
                .build();
    }
}
