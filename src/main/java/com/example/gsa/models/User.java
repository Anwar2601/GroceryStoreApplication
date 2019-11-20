package com.example.gsa.models;

import com.example.gsa.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID userId;
    private String userName;
    private String govtId;
    private LocalDate joiningDate;
    private UserTypeEnum userType;
}
