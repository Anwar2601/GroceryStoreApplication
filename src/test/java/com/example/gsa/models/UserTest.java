package com.example.gsa.models;

import com.example.gsa.enums.UserTypeEnum;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
public class UserTest {

    @InjectMocks
    private User user;

    @Test
    public void testGetterSetters(){
        User user = new User();
        user.setGovtId("Gov101");
        user.setJoiningDate(LocalDate.now());
        user.setUserId(UUID.randomUUID());
        user.setUserName("");
        user.setUserType(UserTypeEnum.CUSTOMER);
        UUID userId = user.getUserId();
        UserTypeEnum userType = user.getUserType();
        LocalDate joiningDate = user.getJoiningDate();
        String govtId = user.getGovtId();
        String userName = user.getUserName();
        Assert.isTrue(userType.equals(UserTypeEnum.CUSTOMER)
                &&userId!=null
                &&joiningDate!=null
                &&govtId!=null
                &&userName!=null,"Test Failed");
    }

    @Test
    public void testObjectMethods(){
        User user = new User();
        user.setGovtId("Gov101");
        user.setUserId(UUID.randomUUID());
        user.setUserType(UserTypeEnum.CUSTOMER);
        String toString = user.toString();
        int hashCode = user.hashCode();
        boolean equals = user.equals(user);
        boolean notEquals = user.equals(new User());
        Assert.isTrue(toString!=null
                &&hashCode!=0
                &&equals==true
                &&notEquals==false,"Test Failed");
    }
}
