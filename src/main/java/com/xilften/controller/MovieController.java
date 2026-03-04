package com.xilften.controller;

import com.xilften.controller.request.MovieRequest;
import com.xilften.controller.response.MovieResponse;
import com.xilften.mapper.MovieMapper;
import com.xilften.model.Movie;
import com.xilften.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @PostMapping
    public ResponseEntity<MovieResponse> saved (@RequestBody MovieRequest request){
        Movie save = service.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toResponse(save));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> list(){
        return ResponseEntity.ok(service.list()
                .stream()
                .map(MovieMapper::toResponse)
                .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id){
        return service.findByIdMovie(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @RequestBody MovieRequest request){
        return service.updateMovie(id,MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toResponse(movie)))
                .orElse(ResponseEntity.notFound().build());

    }


    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByMovieCategory(@RequestParam Long category){
        return ResponseEntity.ok(service.findByCategory(category)
                .stream()
                .map(MovieMapper::toResponse)
                .toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional optMovie = service.findByIdMovie(id);
        if(optMovie.isPresent()){
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
            return ResponseEntity.notFound().build();
    }
}
