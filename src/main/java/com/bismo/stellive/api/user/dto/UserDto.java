package com.bismo.stellive.api.user.dto;


import lombok.Data;

@Data
public class UserDto {

    String userId;
    String userName;
    String userPw;
    String jwt; //토큰
}
