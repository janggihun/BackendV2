package com.bismo.stellive.api.user;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //pk

    private String userId; // 유저 아이디
    private String userPw; // 유저 비밀번호
//    private String jwt; // 토큰

    @Enumerated(EnumType.STRING)
    private Role role; //권한


    public enum Role {

        ADMIN("관리자"),
        STAFF("직원"),
        CHIEF("주임"),
        PROFESSIONAL("대리"),
        SUPERVISOR("과장"),
        MANAGER("부장"),
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
