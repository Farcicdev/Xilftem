package com.xilften.repository;

import com.xilften.model.Category;
import com.xilften.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //BuscarPorCategoria
    List<Movie> findMovieByCategories (List<Category> categories);

}
