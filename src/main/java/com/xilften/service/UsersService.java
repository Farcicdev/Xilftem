package com.xilften.service;

import com.xilften.model.Users;
import com.xilften.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final PasswordEncoder encoder;


    public Users save(Users entity){
        String password = entity.getPassword();
        entity.setPassword(encoder.encode(password));
        return repository.save(entity);
    }

}
