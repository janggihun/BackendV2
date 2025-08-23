package com.bismo.stellive.api.ItemHdr.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {


    private Long id;
    //품목코드
    private String itemCd;
    //품목이름
    private String itemNm;
    //    private 규격 추후에
    // 실행원가
    private Integer itemMony;




}
