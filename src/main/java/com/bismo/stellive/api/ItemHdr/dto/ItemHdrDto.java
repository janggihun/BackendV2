package com.bismo.stellive.api.ItemHdr.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemHdrDto {


    private Long id;
    //품목코드
    private String itemCd;
    //품목이름
    private String itemNm;
    //    private 규격 추후에
    // 실행원가
    private Integer itemMony;

}
