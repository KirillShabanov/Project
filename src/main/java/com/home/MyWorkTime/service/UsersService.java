package com.home.MyWorkTime.service;

import com.home.MyWorkTime.dto.UsersModelDTO;

import com.home.MyWorkTime.entity.UsersModel;
import com.home.MyWorkTime.exception.ValidationException;

import java.util.List;
import java.util.Optional;


public interface UsersService {

    UsersModelDTO saveUser(UsersModelDTO usersModelDTO) throws ValidationException;

    void deleteUser(Long id);

    UsersModelDTO findByLogin(String login);

    List<UsersModelDTO> findAll();

    Optional<UsersModel> findById(Long id);
}
