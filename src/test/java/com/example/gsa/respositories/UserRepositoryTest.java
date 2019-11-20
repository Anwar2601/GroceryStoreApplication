package com.example.gsa.respositories;

import com.example.gsa.enums.UserTypeEnum;
import com.example.gsa.models.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class UserRepositoryTest {

    @InjectMocks
    private UserRepository userRepository;

    @Test
    public void testUserCrudOperations(){
        User user = new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.EMPLOYEE);
        userRepository.saveUser(user);
        Optional<User> returnedUser = userRepository.getUser(user.getUserId());
        Assert.isTrue(returnedUser.isPresent()&&returnedUser.get().getUserId().equals(user.getUserId()),"Test Failed");
    }
}
