package com.bismo.stellive.api.compHdr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompRequest {
    private Long id; //pk

    private String compNm;            //회사 이름
    private String compAdr;         //주소
    private String compCd;          //사업자등록번호
}
