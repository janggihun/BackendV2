package com.bismo.stellive.api.compMgnt.dto;


import com.bismo.stellive.api.compMgnt.Company;
import com.bismo.stellive.api.obtn.Obtn;
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


    public CompResponse(Company company) {
        this.id = company.getId();
        this.compNm = company.getCompNm();
        this.compAdr = company.getCompAdr();
    }


}
