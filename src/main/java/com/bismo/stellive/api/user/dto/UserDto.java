package com.bismo.stellive.api.user.dto;


import lombok.Data;

@Data
public class UserDto {
    Integer id;
    String userId;
    String userName;
    String userPw;
    String jwt; //토큰
}
