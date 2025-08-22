package com.bismo.stellive.api.obtn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObtnResponse {

    private Long id;                    //pk
    private String obtnNm;              //수주번호
    private String inputId;             //작성자
    private LocalDateTime inputDate;    //작성날짜
    private String obtnMk;              //비고
    private String updateId;            //최종수정자
    private LocalDateTime updateDate;   //최종수정날짜

    private Integer mony;               //수주금액

    private Long compId;
    private String compNm;
    private String compAdr;


}
