package com.xilften.service;

import com.xilften.model.CategoryModel;
import com.xilften.model.MovieModel;
import com.xilften.model.StreamingModel;
import com.xilften.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;


    public MovieModel save(MovieModel movieModel) {
        movieModel.setCategories(this.findByCategory(movieModel.getCategories()));
        movieModel.setStreamings(this.findByStreamings(movieModel.getStreamings()));
        return repository.save(movieModel);
    }

    public List<MovieModel> list() {
        return repository.findAll();
    }

    public Optional<MovieModel> findByIdMovie(Long id){
        return repository.findById(id);
    }

    public Optional<MovieModel> updateMovie(Long id, MovieModel movieModel){
        Optional<MovieModel> optMovie = repository.findById(id);
        if(optMovie.isPresent()){

            List<CategoryModel> byCategory = this.findByCategory(movieModel.getCategories());
            List<StreamingModel> byStreamings = this.findByStreamings(movieModel.getStreamings());

            MovieModel model = optMovie.get();
            model.setTitle(movieModel.getTitle());
            model.setDescription(movieModel.getDescription());
            model.setReleaseDate(movieModel.getReleaseDate());
            model.setRating(movieModel.getRating());

            model.getStreamings().clear();
            model.getStreamings().addAll(byStreamings);

            model.getCategories().clear();
            model.getCategories().addAll(byCategory);

            repository.save(movieModel);

            return Optional.of(movieModel);

        }
            return Optional.empty();
    }

    public List<MovieModel> findByCategory(Long id){
        return repository.findMovieByCategories(List.of(CategoryModel.builder().id(id).build()));
    }

    private List<CategoryModel> findByCategory(List<CategoryModel> categories) {
        List<CategoryModel> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.buscarId(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<StreamingModel> findByStreamings(List<StreamingModel> streamings) {
        List<StreamingModel> streamingFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.BuscarById(streaming.getId()).ifPresent(streamingFound::add));
        return streamingFound;
    }
}