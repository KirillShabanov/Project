package com.home.MyWorkTime.service;

import com.home.MyWorkTime.dto.UsersModelDTO;
import com.home.MyWorkTime.entity.UsersModel;
import org.springframework.stereotype.Component;



@Component
public class UserConverter {

    public UsersModel fromUserModelDTOToUsersModel(UsersModelDTO usersModelDTO){
        UsersModel usersModel = new UsersModel();
        usersModel.setId(usersModelDTO.getId());
        usersModel.setName(usersModelDTO.getName());
        usersModel.setSurname(usersModelDTO.getSurname());
        usersModel.setLogin(usersModelDTO.getLogin());
        usersModel.setPassword(usersModelDTO.getPassword());
        usersModel.setLevel_access(usersModelDTO.getLevel_access());
        return usersModel;
    }

    public UsersModelDTO fromUsersModelToUsersModelDTO (UsersModel usersModel){

        return UsersModelDTO.builder()
                .id(usersModel.getId())
                .name(usersModel.getName())
                .surname(usersModel.getSurname())
                .login(usersModel.getLogin())
                .password(usersModel.getPassword()) // //"***********"
                .level_access(usersModel.getLevel_access())
                .build();
    }

}
