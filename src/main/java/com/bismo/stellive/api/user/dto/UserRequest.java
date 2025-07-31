package com.bismo.stellive.api.user.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class UserRequest {

    @NotBlank(message = "아이디를 적어주세요")
    private String userId;
    @NotBlank(message = "비밀번호를 적어주세요")
    private String userPw;



}
