package com.bismo.stellive.api.obtnDtl.dto;


import com.bismo.stellive.api.ItemHdr.ItemHdr;
import com.bismo.stellive.api.obtnDtl.ObtnDtl;
import com.bismo.stellive.api.obtnHdr.ObtnHdr;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObtnDtlRequest {

    //PK
    private Long id;

    //수주번호
    private ObtnHdr obtnHdr;

    //정렬순서
    private String sortIndex;

    //아이템코드
    private ItemHdr itemHdr;

    //수주금액
    private Integer obtnMony;
    //수주량
    private Integer obtnAmt;

    // 현재 위치 상태
    private ObtnDtl.Status status;

    //저장
    private Integer rgstId;
    private LocalDateTime rgstDt;

    //업데이트
    private Integer updtId;
    private LocalDateTime updtDt;

}
