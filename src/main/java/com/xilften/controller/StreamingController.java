package com.xilften.controller;

import com.xilften.controller.request.StreamingRequest;
import com.xilften.controller.response.StreamingResponse;
import com.xilften.mapper.StreamingMapper;
import com.xilften.model.StreamingModel;
import com.xilften.service.StreamingService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/streaming")
@RestController
public class StreamingController {
    @Autowired
    private StreamingService service;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> list() {
        List<StreamingResponse> listar = service.listar()
                .stream()
                .map(StreamingMapper::toResponse)
                .toList();
        return ResponseEntity.ok(listar);

    }

    @PostMapping("/criar")
    public ResponseEntity<StreamingResponse> criar(@RequestBody StreamingRequest request) {
        StreamingModel model = StreamingMapper.toStreaming(request);
        StreamingModel criar = service.criar(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toResponse(criar));

    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> buscarId(@PathVariable Long id) {
        return service.BuscarById(id)
                .map(StreamingModel -> ResponseEntity.ok(StreamingMapper.toResponse(StreamingModel)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
