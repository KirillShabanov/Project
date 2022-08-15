package com.home.MyWorkTime.service;

import com.home.MyWorkTime.dto.UsersModelDTO;
import com.home.MyWorkTime.entity.UsersModel;
import com.home.MyWorkTime.exception.ValidationException;
import com.home.MyWorkTime.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService{

    private final UsersRepository usersRepository;
    private final UserConverter userConverter;


    @Override
    public UsersModelDTO saveUser(UsersModelDTO usersModelDTO) throws ValidationException {
        validateUsersModelDTO(usersModelDTO);
        UsersModel savedUser = usersRepository.save(userConverter.fromUserModelDTOToUsersModel(usersModelDTO));
        return userConverter.fromUsersModelToUsersModelDTO(savedUser);
    }

    private void validateUsersModelDTO(UsersModelDTO usersModelDTO) throws ValidationException {
        if (isNull(usersModelDTO)){
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersModelDTO.getName()) || usersModelDTO.getName().isEmpty()){
            throw new ValidationException("Name is empty");
        }
        if (isNull(usersModelDTO.getSurname()) || usersModelDTO.getSurname().isEmpty()){
            throw new ValidationException("Surname is empty");
        }
        if (isNull(usersModelDTO.getLogin()) || usersModelDTO.getLogin().isEmpty()){
            throw new ValidationException("Login is empty");
        }
        if (isNull(usersModelDTO.getPassword()) || usersModelDTO.getPassword().isEmpty()){
            throw new ValidationException("Password is empty");
        }
    }

    @Override
    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersModelDTO findByLogin(String login) {
        return userConverter.fromUsersModelToUsersModelDTO(usersRepository.findByLogin(login));
    }

    @Override
    public List<UsersModelDTO> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(userConverter::fromUsersModelToUsersModelDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsersModel> findById(Long id) {
        return usersRepository.findById(id);
    }
}
