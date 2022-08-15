package com.home.MyWorkTime.service;


import com.home.MyWorkTime.dto.UsersModelDTO;
import com.home.MyWorkTime.entity.UsersModel;
import com.home.MyWorkTime.exception.ValidationException;
import com.home.MyWorkTime.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultUsersServiceTest {

    private UsersService usersService;

    @BeforeEach
    void setUp(){
        UsersRepository usersRepository = mock(UsersRepository.class);
        UserConverter userConverter = new UserConverter();
        UsersModel usersModel = new UsersModel();
        //usersModel.setId(1);
        usersModel.setName("testName");
        usersModel.setSurname("testSurname");
        usersModel.setLogin("testLogin");
        usersModel.setPassword("testPassword");
        usersModel.setLevel_access(1);
        when(usersRepository.save(any())).thenReturn(usersModel);
        usersService = new DefaultUsersService(usersRepository, userConverter);
    }

    @Test
    void saveUsersModelReturnUsersModelDTO() throws ValidationException {
        UsersModelDTO usersModelDTO = UsersModelDTO.builder()
                .id(1L)
                .login("testLogin")
                .build();
        UsersModelDTO savedUsersModelDTO = usersService.saveUser(usersModelDTO);
        assertThat(savedUsersModelDTO).isNotNull();
        assertThat(savedUsersModelDTO.getLogin()).isEqualTo("testLogin");
    }

    @Test
    void saveUsersModelWithNullLoginThrowsValidationException(){
        UsersModelDTO usersModelDTO = UsersModelDTO.builder().build();
        assertThrows(ValidationException.class,
                ()-> usersService.saveUser(usersModelDTO),
                "Login is empty");
    }

}