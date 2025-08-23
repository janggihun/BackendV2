package com.bismo.stellive.api.user;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //pk
    private Long id;
    // 유저 아이디
    private String userId;
    // 유저 비밀번호
    private String userPw;
    //유저이름
    private String userName;
    //권한
    @Enumerated(EnumType.STRING)
    private Role role;

//    private String jwt; // 토큰

    public User() {
        this.id = 1L;
        this.userId = userId;
        this.role = Role.TEST;
        this.userName = "테스터";
    }


    public enum Role {

        ADMIN("관리자"),
        STAFF("직원"),
        CHIEF("주임"),
        PROFESSIONAL("대리"),
        SUPERVISOR("과장"),
        MANAGER("부장"),
        TEST("테스터"),
        PRESIDENT("사장");



        private final String label;

        Role(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

}
