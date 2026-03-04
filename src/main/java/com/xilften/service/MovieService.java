package com.xilften.service;

import com.xilften.model.Category;
import com.xilften.model.Movie;
import com.xilften.model.Streaming;
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


    public Movie save(Movie movie) {
        movie.setCategories(this.findByCategory(movie.getCategories()));
        movie.setStreamings(this.findByStreamings(movie.getStreamings()));
        return repository.save(movie);
    }

    public List<Movie> list() {
        return repository.findAll();
    }

    public Optional<Movie> findByIdMovie(Long id){
        return repository.findById(id);
    }

    public Optional<Movie> updateMovie(Long id, Movie movie){
        Optional<Movie> optMovie = repository.findById(id);
        if(optMovie.isPresent()){

            List<Category> byCategory = this.findByCategory(movie.getCategories());
            List<Streaming> byStreamings = this.findByStreamings(movie.getStreamings());

            Movie model = optMovie.get();
            model.setTitle(movie.getTitle());
            model.setDescription(movie.getDescription());
            model.setReleaseDate(movie.getReleaseDate());
            model.setRating(movie.getRating());

            model.getStreamings().clear();
            model.getStreamings().addAll(byStreamings);

            model.getCategories().clear();
            model.getCategories().addAll(byCategory);

            repository.save(movie);

            return Optional.of(movie);

        }
            return Optional.empty();
    }

    public List<Movie> findByCategory(Long id){
        return repository.findMovieByCategories(List.of(Category.builder().id(id).build()));
    }

    private List<Category> findByCategory(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.buscarId(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findByStreamings(List<Streaming> streamings) {
        List<Streaming> streamingFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.BuscarById(streaming.getId()).ifPresent(streamingFound::add));
        return streamingFound;
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}