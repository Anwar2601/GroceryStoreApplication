package com.example.gsa.factory;

import com.example.gsa.enums.UserTypeEnum;
import com.example.gsa.models.User;
import com.example.gsa.service.UserService;
import com.example.gsa.service.impl.AffiliateServiceImpl;
import com.example.gsa.service.impl.CustomerServiceImpl;
import com.example.gsa.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class UserFactoryTest {

    @Mock
    private AffiliateServiceImpl affiliateServiceImpl;

    @Mock
    private CustomerServiceImpl customerServiceImpl;

    @Mock
    private EmployeeServiceImpl employeeServiceImpl;

    @InjectMocks
    private UserFactory userFactory;

    @Test
    public void testForEmployee(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.EMPLOYEE));
        UserService userService = userFactory.getUserService(user);
        Assert.isTrue(userService instanceof EmployeeServiceImpl,"Test Failed");
    }

    @Test
    public void testForAffiliate(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now(), UserTypeEnum.AFFILIATE));
        UserService userService = userFactory.getUserService(user);
        Assert.isTrue(userService instanceof AffiliateServiceImpl,"Test Failed");
    }

    @Test
    public void testForCustomer(){
        Optional<User> user = Optional.of(new User(UUID.randomUUID(),"","", LocalDate.now().minusYears(3), UserTypeEnum.CUSTOMER));
        UserService userService = userFactory.getUserService(user);
        Assert.isTrue(userService instanceof CustomerServiceImpl,"Test Failed");
    }
}
