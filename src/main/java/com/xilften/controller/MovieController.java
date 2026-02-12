package com.xilften.controller;

import com.xilften.controller.request.MovieRequest;
import com.xilften.controller.response.MovieResponse;
import com.xilften.mapper.CategoryMapper;
import com.xilften.mapper.MovieMapper;
import com.xilften.model.MovieModel;
import com.xilften.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @PostMapping
    public ResponseEntity<MovieResponse> saved (@RequestBody MovieRequest request){
        MovieModel save = service.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> list(){
        return ResponseEntity.ok(service.list()
                .stream()
                .map(MovieMapper::toResponse)
                .toList()
        );
    }
}
