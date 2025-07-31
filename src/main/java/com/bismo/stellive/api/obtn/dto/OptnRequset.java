package com.bismo.stellive.api.obtn.dto;

import com.bismo.stellive.api.obtn.Obtn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptnRequset {

    private Long id;                                        //pk
    private String obtnNm;                                  //수주번호
    private String obtnMk;                                  //비고
    private String userId;                                  //접속자




}
