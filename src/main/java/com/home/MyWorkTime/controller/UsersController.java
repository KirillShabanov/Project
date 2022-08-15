package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.dto.UsersModelDTO;
import com.home.MyWorkTime.entity.UsersModel;
import com.home.MyWorkTime.exception.ValidationException;
import com.home.MyWorkTime.service.UserConverter;
import com.home.MyWorkTime.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
@CrossOrigin
public class UsersController {

    private final UsersService usersService;
    private final UserConverter userConverter;

    @PostMapping("/save")
    public UsersModelDTO saveUsers(@RequestBody UsersModelDTO usersModelDTO) throws ValidationException {
        log.info("Handling save users: " + usersModelDTO);
        return usersService.saveUser(usersModelDTO);
    }

    @GetMapping("/findAll")
    public List<UsersModelDTO> findAllUsers(){
        log.info("Handling find all users request");
        return usersService.findAll();
    }

    @GetMapping("/findByLogin")
    public UsersModelDTO findByLogin(@RequestParam String login){
        log.info("Handling find by login request: " + login);
        return usersService.findByLogin(login);
    }
    @GetMapping("/findById/{id}")
    public Optional<UsersModel> findById(@PathVariable Long id){
        log.info("Handling find by id request: " + id);
        return usersService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id){
        log.info("Handling delete user request: " + id);
        usersService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    Optional<UsersModelDTO> updateUser (@RequestBody UsersModel newUserModel,
                           @PathVariable Long id){

         return usersService.findById(id).map(usersModel -> {
            usersModel.setName(newUserModel.getName());
            usersModel.setSurname(newUserModel.getSurname());
            usersModel.setLogin(newUserModel.getLogin());
            usersModel.setPassword(newUserModel.getPassword());
            usersModel.setLevel_access(newUserModel.getLevel_access());
            UsersModelDTO usersModelDTO = null;
            try {
                usersModelDTO = usersService.saveUser(userConverter.fromUsersModelToUsersModelDTO(usersModel));
            } catch (ValidationException e) {
                e.printStackTrace();
            }
             return usersModelDTO;
        });

    }
}
