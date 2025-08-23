package com.bismo.stellive.api.compHdr.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompResponse {

    private Long id;
    private String compNm;
    private String compAdr;
    private String compCd;



}
