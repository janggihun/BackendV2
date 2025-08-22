package com.bismo.stellive.api.Item;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //pk
    private Long id;
    //품목코드
    private String itemCd;
    //품목이름
    private String itemNm;
    //    private 규격 추후에
    // 실행원가
    private Integer itemMony;
}
