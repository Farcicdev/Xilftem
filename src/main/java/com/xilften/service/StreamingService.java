package com.xilften.service;

import com.xilften.model.StreamingModel;
import com.xilften.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public List<StreamingModel> listar() {
        return repository.findAll();
    }

    //Criar
    public StreamingModel criar(StreamingModel model) {
        return repository.save(model);
    }

    //ListarPorId
    public Optional<StreamingModel> BuscarById(Long id) {
        return repository.findById(id);
    }

    //deletar
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
