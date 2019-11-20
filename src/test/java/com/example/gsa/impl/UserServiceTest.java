package com.example.gsa.impl;

import com.example.gsa.enums.UserTypeEnum;
import com.example.gsa.models.User;
import com.example.gsa.respositories.UserRepository;
import com.example.gsa.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void testGetUser(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.CUSTOMER));
        Mockito.when(userRepository.getUser(Mockito.any())).thenReturn(user);
        Optional<User> returnedUser = userServiceImpl.getUser(UUID.randomUUID());
        Assert.isTrue(returnedUser.isPresent(),"Test Failed");
    }

    @Test
    public void testForCustomer(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.CUSTOMER));
        Mockito.when(userRepository.getUser(Mockito.any())).thenReturn(user);
        boolean result = userServiceImpl.checkUserType(user);
        Assert.isTrue(result== Boolean.FALSE,"Test Failed");
    }

    @Test
    public void testForEmployee(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.EMPLOYEE));
        Mockito.when(userRepository.getUser(Mockito.any())).thenReturn(user);
        boolean result = userServiceImpl.checkUserType(user);
        Assert.isTrue(result== Boolean.TRUE,"Test Failed");
    }

    @Test
    public void testForNewUser(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.CUSTOMER));
        Mockito.when(userRepository.getUser(Mockito.any())).thenReturn(user);
        boolean result = userServiceImpl.checkUserJoiningDate(user);
        Assert.isTrue(result== Boolean.FALSE,"Test Failed");
    }

    @Test
    public void testForOldUser(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now().minusYears(3), UserTypeEnum.CUSTOMER));
        Mockito.when(userRepository.getUser(Mockito.any())).thenReturn(user);
        boolean result = userServiceImpl.checkUserJoiningDate(user);
        Assert.isTrue(result== Boolean.TRUE,"Test Failed");
    }
}
