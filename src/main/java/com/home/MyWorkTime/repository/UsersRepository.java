package com.home.MyWorkTime.repository;


import com.home.MyWorkTime.entity.UsersModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<UsersModel, Long> {

    UsersModel findByLogin (String login);
    @Override
    @NotNull
    Optional<UsersModel> findById (@NotNull Long id);


}
