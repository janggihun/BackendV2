package com.bismo.stellive.api.obtn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObtnRequset {

    private Long id;                                        //pk
    private String obtnNm;                                  //수주번호
    private String obtnMk;                                  //비고
    private String userId;                                  //접속자
    private Integer mony;                                   //금액
    private Long  plceId;                                   //장소
    private Long  compId;                                   //회사명

    private String  startDt;            //시작날짜
    private String  endDt;              //끝날짜




}
