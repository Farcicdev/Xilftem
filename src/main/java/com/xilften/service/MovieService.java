package com.xilften.service;

import com.xilften.model.MovieModel;
import com.xilften.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

        private final MovieRepository repository;

    public MovieModel save(MovieModel movieModel){
        return repository.save(movieModel);
    }
}
