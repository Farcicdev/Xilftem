package com.xilften.service;

import com.xilften.model.Users;
import com.xilften.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;

    public Users save(Users entity){
        return repository.save(entity);
    }

    public List<Users> listUsers(){
        return repository.findAll();
    }

}
