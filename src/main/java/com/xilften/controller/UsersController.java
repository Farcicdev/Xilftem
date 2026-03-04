package com.xilften.controller;

import com.xilften.controller.request.UsersRequest;
import com.xilften.controller.response.UsersResponse;
import com.xilften.mapper.UsersMapper;
import com.xilften.model.Users;
import com.xilften.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UsersController {

    private final UsersService service;

    @PostMapping
    public ResponseEntity<UsersResponse> register(UsersRequest request) {
        Users save = service.save(UsersMapper.toUsers(request));
        return ResponseEntity.ok(UsersMapper.toResponse(save));
    }

    @GetMapping
    public ResponseEntity<List<UsersResponse>> listaUsers() {
        return ResponseEntity.ok(service.listUsers()
                .stream()
                .map(UsersMapper::toResponse)
                .toList()
        );
    }


}
