package com.xilften.service;

import com.xilften.model.CategoryModel;
import com.xilften.model.MovieModel;
import com.xilften.model.StreamingModel;
import com.xilften.repository.MovieRepository;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

        private final MovieRepository repository;
        private final CategoryService categoryService;
        private final StreamingService streamingService;


    public MovieModel save(MovieModel movieModel){
        movieModel.setCategories(this.findByCategory(movieModel.getCategories()));
        movieModel.setStreamings(this.findByStreamings(movieModel.getStreamings()));
        return repository.save(movieModel);
    }

    public List<MovieModel> list(){
        return repository.findAll();
    }

    private List<CategoryModel> findByCategory(List<CategoryModel> categories) {
        List<CategoryModel> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.buscarId(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<StreamingModel> findByStreamings(List<StreamingModel> streamings){
        List<StreamingModel> streamingFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.BuscarById(streaming.getId()).ifPresent(streamingFound::add));
        return streamingFound;
    }
}
