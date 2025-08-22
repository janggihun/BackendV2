package com.bismo.stellive.api.compMgnt;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;


@Entity
@Getter
public class CompMgnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //pk

    private String compNm;            //회사 이름
    private String compAdr;         //주소


    public void inputId(Long compId) {
        this.id = compId;
    }
}
