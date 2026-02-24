package com.xilften.repository;

import com.xilften.model.CategoryModel;
import com.xilften.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {
    //BuscarPorCategoria
    List<MovieModel> findMovieByCategories (List<CategoryModel> categories);

}
