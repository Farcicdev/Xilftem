package com.xilften.mapper;

import com.xilften.controller.request.UsersRequest;
import com.xilften.controller.response.UsersResponse;
import com.xilften.model.Users;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsersMapper {

    public Users toUsers(UsersRequest request) {
        return Users.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }


    public UsersResponse toResponse(Users entity) {
        return UsersResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();

    }
}
