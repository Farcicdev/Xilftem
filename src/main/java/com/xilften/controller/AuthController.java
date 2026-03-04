package com.xilften.controller;

import com.xilften.controller.request.LoginRequest;
import com.xilften.controller.request.UsersRequest;
import com.xilften.controller.response.UsersResponse;
import com.xilften.mapper.UsersMapper;
import com.xilften.model.Users;
import com.xilften.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersService service;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UsersResponse> register(UsersRequest request) {
        Users save = service.save(UsersMapper.toUsers(request));
        return ResponseEntity.ok(UsersMapper.toResponse(save));
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(
                loginRequest.email(),
                loginRequest.password()
        );
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

//        Users user = (Users) authenticate.getPrincipal();
        return ResponseEntity.ok("Logado com sucesso!");

    }
}
